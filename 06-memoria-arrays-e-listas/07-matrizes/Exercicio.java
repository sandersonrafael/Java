import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Exercicio {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    System.out.println("Quantas linhas / colunas a matriz terá?");
    int n = sc.nextInt();

    int[][] matriz = new int[n][n];
    List<Integer> negativos = new ArrayList<>();
    List<Integer> diagonalPrincipal = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.printf("Qual o valor da linha %d, coluna %d?%n", i + 1, j + 1);
        int numero = sc.nextInt();
        matriz[i][j] = numero;

        if (i == j) diagonalPrincipal.add(numero);
        if (numero < 0) negativos.add(numero);
      }
    }

    System.out.println("A diagonal principal possui os números:");
    for (Integer numero : diagonalPrincipal) System.out.printf("%d ", numero);
    System.out.println("");

    if (negativos.size() > 0)
      System.out.printf("Quantidade de negativos: %d%nNúmeros: ", negativos.size());

    for (Integer negativo : negativos) System.out.printf("%d ", negativo);

    sc.close();
  }
}
