package model.entidades;

import java.util.Date;

public class Parcela {

    private Date vencimento;
    private double quantidade;

    public Parcela(Date vencimento, double quantidade) {
        this.vencimento = vencimento;
        this.quantidade = quantidade;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }
}
