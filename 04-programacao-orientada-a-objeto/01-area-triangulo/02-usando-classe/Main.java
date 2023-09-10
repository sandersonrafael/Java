import java.util.Locale;
import java.util.Scanner;

import entities.Triangulo;

public class Main {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    Triangulo x, y;
    x = new Triangulo();
    y = new Triangulo();

    System.out.println("Informe os lados do triângulo x:");
    x.a = sc.nextDouble();
    x.b = sc.nextDouble();
    x.c = sc.nextDouble();

    System.out.println("Informe os lados do triângulo y:");
    y.a = sc.nextDouble();
    y.b = sc.nextDouble();
    y.c = sc.nextDouble();

    double areaX = x.area();
    double areaY = y.area();

    System.out.printf("Área do triângulo X: %.4f%n", areaX);
    System.out.printf("Área do triângulo Y: %.4f%n", areaY);

    char menor, maior;
    menor = areaX < areaY ? 'X' : 'Y';
    maior = menor == 'X' ? 'Y' : 'X';

    System.out.printf("A área do triângulo %c é maior que a do triângulo %c%n", maior, menor);


    sc.close();
  }
}
