package entidades;

public class Produto {
    private String nome;
    private Double preco;

    public Produto(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto [nome=" + nome + ", preco=" + String.format("%.2f", preco) + "]";
    }

    public static String nomeEmCaixaAltaEstatico(Produto produto) {
        return produto.getNome().toUpperCase();
    }

    public String nomeEmCaixaAltaNaoEstatico() {
        return nome.toUpperCase();
    }
}