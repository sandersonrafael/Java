package model.services;

import java.time.Duration;

import model.entidades.AluguelCarro;
import model.entidades.Fatura;

public class ServicoDeAluguel {
    private Double precoPorHora;
    private Double precoPorDia;

    // aproveita todas classes que cumprem o contrato da interface para a variável
    // é similar a usar um tipo mais genérico e atribuir a um objeto que é "filho" dele
    private ServicoImpostoInterface servicoDeImposto;

    public ServicoDeAluguel(Double precoPorHora, Double precoPorDia, ServicoImpostoInterface servicoDeImposto) {
        this.precoPorHora = precoPorHora;
        this.precoPorDia = precoPorDia;
        this.servicoDeImposto = servicoDeImposto;
    }

    public Double getPrecoPorHora() {
        return precoPorHora;
    }

    public void setPrecoPorHora(Double precoPorHora) {
        this.precoPorHora = precoPorHora;
    }

    public Double getPrecoPorDia() {
        return precoPorDia;
    }

    public void setPrecoPorDia(Double precoPorDia) {
        this.precoPorDia = precoPorDia;
    }

    public void processarFatura(AluguelCarro aluguelCarro) {
        double minutos = Duration.between(aluguelCarro.getInicio(), aluguelCarro.getFim()).toMinutes();
        double horas = minutos / 60;
        double dias = horas / 24;

        double valorBase = horas < 12
            ? Math.ceil(horas) * precoPorHora
            : Math.ceil(dias) * precoPorDia;

        double imposto = servicoDeImposto.imposto(valorBase);
        aluguelCarro.setFatura(new Fatura(valorBase, imposto));
    }
}
