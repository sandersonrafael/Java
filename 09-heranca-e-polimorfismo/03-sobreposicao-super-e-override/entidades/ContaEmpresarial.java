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
      balanco += quantidade - 10.0;
    }
  }

  // chamado o méodo da classe super (pai) e executando antes de fazer a própria alteração
  @Override
  public void saque(double valorSacado) {
    super.saque(valorSacado);
    balanco -= 2.0;
  }
}
