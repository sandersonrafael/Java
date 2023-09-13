package entidades;

public class ContaBancaria {
  private Integer numeroDaConta;
  private String titular;
  protected Double balanco;

  public ContaBancaria() {}

  public ContaBancaria(Integer numeroDaConta, String titular, Double balanco) {
    this.numeroDaConta = numeroDaConta;
    this.titular = titular;
    this.balanco = balanco;
  }

  public Integer getNumeroDaConta() {
    return numeroDaConta;
  }

  public void setNumeroDaConta(Integer numeroDaConta) {
    this.numeroDaConta = numeroDaConta;
  }

  public String getTitular() {
    return titular;
  }

  public void setTitular(String titular) {
    this.titular = titular;
  }

  public Double getBalanco() {
    return balanco;
  }

  public void saque(double valorSacado) {
    balanco -= (valorSacado + 5.0);
  }

  public void deposito(double valorDepositado) {
    balanco += valorDepositado;
  }
}
