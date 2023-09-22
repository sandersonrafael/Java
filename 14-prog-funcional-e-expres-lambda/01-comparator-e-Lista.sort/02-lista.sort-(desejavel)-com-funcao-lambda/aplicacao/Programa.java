package aplicacao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import entidades.Produto;

public class Programa {
    public static void main(String[] args) {
        List<Produto> lista = new ArrayList<>();

        lista.add(new Produto("TV", 900.00));
        lista.add(new Produto("Notebook", 1200.00));
        lista.add(new Produto("Tablet", 450.00));

        // Comparator<Produto> comparador = new Comparator<Produto>() {
        //     @Override
        //     public int compare(Produto p1, Produto p2) {
        //         return p1.getNome().toUpperCase().compareTo(p2.getNome().toUpperCase());
        //     }
        // };

        // tudo isso pode ser substituído por uma expressão lambda
        // similar às arrow functions do JavaScript
        // Comparator<Produto> comparador = (p1, p2) -> p1.getNome().toUpperCase().compareTo(p2.getNome().toUpperCase());

        // por último, posso ainda passar a função lambda ou arrow function diretamente para o sorte

        // lista.sort(uma classe que implementa o Comparator<Classe>)
        // dessa maneira, a classe do produto não precisa ficar sendo alterada,
        // somente a própria classe comparador
        lista.sort((p1, p2) -> p1.getNome().toUpperCase().compareTo(p2.getNome().toUpperCase()));
        // (/* comparador *//* new MeuComparador() */);
        // também é possível criar um método direto do new Comparator<Classe> como mostrado acima

        for (Produto p : lista) {
            System.out.println(p);
        }
    }
}
