package util;

import java.util.function.Function;

import entidades.Produto;

public class NomeEmCaixaAlta implements Function<Produto, String> {
    @Override
    public String apply(Produto produto) {
        return produto.getNome().toUpperCase();
    }
}
