package model.services;

public class ServicoDeImpostos implements ServicoImpostoInterface {
    public double imposto(double quantidade) {
        return quantidade * (quantidade > 100.0 ? .15 : .2);
    }
}
