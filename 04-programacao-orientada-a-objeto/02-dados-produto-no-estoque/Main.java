import java.util.Locale;
import java.util.Scanner;

import entidades.Produto;

public class Main {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    Produto produto = new Produto();

    System.out.println("Insira os dados do produto...");

    System.out.print("Nome: ");
    produto.nome = sc.nextLine();

    System.out.print("Preço: ");
    produto.preco = sc.nextDouble();

    System.out.print("Quantidade: ");
    produto.quantidade = sc.nextInt();
    
    System.out.println("Dados do produto: " + produto);

    System.out.print("Entre com a quantidade de produtos a serem adicionados ao estoque: ");
    produto.adicionarProdutos(sc.nextInt());
    System.out.println("Dados atualizados: " + produto);

    System.out.print("Entre com a quantidade de produtos a serem removidos do estoque: ");
    produto.removerProdutos(sc.nextInt());
    System.out.println("Dados atualizados: " + produto);

    sc.close();
  }
}
