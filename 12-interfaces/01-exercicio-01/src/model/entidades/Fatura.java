package model.entidades;

public class Fatura {
    private Double valorBase;
    private Double tributo;

    public Fatura(Double valorBase, Double tributo) {
        this.valorBase = valorBase;
        this.tributo = tributo;
    }

    public Double getValorBase() {
        return valorBase;
    }

    public void setValorBase(Double valorBase) {
        this.valorBase = valorBase;
    }

    public Double getTributo() {
        return tributo;
    }

    public void setTributo(Double tributo) {
        this.tributo = tributo;
    }

    public Double getValorTotal() {
        return getValorBase() - getTributo();
    }
}
