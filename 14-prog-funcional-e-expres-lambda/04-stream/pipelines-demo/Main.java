import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(3, 4, 5, 10, 7);

        // map que retorna uma stream de tamanho igual mas com valores modificados pela função informada
        Stream<Integer> stream1 = lista.stream().map(x -> x * 10);
        System.out.println(Arrays.toString(stream1.toArray()));

        // reduce(acumulador, (acumulador, valorAtual) -> operacaoQueRetornaNovoAcumulador)
        int soma = lista.stream().reduce(0, (x, y) -> x + y);
        System.out.println(soma);

        // sequência de métodos intermediários (pipeline)
        List<Integer> novaLista = lista.stream()
            .filter(x -> x % 2 == 0)
            .map(x -> x * 10)
            .collect(Collectors.toList());

        System.out.println(novaLista);
    }
}
