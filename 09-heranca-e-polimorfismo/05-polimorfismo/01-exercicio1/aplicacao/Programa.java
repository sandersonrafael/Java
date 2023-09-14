package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Funcionario;
import entidades.FuncionarioTerceirizado;

public class Programa {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    // A Lista de Funcionario aceita tanto Funcionario quanto FuncionarioTerceirizado,
    // apesar das estruturas um pouco diferentes, mas FuncionarioTerceirizado é um Funcionario
    List<Funcionario> funcionarios = new ArrayList<>();

    System.out.print("Informe a quantidade de funcionários da empresa: ");
    int numeroDeFuncionarios = sc.nextInt();

    for (int i = 1; i <= numeroDeFuncionarios; i++) {
      System.out.println("Dados do Funcionário " + i + ":");
      System.out.print("O funcionário é terceirizado (S/N)? ");
      char terceirizado = sc.next().toUpperCase().charAt(0);
      sc.nextLine();

      System.out.print("Nome do funcionário: ");
      String nome = sc.nextLine();

      System.out.print("Jornada de trabalho (em horas inteiras): ");
      int horas = sc.nextInt();

      System.out.print("Salário por hora: ");
      double salarioHora = sc.nextDouble();

      Funcionario funcionario;

      if (terceirizado == 'S') {
        System.out.print("Despesa do funcionário: ");
        double despesa = sc.nextDouble();
        funcionario = new FuncionarioTerceirizado(nome, horas, salarioHora, despesa);
      } else funcionario = new Funcionario(nome, horas, salarioHora);

      funcionarios.add(funcionario);
      System.out.println(funcionario);
    }

    for (Funcionario funcionario: funcionarios) {
      System.out.println(
        funcionario.getNome()
        + " - R$ "
        + String.format("%.2f", funcionario.pagamento()).replace(".", ",")
      );
    }
    

    sc.close();
  }
}
