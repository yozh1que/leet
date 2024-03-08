package conc;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

public class ProducerConsumer {

  private Object lock = new Object();
  private Deque<Integer> stack = new LinkedList<>();

  class Consumer implements Runnable {

    @Override
    public void run() {
      try {
        while (!Thread.interrupted()) {
          synchronized (lock) {
            lock.wait();
          }

          if (!stack.isEmpty()) {
            Integer value = stack.pop();
            System.out.println("Consumed value: " + value);
            synchronized (lock) {
              lock.notify();
            }
          }
        }
      } catch (InterruptedException e) {
      }
    }

  }

  class Producer implements Runnable {

    private Integer value = 0;

    @Override
    public void run() {
      try {
        while (!Thread.interrupted()) {
          Thread.sleep(new Random().nextInt(2000));
          if (stack.isEmpty()) {
            stack.push(++value);
            System.out.println("Produced value: " + value);

            synchronized (lock) {
              lock.notify();
            }


            synchronized (lock) {
              lock.wait();
            }

          }
        }
      } catch (InterruptedException e) {
      }
    }

  }

  void start() throws InterruptedException {
    Thread producer = new Thread(new Producer());
    producer.start();
    Thread consumer = new Thread(new Consumer());
    consumer.start();
    Thread.sleep(10000);
    producer.interrupt();
    consumer.interrupt();
    producer.join();
    consumer.join();
    System.out.println("Complete");
  }


  public static void main(String[] args) {
    ProducerConsumer pc = new ProducerConsumer();
    try {
      pc.start();
    } catch (InterruptedException e) {

    }

  }
}

