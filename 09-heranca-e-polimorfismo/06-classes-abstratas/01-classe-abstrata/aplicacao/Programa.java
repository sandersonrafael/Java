package aplicacao;

import java.util.ArrayList;
import java.util.List;

import entidades.ContaBancaria;
import entidades.ContaEmpresarial;
import entidades.ContaPoupanca;

public class Programa {
  public static void main(String[] args) {
    // ContaBancaria conta = new ContaBancaria(1001, "Mariana", 2000.0); -> não pode ser instanciado
    ContaBancaria contaPoupanca = new ContaPoupanca(1002, "Mariete", 2500.0, .05);
    ContaBancaria contaEmpresarial = new ContaEmpresarial(1003, "ACAI E CIA", 3000.0, 10000.0);

    // vantagem de ter uma classe mais genérica apesar de abstrata
    List<ContaBancaria> contas = new ArrayList<>();
    contas.add(contaPoupanca);
    contas.add(contaEmpresarial);
    contas.add(new ContaEmpresarial(1003, "MOTONAUTAS", 8000.0, 12000.0));

    // é possível realizar operacoes com todos os termos através de listas
    // saldo total em todas contas
    double soma = 0.00;
    for (ContaBancaria conta: contas) {
      soma += conta.getBalanco();
    }
    System.out.println("O valor total em todas as contas é: R$ " + String.format("%.2f", soma).replace(".", ","));
  }
}
