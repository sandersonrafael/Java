package modelo.servicos;

public class ServicoJurosEua implements ServicoJuros {
    private double taxaDeJuros;

    public ServicoJurosEua(double taxaDeJuros) {
        this.taxaDeJuros = taxaDeJuros;
    }

    @Override
    public double getTaxaDeJuros() {
        return taxaDeJuros;
    }
}
