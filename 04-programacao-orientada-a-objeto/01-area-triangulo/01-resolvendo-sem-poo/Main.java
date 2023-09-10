// area = √p(p-a)(p-b)(p-c)
// p = (a + b + c) / 2

import java.util.Locale;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // 2 triangulos, um x e outro y com lados a, b e c
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    double xA, xB, xC, yA, yB, yC;
    System.out.println("Informe os lados do triângulo x:");
    xA = sc.nextDouble();
    xB = sc.nextDouble();
    xC = sc.nextDouble();

    System.out.println("Informe os lados do triângulo y:");
    yA = sc.nextDouble();
    yB = sc.nextDouble();
    yC = sc.nextDouble();

    double p = (xA + xB + xC) / 2.0;
    double areaX = Math.sqrt(p * (p - xA) * (p - xB) * (p - xC));

    p = (yA + yB + yC) / 2.0;
    double areaY = Math.sqrt(p * (p - yA) * (p - yB) * (p - yC));

    System.out.printf("Área do triângulo X: %.4f%n", areaX);
    System.out.printf("Área do triângulo Y: %.4f%n", areaY);

    char menor, maior;
    menor = areaX < areaY ? 'X' : 'Y';
    maior = menor == 'X' ? 'Y' : 'X';

    System.out.printf("A área do triângulo %c é maior que a do triângulo %c%n", maior, menor);


    sc.close();
  }
}
