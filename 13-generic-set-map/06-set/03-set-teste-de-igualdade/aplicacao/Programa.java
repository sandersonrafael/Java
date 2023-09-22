package aplicacao;

import java.util.HashSet;
import java.util.Set;

import entidades.Produto;

public class Programa {
    public static void main(String[] args) {

        Set<Produto> set = new HashSet<>();

        set.add(new Produto("TV", 900.0));
        set.add(new Produto("Notebook", 1200.0));
        set.add(new Produto("TV", 400.0));

        Produto produto = new Produto("Notebook", 1200.0);

        // antes de gerar o hashCode e o equals, dá false
        // após: true, pois agora compara com base no nome e no preço e não na referência
        // a referência sim daria false, devido serem duas referências diferentes, apesar de
        // produtos iguais em valores
        System.out.println(set.contains(produto));
    }
}
