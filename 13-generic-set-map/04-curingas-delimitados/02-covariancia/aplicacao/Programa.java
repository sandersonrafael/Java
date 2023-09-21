package aplicacao;

import java.util.ArrayList;
import java.util.List;

public class Programa {
    public static void main(String[] args) {
        List<Integer> inteiros = new ArrayList<Integer>();
        inteiros.add(10);
        inteiros.add(5);

        List<? extends Number> lista = inteiros;

        Number x = lista.get(0);
        lista.add(20); // erro de compilação
    }
}
