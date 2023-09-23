package aplicacao;

import java.util.ArrayList;
import java.util.List;

import entidades.Produto;
import servicos.ServicoProduto;

public class Programa {
    public static void main(String[] args) {
        List<Produto> lista = new ArrayList<>();

        lista.add(new Produto("Tv", 900.00));
        lista.add(new Produto("Mouse", 50.00));
        lista.add(new Produto("Tablet", 350.50));
        lista.add(new Produto("HD Case", 80.90));

        ServicoProduto sp = new ServicoProduto();

        // foi passado um Predicate com expressões lambda, que testam a condição dentro do
        // ServicoProduto
        double soma = sp.somaFiltrada(lista, p -> p.getNome().charAt(0) == 'T');
        System.out.println("Soma: " + String.format("%.2f", soma));

        soma = sp.somaFiltrada(lista, p -> p.getNome().charAt(0) == 'M');
        System.out.println("Soma: " + String.format("%.2f", soma));
    }
}
