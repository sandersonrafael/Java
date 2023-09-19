package modelo.servicos;

import java.security.InvalidParameterException;

public interface ServicoJuros {
    double getTaxaDeJuros();

    // modificador default permite que seja possível adicionar funções nas próprias interfaces,
    // mas só com valores e atributos que elas possuem dentro delas, como esse caso do getTaxaDejuros()
    default double pagamento(double quantidade, int meses) {
        if (meses < 1) throw new InvalidParameterException("Meses não podem estar abaixo de um");
        return quantidade * Math.pow(1.0 + getTaxaDeJuros() / 100, meses);
    }
}
