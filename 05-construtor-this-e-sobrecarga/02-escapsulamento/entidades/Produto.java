package entidades;

public class Produto {
  // utiliza-se o private para fazer com que o atributo não seja acessível fora da classe
  private String nome;
  private double preco;

  public Produto(String nome, double preco) {
    this.nome = nome;
    this.preco = preco;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public double getPreco() {
    return preco;
  }

  public void setPreco(double preco) {
    this.preco = preco;
  }

  public String toString() {
    return "O produto: " + nome + " custa R$ " + String.format("%.2f", preco);
  }
}
