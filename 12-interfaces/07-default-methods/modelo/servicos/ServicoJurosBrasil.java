package modelo.servicos;

public class ServicoJurosBrasil implements ServicoJuros {
    private double taxaDeJuros;

    public ServicoJurosBrasil(double taxaDeJuros) {
        this.taxaDeJuros = taxaDeJuros;
    }

    @Override
    public double getTaxaDeJuros() {
        return taxaDeJuros;
    }
}
