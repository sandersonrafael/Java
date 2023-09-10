package entidades;

public class Produto {
  public String nome;
  public double preco;
  public int quantidade;

  public double valorTotalEmEstoque() {
    return quantidade * preco;
  }

  public void adicionarProdutos(int qnt) {
    quantidade += qnt;
  }

  public void removerProdutos(int qnt) {
    quantidade = quantidade - qnt > 0 ? quantidade - qnt : 0;
  }

  public String toString() {
    String und = quantidade != 1 ? "unidades" : "unidade";
    return nome
    + ", $ "
    + String.format("%.2f", preco)
    + ", "
    + quantidade
    + " "
    + und
    + ", Total: "
    + String.format("%.2f", valorTotalEmEstoque());
  }
}
