package util;

import java.util.function.Consumer;

import entidades.Produto;

public class AtualizarPrecos implements Consumer<Produto> {
    @Override
    public void accept(Produto produto) {
        produto.setPreco(produto.getPreco() * 1.1);
    }
}
