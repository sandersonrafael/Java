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
        return "Produto [nome=" + nome + ", preco=" + preco + "]";
    }

    /* Forma 2 */
    public static boolean PredicadoDoProdutoEstatico(Produto p) {
        return p.getPreco() >= 100.0;
    }

    /* Forma 3 */
    public boolean PredicadoDoProdutoNaoEstatico() {
        return preco >= 100.0;
    }
}
