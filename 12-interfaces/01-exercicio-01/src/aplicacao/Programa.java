package aplicacao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entidades.AluguelCarro;
import model.entidades.Veiculo;

public class Programa {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Entre com os dados do aluguel");
        System.out.print("Modelo do carro: ");
        Veiculo modeloCarro = new Veiculo(sc.nextLine());

        System.out.println("Data e hora da locação (dd/MM/aaaa hh:mm): ");
        LocalDateTime inicioAluguel = LocalDateTime.parse(sc.nextLine(), dtf);

        System.out.println("Data e hora da devolução (dd/MM/aaaa hh:mm): ");
        LocalDateTime fimAluguel = LocalDateTime.parse(sc.nextLine(), dtf);

        AluguelCarro ac = new AluguelCarro(inicioAluguel, fimAluguel, modeloCarro);

        sc.close();
    }
}
