import java.util.Set;
import java.util.TreeSet;

public class OpcaoTreeSet {
    public static void main(String[] args) {
        // Ordena através do sort, como sequência de números, letras, etc
        // Mais lento
        Set<String> set = new TreeSet<>();

        set.add("TV");
        set.add("Notebook");
        set.add("Tablet");

        // não gera erro de compilação, mas não significa adicionar 2 "Tablets"
        set.add("Tablet");

        System.out.println(set.contains("Notebook"));
        System.out.println();

        for (String s : set) {
            System.out.println(s);
        }
    }
}
