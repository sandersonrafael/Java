package entidades;

import entidades.enums.Cor;

public class Circulo extends FormaGeometrica {
  private Double raio;

  public Circulo () {
    super();
  }
  
  public Circulo (Cor cor, Double raio) {
    super(cor);
    this.raio = raio;
  }

  @Override
  public double area() {
    return Math.PI * Math.pow(raio, 2);
  }
}
