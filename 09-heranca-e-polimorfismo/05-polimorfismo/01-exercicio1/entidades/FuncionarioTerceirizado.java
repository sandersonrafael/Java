package entidades;

public class FuncionarioTerceirizado extends Funcionario {
  private Double despesasAdicionais;

  public FuncionarioTerceirizado() {
    super();
  }

  public FuncionarioTerceirizado(String nome, Integer horas, Double valorPorHora, Double despesasAdicionais) {
    super(nome, horas, valorPorHora);
    this.despesasAdicionais = despesasAdicionais;
  }

  public Double getDespesasAdicionais() {
    return despesasAdicionais;
  }

  public void setDespesasAdicionais(Double despesasAdicionais) {
    this.despesasAdicionais = despesasAdicionais;
  }

  @Override
  public double pagamento() {
    return super.pagamento() + despesasAdicionais * 1.1;
  }

  public String toString() {
    return super.toString().substring(0, super.toString().length() - 1) + ", despesasAdicionais="+ despesasAdicionais+ "]";
  }
}

