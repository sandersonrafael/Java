package aplicacao;

import entidades.ContaBancaria;
import entidades.ContaEmpresarial;
import entidades.ContaPoupanca;

public class Programa {
  public static void main(String[] args) {
    /* Sobreposição @Override */
    ContaBancaria conta1 = new ContaBancaria(1001, "Alex", 1000.0);
    conta1.saque(200.0);
    System.out.println("Valor deve ser 795.0, pois foi retirado 200.0 '+ 5.0': " + conta1.getBalanco());

    ContaBancaria conta2 = new ContaPoupanca(1002, "Maria", 1000.0, 0.05);
    conta2.saque(200.0);
    System.out.println("Valor deve ser 800.0, pois foi retirado 200.0: " + conta2.getBalanco());

    /* Palavra super no @Override */
    ContaBancaria conta3 = new ContaEmpresarial(1003, "Loja de Açaí", 1000.0, 200.0);
    conta3.saque(200);
    System.out.println("Deve ser 793.0, pois será retirado 200.0 (+ 5) (+ 2): " + conta3.getBalanco());
  }
}
