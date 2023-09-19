package model.servicos;

public class ServicoPaypal implements ServicoPagamentosOnline {

    public double taxa(double valor) {
        return valor * .02;
    }

    public double juros(double valor, int meses) {
        return valor * meses * .01;
    }
}
