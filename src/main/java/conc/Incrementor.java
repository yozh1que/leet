package conc;

public class Incrementor {

  private int count;

  public synchronized void inc() {
    if (count < 10) {
      count++;
      inc();
    }
  }

  public static void main(String[] args) {
    new Incrementor().inc();
  }
}
