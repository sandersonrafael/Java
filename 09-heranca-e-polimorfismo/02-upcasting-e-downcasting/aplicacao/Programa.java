package aplicacao;

import entidades.ContaBancaria;
import entidades.ContaEmpresarial;
import entidades.ContaPoupanca;

public class Programa {
  public static void main(String[] args) {
    ContaBancaria contaBancaria = new ContaBancaria(1001, "Alex", 0.0);
    ContaEmpresarial contaEmpresarial = new ContaEmpresarial(1002, "Comercio Eletronico SA", 0.0, 10000.0);

    /* Upcasting */
    // relação "é-um", onde "ContaEmpresarial ou ContaPoupanca" é uma "ContaBancaria"
    // por isso aceita instâncias que representam subclasses de "ContaBancaria"
    ContaBancaria contaTeste = contaEmpresarial;
    ContaBancaria contaTeste2 = new ContaEmpresarial(1003, "Empresa2", 0.0, 200.0);
    ContaBancaria contaTeste3 = new ContaPoupanca(1004, "Lucas", 0.0, 0.05);

    /* Downcasting */
    // nesse caso é necessário realizar o casting manual (conversão)
    ContaEmpresarial contaTeste4 = (ContaEmpresarial) contaTeste2; // erro se não fizer casting
    contaTeste4.emprestimo(100.0);
    // contaTeste2.emprestimo(100.0); -> erro pois contaTeste2 é do tipo ContaBancaria e não ContaEmpresarial

    /* ContaEmpresarial contaTeste5 = (ContaEmpresarial) contaTeste3; */
    // Nesse caso, está se convertendo uma ContaPoupanca para uma ContaEmpresarial, onde
    // estas duas são irmãs e filhas de ContaBancaria, não sendo compatível essa conversão,
    // apesar de não apresentar erro durante escrita, em tempo de execução apresenta

    /* Solução */
    
    // o (variavel instanceof Classe) verifica se a variável pode ser instância da Classe e retorna true ou false
    ContaEmpresarial contaTeste5;
    if (contaTeste3 instanceof ContaEmpresarial) {
      contaTeste5 = (ContaEmpresarial) contaTeste3;
      contaTeste5.emprestimo(100.0);
      System.out.println("Empréstimo realizado na contaTeste5");
    }

    ContaPoupanca contaTeste6;
    if (contaTeste3 instanceof ContaPoupanca) {
      contaTeste6 = (ContaPoupanca) contaTeste3;
      contaTeste6.atualizarBalanco();
      System.out.println("Atualizado balanço da contaTeste6");
    }

    System.out.println("Sem erros");

    System.out.println(String.format("", contaBancaria));
    System.out.println(String.format("", contaTeste));
  }
}
