import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // para obter dados de entrada do usuário, é necessário importar a classe Scanner e instanciar com System.in
    // para receber os dados, usa-se o variavelInstanciada.next();
    // ao final do uso, é necessário utilizar o método variavelInstanciada.close();

    Scanner sc = new Scanner(System.in);

    String stringDigitada;
    System.out.println("Digite uma palavra:");
    stringDigitada = sc.next();

    System.out.println("Você digitou: " + stringDigitada);

    int valorInteiro;
    System.out.println("Digite um número inteiro:");
    valorInteiro = sc.nextInt();

    System.out.println("Você digitou: " + valorInteiro);


    sc.close();
  }
}
