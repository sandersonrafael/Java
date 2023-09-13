package entidades;

public class ContaPoupanca extends ContaBancaria {
  private Double txjuros;

  public ContaPoupanca() {
    super();
  }

  public ContaPoupanca(Integer numeroDaConta, String titular, Double balanco, Double txjuros) {
    super(numeroDaConta, titular, balanco);
    this.txjuros = txjuros;
  }

  public Double getTxjuros() {
    return txjuros;
  }

  public void setTxjuros(Double txjuros) {
    this.txjuros = txjuros;
  }

  public void atualizarBalanco() {
    balanco += balanco * txjuros;
  }
}
