import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    List<Integer> lista = Arrays.asList(3, 4, 5, 10, 7);

    Stream<Integer> stream1 = lista.stream().map(x -> x * 10);
    System.out.println(Arrays.toString(stream1.toArray()));

    Stream<String> stream2 = Stream.of("Fulana", "Ciclanim", "Beltrano");
    System.out.println(Arrays.toString(stream2.toArray()));

    // iterate pode gerar streams infinitas | para consumir, usar um short-circuit
    Stream<Integer> stream3 = Stream.iterate(0, x -> x + 2);
    System.out.println(Arrays.toString(stream3.limit(10).toArray()));

    // fibonacci
    Stream<Long> fibonacci = Stream.iterate(new Long[] {0L, 1L}, p -> new Long[] {p[1], p[0] + p[1]}).map(p -> p[0]);
    System.out.println(Arrays.toString(fibonacci.limit(35).toArray()));
  }
}
