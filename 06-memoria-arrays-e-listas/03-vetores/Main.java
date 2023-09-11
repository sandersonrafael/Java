// exercício 1 -> programa lê int n e altura de n pessoas. Armazena um vetor com essas alturas
/* 
import java.util.Locale;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    System.out.println("Digite o número de pessoas da amostra de alturas:");
    int n = sc.nextInt();

    double[] vetor = new double[n];
    double soma = 0;

    for (int i = 0; i < n; i++) {
      System.out.printf("Qual a altura da %dª pessoa?%n", i + 1);
      vetor[i] = sc.nextDouble();
      soma += vetor[i];
    }

    String media = String.format("%.2f", soma / n);

    System.out.println("A média das alturas informadas é: " + media);
    sc.close();
  }
}
*/

// exercicio 2 -> programa lê int n de produtos com nome e preço. Cada i do vetor possui um produto
// mostrar o preço médio dos produtos
// necessário instanciar porque cada valor do vetor é somente uma referência

import java.util.Locale;
import java.util.Scanner;

import entidades.Produto;

public class Main {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    System.out.println("Quantos produtos deseja adicionar ao estoque?");
    int n = sc.nextInt();

    Produto[] produtos = new Produto[n];

    double somaDosPrecos = 0.00;

    for (int i = 0; i < produtos.length; i++) {
      sc.nextLine();

      System.out.printf("Digite o nome do %dº produto:%n", i + 1);
      String nome = sc.nextLine();

      System.out.printf("Digite o preço do %dº produto:%n", i + 1);
      double preco = sc.nextDouble();

      produtos[i] = new Produto(nome, preco); // instância
      somaDosPrecos += produtos[i].getPreco();
    }

    for (int i = 0; i < produtos.length; i++) {
      System.out.println("Produto " + (i + 1) + " " + produtos[i]);
    }

    double media = somaDosPrecos / produtos.length;

    System.out.printf("A média dos preços dos produtos é: R$ %.2f%n", media);

    sc.close();
  }
}
