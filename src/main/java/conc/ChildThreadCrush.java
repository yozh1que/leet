package conc;

public class ChildThreadCrush {
  public static void main(String[] args) throws InterruptedException {
    Thread child = new Thread(() -> {
      throw new IllegalArgumentException();
    });

    child.setUncaughtExceptionHandler((t, e) -> {
      System.out.println(e.toString());
    });
    child.start();
    child.join();

    System.out.println("Sleeping..");
    Thread.sleep(5000);
    System.out.println("Complete, child state: " + child.getState());
  }
}
