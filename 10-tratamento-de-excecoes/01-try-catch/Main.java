import java.util.Locale;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    metodo1();
    
    System.out.println("Fim do programa");
  }
  
  public static void metodo1 () {
    System.out.println("***Início Metodo1***");
    metodo2();
    System.out.println("***Fim Metodo1***");
  }

  public static void metodo2() {
    System.out.println("***Início Metodo2***");
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    String[] vetor = sc.nextLine().split(" ");
    try {
      int position = sc.nextInt();

      System.out.println(vetor[position]);
      // no catch, é possível definir um erro específico ou genérico, como Exception
    } catch (Exception e) {
      System.out.println("Erro");

      // exibir o trackeamento do erro
      e.printStackTrace();
      System.out.println(e);
      // são similares na exibicao, mas o printStackTrace exibe as linhas do erro
    }

    // finaly {} -> executa sempre após o try ou o catch, independente de erro
    // usado para fechar conexões com db, finalizar código como o sc.close(), etc...
    sc.close();
  }
}
