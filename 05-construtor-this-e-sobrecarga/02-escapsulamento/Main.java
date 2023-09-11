import java.util.Locale;
import java.util.Scanner;

import entidades.Produto;

public class Main {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    System.out.println("Digite o nome do produto:");
    String nome = sc.nextLine();

    System.out.println("Digite o preço do produto:");
    double preco = sc.nextDouble();

    Produto produto = new Produto(nome, preco);

    produto.setNome("Ultra Mega Blaster Produto");
    produto.setPreco(1500.999);

    System.out.println(produto);
    System.out.println("Novo nome do produto: " + produto.getNome());
    System.out.println("Novo preço do produto: " + produto.getPreco());

    sc.close();
  }
}