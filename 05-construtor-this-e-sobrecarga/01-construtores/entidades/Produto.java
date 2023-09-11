package entidades;

public class Produto {

  public String nome;
  public double preco;
  public int quantidade;

  // para adicionar um construtor padrão, basta inserir um construtor vazio:
  public Produto() {}

  // para adicionar um construtor, basta utilizar a seguinte sintaxe:
  public Produto(String nome, double preco, int quantidade) {
    this.nome = nome;
    this.preco = preco;
    this.quantidade = quantidade;
  }

  // sobrecarga -> adicionar novo construtor com entradas diferentes
  // pode ser usado para atribuir valores padrões, como quantidade = 0
  // porém, 0 é valor padrão no Java para ints, não sendo necessário
  public Produto(String nome, double preco) {
    this.nome = nome;
    this.preco = preco;
    // quantidade = 0; // não precisa do this porque não possui um "quantidade" no escopo
  }

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
