package internals;

public class References {
  public static void main(String[] args) {
    Integer a = 300;
    Integer b = 300;
    System.out.println(a == b); // false
    Integer c  = 100;
    Integer d  = 100;
    System.out.println(a == b); // true

  }
}
