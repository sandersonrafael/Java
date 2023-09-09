import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    int x;
    Scanner sc = new Scanner(System.in);
    System.out.println("Digite um valor inteiro de 0 a 10");
    x = sc.nextInt();

    String resultado = (x > 5) ? "maior que cinco" : "menor ou igual a cinco";
    System.out.println("O valor informado é " + resultado);

    sc.close();
  }
}