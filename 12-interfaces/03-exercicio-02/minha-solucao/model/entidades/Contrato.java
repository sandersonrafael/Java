package model.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contrato {

    private int numero;
    private Date data;
    private double valorTotal;

    private List<Parcela> parcelas = new ArrayList<>(numero);

    public Contrato(int numero, Date data, double valorTotal) {
        this.numero = numero;
        this.data = data;
        this.valorTotal = valorTotal;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Parcela> getParcelas() {
        return parcelas;
    }

    public void setParcelas(int numeroDaParcela, double valorDaParcela) {
        long tempoVencimentoMs = 1000L * 60 * 60 * 24 * 30 * numeroDaParcela;
        long dataVencimentoMs = data.getTime() + tempoVencimentoMs;
        Date vencimento = new Date(dataVencimentoMs);

        parcelas.add((numeroDaParcela - 1), new Parcela(vencimento, valorDaParcela));
    }
}
