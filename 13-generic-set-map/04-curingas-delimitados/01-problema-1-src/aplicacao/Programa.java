package aplicacao;

import java.util.ArrayList;
import java.util.List;

import entidades.Circulo;
import entidades.FormaGeometrica;
import entidades.Retangulo;

public class Programa {
    public static void main(String[] args) {
        List<FormaGeometrica> formas = new ArrayList<>();
        formas.add(new Retangulo(3.0, 2.0));
        formas.add(new Circulo(2.0));

        System.out.println("Area total: " + areaTotal(formas));

        List<Circulo> circulos = new ArrayList<>();
        circulos.add(new Circulo(2.0));
        circulos.add(new Circulo(3.0));

        System.out.println("Area circulos: " + areaTotal(circulos));


    }

    // <? extends Classe> -> permite que qualquer subtipo da Classe informada possa participar da expressão
    // significa: Qualquer tipo que seja subtipo de FormaGeometrica
    public static double areaTotal(List<? extends FormaGeometrica> lista) {
        // lista.add(new Circulo(2.0)); -> não vai permitir devido ao curinga
        double soma = 0.0;
        for (FormaGeometrica fg : lista) {
            soma += fg.area();
        }
        return soma;
    }
}
