import java.util.Map;
import java.util.TreeMap;

public class Programa {
    public static void main(String[] args) {
        // TreeMap ordena pela key
        Map<String, String> cookies = new TreeMap<>();

        cookies.put("usuario", "Maria");
        cookies.put("email", "maria@email.com");
        cookies.put("telefone", "99999999999");

        // size
        System.out.println(cookies.size());

        cookies.remove("email");

        System.out.println("Todos os cookies");

        // se fizer um novo put em uma mesma key, sobrescreve
        cookies.put("telefone", "99999999998");

        // containsKey()
        System.out.println("O Map cookies " + (cookies.containsKey("telefone") ? "CONTÉM" : "NÃO CONTÉM") + " a palavra telefone");
        System.out.println("O Map cookies " + (cookies.containsKey("senha") ? "CONTÉM" : "NÃO CONTÉM") + " a palavra senha");

        // get
        System.out.println("O valor da chave telefone é: " + cookies.get("telefone"));


        System.out.println(cookies);
        // ou
        for (String str : cookies.keySet()) { // keySet() retorna lista com todas as keys
            System.out.println("{ " + str + ": " + cookies.get(str) + " }");
        }

    }
}
