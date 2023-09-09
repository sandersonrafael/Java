public class Main {
  public static void main (String[] args) {
    int x = 0;
    while (x <= 10) {
      System.out.println("O valor de x é: " + x);
      x += 1;
    }

    do {
      x -= 1;
      System.out.println("O valor de x é: " + x);
    } while (x > 0);
  }
}