package util;

import java.util.function.Predicate;

import entidades.Produto;

public class PredicadoDoProduto implements Predicate<Produto> {

    @Override
    public boolean test(Produto t) {
        return t.getPreco() >= 100.0;
    }
}
