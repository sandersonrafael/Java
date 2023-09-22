package aplicacao;

import java.util.Comparator;

import entidades.Produto;

// Trata-se de uma classe funcional, onde só importa realmente um método
// ela pode ser passada como argumento do sort
public class MeuComparador implements Comparator<Produto> {

    @Override
    public int compare(Produto p1, Produto p2) {
        return p1.getNome().toUpperCase().compareTo(p2.getNome().toUpperCase());
    }

}
