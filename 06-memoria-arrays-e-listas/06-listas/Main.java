import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    // Lista<TipoDeLista> nomeDaLista = new ClasseQueImplementaInterfaceDeLista;
    // -> não aceita tipos primitivos como int | ArrayList é o mais otimizado (preferencial)
    // necessário informar Classe Integer em vez de tipo int
    List<String> list = new ArrayList< /* String */>(); // o <String> no ArrayList é opcional

    // inserção de elementos
    list.add("João");
    list.add("Maria");
    list.add("Pedim");
    list.add("Dedé");
    list.add(2, "Um Metido"); // adicionando no indice n
    list.add("Marcela");

    // tamanho da lista
    System.out.printf("Tamanho da lista: " + list.size() + "%n%n");

    for (String nome : list) {
      System.out.println(nome);
    }
    System.out.println("");

    // deleção de elementos
    list.remove("Pedim");

    // deleção com predicados: usa-se n talQual condição, ou (n -> boolean == true)
    // predicado == função lambda
    list.removeIf(x -> x.charAt(0) == 'M');

    for (String nome : list) {
      System.out.println(nome);
    }
    System.out.println("");

    System.out.println("Índice de Dedé: " + list.indexOf("Dedé"));
    System.out.println("Índice de Pedim: " + list.indexOf("Pedim"));

    System.out.printf("%nTamanho da lista: " + list.size());
    System.out.println("");
    System.out.println("");

    // filtrar somente quem tem a letra e
    List<String> possuemLetraE;

    // necessário converter para stream() para poder usar operações lambda
    // depois é necessário converter de volta para lista com .toList(); ou
    // o método .collect(Collectors.toList()) -> mais flexível com versões antigas
    possuemLetraE = list.stream().filter(x -> x.indexOf("e") != -1).collect(Collectors.toList());

    for (String item : possuemLetraE) {
      System.out.println(item);
    }
    System.out.printf("%nTamanho da lista: " + possuemLetraE.size());
    System.out.printf("%n%n");


    // obter um elemento que atende certo predicado
    String nome = list.stream().filter(x -> x.charAt(0) == 'D').findFirst().orElse(null);

    System.out.printf("O nome obtido que começa com a letra D, é: " + nome + "%n%n");
  }
}
