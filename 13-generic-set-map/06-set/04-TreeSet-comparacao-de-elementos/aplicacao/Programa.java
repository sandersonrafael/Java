package aplicacao;

import java.util.Set;
import java.util.TreeSet;

import entidades.Produto;

public class Programa {
    public static void main(String[] args) {

        Set<Produto> set = new TreeSet<>();

        // se a classe Produto não implementar Comparable e não tiver o método compareTo
        // apresenta erro para o TreeSet assim que adicinoar qualquer item, pois não possui
        // um método próprio de ordenação para o TreeSet
        set.add(new Produto("TV", 900.0));
        set.add(new Produto("Notebook", 1200.0));
        set.add(new Produto("Bicicleta", 1000.0));

        for (Produto p : set) {
            System.out.println(p);
        }
    }
}
