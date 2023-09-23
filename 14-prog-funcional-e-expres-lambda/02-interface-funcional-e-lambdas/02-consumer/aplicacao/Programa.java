package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import entidades.Produto;
import util.AtualizarPrecos;

public class Programa {
    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();

        produtos.add(new Produto("Tv", 900.00));
        produtos.add(new Produto("Mouse", 50.00));
        produtos.add(new Produto("Tablet", 350.50));
        produtos.add(new Produto("HD Case", 80.90));

        /* Forma 1 - Instanciação do Consumer */
        // produtos.forEach(new AtualizarPrecos());

        /* Forma 2 - Reference method com método estático */
        // produtos.forEach(Produto::atualizarPrecosEstatico);

        /* Forma 3 - Reference method com método simples */
        // produtos.forEach(Produto::atualizarPrecosNaoEstatico);

        /* Forma 4 - Expressão lambda declarada */
        // Consumer<Produto> consumer = (p) -> p.setPreco(p.getPreco() * 1.1);
        // produtos.forEach(consumer);

        /* Forma 5 - Expressão lambda inline */
        produtos.forEach(p -> p.setPreco(p.getPreco() * 1.1));


        // IMPORTANTE!! -> Referenciando método println da classe System.out
        produtos.forEach(System.out::println);
    }
}
