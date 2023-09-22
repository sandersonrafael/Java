import java.util.Set;
import java.util.LinkedHashSet;

public class OpcaoLinkedHashSet {
    public static void main(String[] args) {
        // Velocidade intermediária | Mantém elementos na ordem de adição
        Set<String> set = new LinkedHashSet<>();

        set.add("TV");
        set.add("Notebook");
        set.add("Tablet");

        // não gera erro de compilação, mas não significa adicionar 2 "Tablets"
        set.add("Tablet");

        System.out.println(set.contains("Notebook"));

        // .remove()
        set.remove("Tablet");
        System.out.printf("%nFica a TV e o Notebook%n");

        for (String s : set) {
            System.out.println(s);
        }

        set.add("Tablet");

        // .removeIf()
        set.removeIf(x -> x.length() >= 3);
        System.out.printf("%nFica só a TV%n");

        for (String s : set) {
            System.out.println(s);
        }
    }
}
