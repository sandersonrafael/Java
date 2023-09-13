package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.Contrato;
import entidades.Departamento;
import entidades.Funcionario;
import enums.Senioridade;

public class Programa {
  public static void main(String[] args) throws ParseException {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    System.out.print("Informe o nome do departamento: ");
    String nomeDepartamento = sc.nextLine();

    System.out.println("Dados do funcionário");
    System.out.print("Nome: ");
    String nomeFuncionario = sc.nextLine();

    System.out.print("Senioridade (JUNIOR, PLENO OU SENIOR): ");
    String senioridadeFuncionario = sc.nextLine();

    System.out.print("Salário base: ");
    double salarioBaseFuncionario = sc.nextDouble();

    Funcionario funcionario = new Funcionario(
      nomeFuncionario,
      Senioridade.valueOf(senioridadeFuncionario),
      salarioBaseFuncionario,
      new Departamento(nomeDepartamento)
    );

    System.out.printf("Quantos contratos o funcionário possui?%nNúmero de contratos: ");
    int n = sc.nextInt();

    for (int i = 1; i <= n; i++) {
      System.out.println("Dados do " + i + "º contrato");
      System.out.print("Informe a data (DD/MM/AAAA): ");
      Date data = sdf.parse(sc.next());

      System.out.print("Pagamento por hora trabalhada: ");
      double pagamentoPorHora = sc.nextDouble();

      System.out.print("Quantidade de horas trabalhadas: ");
      int horas = sc.nextInt();

      funcionario.adicionarContrato(new Contrato(data, pagamentoPorHora, horas));
    }

    System.out.print("Informe um mês e um ano (MM/AAAA) para verificar a receita total neste período: ");
    String data = sc.next();
    int mes = Integer.parseInt(data.substring(0, 2));
    int ano = Integer.parseInt(data.substring(3));

    System.out.println(
      "O trabalhador "
      + funcionario.getNome()
      + ", do departamento "
      + funcionario.getDepartamento().getNome()
      + ", recebeu "
      + String.format("R$ %.2f", funcionario.rendaNoPeríodo(ano, mes)).replace(".", ",")
      + " no período informado."
    );

    sc.close();
  }
}
