package aplicacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import entidades.Produto;

public class Programa {
    public static void main(String[] args) {
        List<Produto> lista = new ArrayList<>();

        lista.add(new Produto("TV", 900.00));
        lista.add(new Produto("Notebook", 1200.00));
        lista.add(new Produto("Tablet", 450.00));

        Collections.sort(lista);

        System.out.println(lista);
    }
}
