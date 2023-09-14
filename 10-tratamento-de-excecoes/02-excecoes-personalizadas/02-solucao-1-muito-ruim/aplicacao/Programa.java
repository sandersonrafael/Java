package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entidades.Reserva;

public class Programa {
  // throws ParseException -> significa que o método main é "autorizado" a lancar excecoes
  // significa que propaga
  public static void main(String[] args) throws ParseException {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    System.out.print("Número do quarto: ");
    int quarto = sc.nextInt();

    System.out.print("Data de entrada (dd/MM/aaaa): ");
    Date entrada = sdf.parse(sc.next());

    System.out.print("Data de saída (dd/MM/aaaa): ");
    Date saida = sdf.parse(sc.next());

    // método after dos Dates verifica se é uma data posteiror, o ! inverte para false
    if (!saida.after(entrada)) {
      System.out.println("Erro na reserva: a data de saída não pode ser anterior à data de entrada.");
    } else {
      Reserva reserva = new Reserva(quarto, entrada, saida);
      System.out.println(reserva);

      System.out.println("Informe uma nova data para atualizar a reserva");
      System.out.print("Data de entrada (dd/MM/aaaa): ");
      entrada = sdf.parse(sc.next());

      System.out.print("Data de saída (dd/MM/aaaa): ");
      saida = sdf.parse(sc.next());

      Date hoje = new Date();
      if (entrada.before(hoje) || saida.before(hoje)) {
        System.out.println("Erro no reagendamento: as datas do reagendamento devem estar no futuro.");
      } else if (!saida.after(entrada)) {
        System.out.println("Erro na reserva: a data de saída não pode ser anterior à data de entrada.");
      } else {
        reserva.atualizarDatas(entrada, saida);
        System.out.println(reserva);
      }
    }
    sc.close();
  }
}
