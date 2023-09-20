package servicos;

import java.util.List;

public class ServicoCalculo {
    public ServicoCalculo() {}

    // para método estático, se não for parametrizada a classe com <T>, precisa ser
    // informado no próprio método antes do tipo de retorno
    // para usar o Comparable, faz o extends:
    public static <T extends Comparable<T>> T maior(List<T> lista) {
        if(lista.isEmpty()) {
            throw new IllegalStateException("A lista não pode estar vazia");
        }
        T maior = lista.get(0);
        for (T item : lista) {
            if (item.compareTo(maior) > 0) {
                maior = item;
            }
        }
        return maior;
    }
}
