package aplicacao;

import java.util.ArrayList;
import java.util.List;

public class Programa {
    public static void main(String[] args) {
        List<Object> objs = new ArrayList<Object>();
        objs.add("Maria");
        objs.add("Alex");

        List<? super Number> numeros = objs;
        numeros.add(10); // sem erro
        numeros.add(3.14);

        // Number x = numeros.get(0); // erro de compilação

        // vale lembrar que ele ainda consegue acessar, porém, não
        // pode associar a um tipo Number, pois não sabe se o tipo curinga é compatível
        // com o tipo Number, apesar de ser Super
        System.out.println(numeros.get(0));
    }
}
