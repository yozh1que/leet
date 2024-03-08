package conc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<T> {

  private final int capacity;

  private final Queue<T> queue = new LinkedList<>();

  private final ReentrantLock monitor = new ReentrantLock();
  private final Condition notFull = monitor.newCondition();
  private final  Condition notEmpty = monitor.newCondition();

  public BlockingQueue(int capacity) {
    this.capacity = capacity;
  }

  public void add(T item) throws InterruptedException {
    monitor.lock();
    try {
      if (queue.size() >= capacity) {
        notFull.await();
      }
      queue.add(item);
      notEmpty.signal();
    } finally {
      monitor.unlock();
    }
  }

  public T remove() throws InterruptedException {
    monitor.lock();
    try {
      if (queue.isEmpty()) {
        notEmpty.await();
      }
      T item = queue.remove();
      notFull.signal();
      return item;
    } finally {
      monitor.unlock();
    }
  }

  public static void main(String[] args) throws InterruptedException {
    BlockingQueue<Integer> queue = new BlockingQueue<Integer>(1);

    Thread producer = new Thread(() -> {
      int i = 10;
      while (!Thread.interrupted() && i > 0) {
        try {
          queue.add(i);
          System.out.println("sent " + i);
        } catch (InterruptedException e) {
          return;
        }
        i--;
      }
    });
    Thread consumer = new Thread(() -> {
      while (!Thread.interrupted()) {
        try {
          Integer item = queue.remove();
          System.out.println("received " + item);
        } catch (InterruptedException e) {
          return;
        }
      }
    });

    producer.start();
    consumer.start();
    producer.join();
    consumer.interrupt();
    System.out.println("complete, producer state: " + producer.getState() + ", consumer state: " + consumer.getState());
  }
}
