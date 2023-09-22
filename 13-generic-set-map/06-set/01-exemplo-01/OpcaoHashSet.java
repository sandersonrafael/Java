import java.util.HashSet;
import java.util.Set;

public class OpcaoHashSet {
    public static void main(String[] args) {
        // Mais rápido | Não garante a ordem dos itens
        Set<String> set = new HashSet<>();

        set.add("TV");
        set.add("Tablet");
        set.add("Notebook");

        // não gera erro de compilação, mas não significa adicionar 2 "Tablets"
        set.add("Tablet");

        System.out.println(set.contains("Notebook"));
        System.out.println();

        for (String s : set) {
            System.out.println(s);
        }
    }
}
