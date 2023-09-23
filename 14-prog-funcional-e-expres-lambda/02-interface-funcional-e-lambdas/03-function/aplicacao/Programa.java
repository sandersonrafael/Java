package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import entidades.Produto;
import util.NomeEmCaixaAlta;

public class Programa {
    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();

        produtos.add(new Produto("Tv", 900.00));
        produtos.add(new Produto("Mouse", 50.00));
        produtos.add(new Produto("Tablet", 350.50));
        produtos.add(new Produto("HD Case", 80.90));

        List<String> nomesProdutos = new ArrayList<>();

        /* Forma 1 - Intanciando Classe que implementa Function<T, R> */
        // nomesProdutos = produtos.stream().map(new NomeEmCaixaAlta()).collect(Collectors.toList());

        /* Forma 2 - Método estático */
        // nomesProdutos = produtos.stream().map(Produto::nomeEmCaixaAltaEstatico).collect(Collectors.toList());

        /* Forma 3 - Método não estático comum */
        // nomesProdutos = produtos.stream().map(Produto::nomeEmCaixaAltaNaoEstatico).collect(Collectors.toList());

        /* Forma 4 - Lambda declarado */
        // Function<Produto, String> funcao = (p) -> p.getNome().toUpperCase();
        // nomesProdutos = produtos.stream().map(funcao).collect(Collectors.toList());

        /* Forma 5 - lambda inline */
        nomesProdutos = produtos.stream().map(p -> p.getNome().toUpperCase()).collect(Collectors.toList());


        produtos.forEach(System.out::println);
        nomesProdutos.forEach(System.out::println);
    }
}
