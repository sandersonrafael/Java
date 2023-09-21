package aplicacao;

import java.util.Arrays;
import java.util.List;

public class Programa {
    public static void main(String[] args) {
        List<Integer> inteiros = Arrays.asList(5, 2, 10);
        printList(inteiros);

        List<String> strings = Arrays.asList("Maria", "João", "Fulanim");
        printList(strings);


        List<?> inteiros2 = Arrays.asList(5, 2, 10);
        // inteiros2.add(5); -> apresenta erro de compilação
    }

    // se for um List<Object> não funciona, pois não é possível fazer upcasting do List<Integer>
    // para List<Object>
    public static void printList(List<?> lista) {
        for (Object obj : lista) {
            System.out.println(obj);
        }
    }
}
