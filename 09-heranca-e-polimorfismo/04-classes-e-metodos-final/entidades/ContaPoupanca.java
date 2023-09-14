package entidades;

public final class ContaPoupanca extends ContaBancaria {
  
  // apresenta erro devido ao final no método da class super();
  /* @Override
  public void deposito() {
  } */

  // não apresenta erro
  @Override
  public double saque() {
    return 2.0;
  }
}
