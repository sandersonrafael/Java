package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Circulo;
import entidades.FormaGeometrica;
import entidades.Retangulo;
import entidades.enums.Cor;

public class Programa {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    System.out.print("Informe o número de figuras geométricas: ");
    int n = sc.nextInt();
    List<FormaGeometrica> formasGeometricas = new ArrayList<>();

    for (int i = 1; i <= n; i++) {
      System.out.println("Dados da figura " + i);
      System.out.print("A figura trata-se de um retângulo ou círculo (R/C)? ");
      char forma = sc.next().toUpperCase().charAt(0);

      System.out.print("Qual a cor (PRETO/AZUL/VERMELHO)? ");
      Cor cor = Cor.valueOf(sc.next().toUpperCase());

      FormaGeometrica formaGeometrica;
      if (forma == 'R') {
        System.out.print("Digite a largura do retângulo: ");
        double largura = sc.nextDouble();
        System.out.print("Digite a altura do retângulo: ");
        double altura = sc.nextDouble();

        formaGeometrica = new Retangulo(cor, largura, altura);
      } else {
        System.out.print("Digite o raio do circulo: ");
        double raio = sc.nextDouble();

        formaGeometrica = new Circulo(cor, raio);
      }
      formasGeometricas.add(formaGeometrica);
    }

    for (FormaGeometrica forma: formasGeometricas) {
      System.out.println("Figura " + (formasGeometricas.indexOf(forma) + 1) + " - Área: " + String.format("%.2f", forma.area()));
    }
    sc.close();
  }
}
