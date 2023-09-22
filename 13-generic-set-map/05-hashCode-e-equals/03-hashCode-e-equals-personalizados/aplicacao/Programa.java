package aplicacao;

import entidades.Cliente;

public class Programa {
  public static void main(String[] args) {
    Cliente cliente1 = new Cliente("Fulano", "email@email.com");
    Cliente cliente2 = new Cliente("Ciclano", "email2@email.com");
    Cliente cliente3 = new Cliente("Fulano", "email@email.com");

    System.out.println(cliente1.hashCode());
    System.out.println(cliente2.hashCode());
    System.out.println(cliente3.hashCode());
    System.out.println(cliente1.equals(cliente2));
    System.out.println(cliente1.equals(cliente3));

    System.out.println("Operador de igualdade: " + (cliente1 == cliente2));

    String s1 = "Teste";
    String s2 = "Teste";

    System.out.println("Comparação de Strings literais: s1 == s2: " + (s1 == s2));

    s1 = new String("Teste");
    s2 = new String("Teste");

    System.out.println("Comparação de Strings instanciadas: s1 == s2: " + (s1 == s2));
  }
}
