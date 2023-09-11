public class Main {
  public static void main(String[] args) {
    String[] vetor = new String[] {"Fulano", "Beltrano", "Ciclano"};

    // for normal
    for (int i = 0; i < vetor.length; i++) {
      System.out.println(vetor[i]);
    }

    System.out.println("");

    // forEach
    for (String item : vetor) {
      System.out.println(item);
    }
  }
}
