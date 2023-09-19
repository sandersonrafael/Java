package model.servicos;

import model.entidades.Contrato;

public class ServicoContrato {

    public void processarContrato(Contrato contrato, int meses, ServicoPagamentosOnline spo) {
        double parcelaBase = contrato.getValorTotal() / meses;

        for (int i = 1; i <= meses; i++) {
            double juros = spo.juros(parcelaBase, i);
            double taxa = spo.taxa(parcelaBase + juros);
            double valorParcelaFinal = parcelaBase + juros + taxa;
            contrato.setParcelas(i, valorParcelaFinal);
        }
    }
}
