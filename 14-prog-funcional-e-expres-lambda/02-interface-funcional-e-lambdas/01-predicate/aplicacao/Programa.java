package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import entidades.Produto;
import util.PredicadoDoProduto;

public class Programa {
    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();

        produtos.add(new Produto("Tv", 900.00));
        produtos.add(new Produto("Mouse", 50.00));
        produtos.add(new Produto("Tablet", 350.50));
        produtos.add(new Produto("Tv", 80.90));

        /* Forma 1 - Implementação da interface */
        // é criada uma classe (PredicadoDoProduto), que implementa o Predicate<T>
        // produtos.removeIf(new PredicadoDoProduto());

        /* Forma 2 - Reference method com método estático (:: significa referência para método) */
        // Utilizado um método estático na própria classe do Produto com o :: -> método como parametro
        // cada item da lista é passado uma vez como parâmetro do método referenciado e testado
        // produtos.removeIf(Produto::PredicadoDoProdutoEstatico);

        /* Forma 3 - Reference method com método não estático (comum) */
        // Utiliza um método comum, mas que não recebe parâmetro na classe referente ao produto
        // em vez disso, recebe o próprio parâmetro privado "preco" em vez de um produto.getPreco()
        // produtos.removeIf(Produto::PredicadoDoProdutoNaoEstatico);

        /* Forma 4 - Expressão lambda declarada */
        // Predicate<Produto> predicado = (p) -> p.getPreco() >= 100.0;
        // produtos.removeIf(predicado);

        /* Forma 5 - Expressão lambda inline */
        produtos.removeIf(p -> p.getPreco() >= 100.0);

        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }
}
