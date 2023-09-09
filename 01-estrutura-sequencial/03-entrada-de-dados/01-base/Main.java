import java.util.Locale;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // para obter dados de entrada do usuário, é necessário importar a classe Scanner e instanciar com System.in
    // ao final do uso, é necessário utilizar o método variavelInstanciada.close();
    
    Locale.setDefault(Locale.US); // para que o Scanner seja em formato US (. em vez de ,)
    Scanner sc = new Scanner(System.in);
    
    // para receber uma palavra, usa-se o variavelInstanciada.next();
/*     String stringDigitada;
    System.out.println("Digite uma palavra:");
    stringDigitada = sc.next();

    System.out.println("Você digitou: " + stringDigitada);
 */
    // para receber um inteiro, usa-se o variavelInstanciada.nextInt();
/*     int valorInteiro;
    System.out.println("Digite um número inteiro:");
    valorInteiro = sc.nextInt();

    System.out.println("Você digitou: " + valorInteiro);
 */
    // para receber um double (flutuante de precisão dupla), usa-se o variavelInstanciada.nextDouble();
/*     double valorDecimal;
    System.out.println("Digite um número decimal");
    valorDecimal = sc.nextDouble();

    System.out.println("Você digitou: " + valorDecimal);
     */

    // para receber um char, podemos usar o método charAt(0)
/*     char caractere;
    System.out.println("Digite uma letra");
    caractere = sc.next().charAt(0);

    System.out.println("Você digitou o caracetere: " + caractere);
 */
    // dados na mesma linha separados por espaço
/*     String nome;
    int idade;
    double alturaEmMetros;
    System.out.println("Digite um nome, idade e altura (m):");
    nome = sc.next();
    idade = sc.nextInt();
    alturaEmMetros = sc.nextDouble();
    
    System.out.println("Nome: " + nome + ", Idade: " + idade + " e altura: " + alturaEmMetros);
 */

    // obter dados em linha, usa-se o variavelInstanciada.nextLine()
    // -> todas as palavras digitadas até digitar enter
    System.out.println("Digite 3 frases:");
    String frase1, frase2, frase3;
    frase1 = sc.nextLine();
    frase2 = sc.nextLine();
    frase3 = sc.nextLine();
    System.out.println("Frase 1: " + frase1 + ", Frase 2: " + frase2 + ", Frase 3: " + frase3);

    sc.close();
  }
}
