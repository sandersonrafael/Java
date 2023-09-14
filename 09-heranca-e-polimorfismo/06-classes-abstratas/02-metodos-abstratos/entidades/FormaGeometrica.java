package entidades;

import entidades.enums.Cor;

public abstract class FormaGeometrica {
  private Cor cor;

  public FormaGeometrica() {
  }

  public FormaGeometrica(Cor cor) {
    this.cor = cor;
  }

  public Cor getCor() {
    return cor;
  }

  public void setCor(Cor cor) {
    this.cor = cor;
  }

  // exige que a classe seja abstrata | metodo abstrato não informa corpo {}
  public abstract double area();
}
