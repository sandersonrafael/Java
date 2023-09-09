import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String dia;
    int x;
    System.out.println("Digite o dia da semana, onde dom = 1:");
    x = sc.nextInt();

    switch (x) {
      case 1:
        dia = "Domingo";
        break;
      case 2:
        dia = "Segunda";
        break;
      case 3:
        dia = "Terça";
        break;
      case 4:
        dia = "Quarta";
        break;
      case 5:
        dia = "Quinta";
        break;
      case 6:
        dia = "Sexta";
        break;
      case 7:
        dia = "Sábado";
        break;
      default:
        dia = "Inválido";
        break;
    }

    System.out.println("O dia equivalente é: " + dia);
    sc.close();
  }
}
