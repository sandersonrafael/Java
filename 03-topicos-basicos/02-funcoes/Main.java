// receber 3 números na tela e mostrar o maior deles

import java.util.Scanner;

public class Main {
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Digite 3 números: ");
    int x, y, z, resultado;
    x = sc.nextInt();
    y = sc.nextInt();
    z = sc.nextInt();
    resultado = max(x, y, z);

    printResult(resultado);

    sc.close();
  }

  public static int max(int x, int y, int z) {
    int maior = (x > y) ? (x >= z) ? x : z : (y >= z) ? y : z;
    return maior;
  }

  public static void printResult(int resultado) {
    System.out.println("O maior valor é: " + resultado);
  }
}
