import java.util.Locale;

public class Main {
  public static void main(String[] args) {
    int y = 32;
    double x = 10.35123;

    System.out.println(x);
    System.out.println(y);
    System.out.println("Olá mundo!");

    // para formatar, usa-se o printf -> %.2f significa 2 casas decimais, %.4f seria 4, etc.
    // para quebrar espaço ao final da variável, é usado o %n
    // o printf formata de acordo com o computador. Se for BR, vai ficar " , " e se for eua, " . "
    System.out.printf("%.2f%n", x);


    // para setar a formatação padrão, usa-se Locale:
    Locale.setDefault(Locale.US);
    System.out.printf("%.4f%n", x);

    // concatenação
    System.out.printf("O resultado é: " + x + " metros");
  }
}
