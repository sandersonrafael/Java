import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LendoLinhas {
  public static void main(String[] args) {
    File arquivo =  new File("./arquivo-teste.txt");
    Scanner sc = null;
    try {
      sc = new Scanner(arquivo);
      while (sc.hasNextLine()) {
        System.out.println(sc.nextLine());
      }
    } catch (IOException e) {
      System.out.println("Erro: " + e.getMessage());
    } finally {
      if (sc != null) sc.close();
    }
  }
}
