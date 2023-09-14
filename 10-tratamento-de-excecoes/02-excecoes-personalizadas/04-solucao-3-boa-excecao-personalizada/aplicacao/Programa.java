package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entidades.Reserva;
import model.excecoes.ExcecaoDeDominio;

public class Programa {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    try {
      System.out.print("Número do quarto: ");
      int quarto = sc.nextInt();
      System.out.print("Data de entrada (dd/MM/aaaa): ");
      Date entrada = sdf.parse(sc.next());
      System.out.print("Data de saída (dd/MM/aaaa): ");
      Date saida = sdf.parse(sc.next());

      Reserva reserva = new Reserva(quarto, entrada, saida);
      System.out.println(reserva);

      System.out.println("Informe uma nova data para atualizar a reserva");
      System.out.print("Data de entrada (dd/MM/aaaa): ");
      entrada = sdf.parse(sc.next());

      System.out.print("Data de saída (dd/MM/aaaa): ");
      saida = sdf.parse(sc.next());

      // pode retornar um erro ou null
      reserva.atualizarDatas(entrada, saida);
      System.out.println(reserva);
    } catch (ParseException e) {
      System.out.println("Formato inválido de data.");
    } catch (ExcecaoDeDominio e) {
      System.out.println("Erro na reserva: " + e.getMessage());
    }
    // por segurança, podemos usar um outro bloco catch com o tipo RuntimeException, para qualquer exceção em execução
    // ou ainda, podemos usar a classe Throwable, que representa erros mais genéricos que Exception ou RuntimeException
    catch (Throwable e) { // ex, digitar um nome onde pede número do quarto
      System.out.println("Ocorreu um erro inesperado.");
    }
    sc.close();
  }
}
