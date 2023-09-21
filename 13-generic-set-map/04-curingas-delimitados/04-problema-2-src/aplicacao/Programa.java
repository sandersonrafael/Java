package aplicacao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programa {
    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(1, 2, 3, 4);
        List<Double> doubs = Arrays.asList(3.14, 6.28);
        List<Object> objs = new ArrayList<Object>();

        copiar(ints, objs);
        printLista(objs);

        copiar(doubs, objs);
        printLista(objs);
    }

    public static void copiar(List<? extends Number> lista, List<? super Number> novaLista) {
        for (Number numero : lista) {
            novaLista.add(numero);
        }
    }

    public static void printLista(List<?> lista) {
        for (Object obj : lista) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }
}
