package servicos;

import java.util.List;
import java.util.function.Predicate;

import entidades.Produto;

public class ServicoProduto {
    public double somaFiltrada(List<Produto> lista, Predicate<Produto> predicado) {
        double soma = 0.0;
        for (Produto p : lista) {
            if (predicado.test(p)) {
                soma += p.getPreco();
            }
        }
        return soma;
    }
}
