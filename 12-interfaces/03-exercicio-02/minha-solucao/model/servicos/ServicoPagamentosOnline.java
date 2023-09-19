package model.servicos;

public interface ServicoPagamentosOnline {
    public double taxa(double valor);
    public double juros(double valor, int meses);
}
