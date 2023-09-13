package entidades;

public class ContaEmpresarial extends ContaBancaria {
  private Double limiteEmprestimo;

  public ContaEmpresarial() {
    super();
  }

  public ContaEmpresarial(Integer numeroDaConta, String titular, Double balanco, Double limiteEmprestimo) {
    super(numeroDaConta, titular, balanco);
    this.limiteEmprestimo = limiteEmprestimo;
  }

  public Double getLimiteEmprestimo() {
    return limiteEmprestimo;
  }

  public void setLimiteEmprestimo(Double limiteEmprestimo) {
    this.limiteEmprestimo = limiteEmprestimo;
  }

  public void emprestimo(double quantidade) {
    if (quantidade <= limiteEmprestimo) {
      // deposito(quantidade);
      balanco += quantidade - 10.0;
    }
  }
}
