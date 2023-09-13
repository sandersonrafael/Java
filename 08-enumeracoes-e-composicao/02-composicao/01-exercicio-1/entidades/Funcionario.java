package entidades;

import java.util.ArrayList;
import java.util.Calendar;

import enums.Senioridade;

public class Funcionario {
  private String nome;
  private Senioridade senioridade;
  private Double salarioBase;

  private Departamento departamento;
  private ArrayList<Contrato> contratos = new ArrayList<>();

  public Funcionario() {}

  public Funcionario(String nome, Senioridade senioridade, Double salarioBase, Departamento departamento) {
    this.nome = nome;
    this.senioridade = senioridade;
    this.salarioBase = salarioBase;
    this.departamento = departamento;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Senioridade getSenioridade() {
    return senioridade;
  }

  public void setSenioridade(Senioridade senioridade) {
    this.senioridade = senioridade;
  }

  public Double getSalarioBase() {
    return salarioBase;
  }

  public void setSalarioBase(Double salarioBase) {
    this.salarioBase = salarioBase;
  }

  public Departamento getDepartamento() {
    return departamento;
  }

  public void setDepartamento(Departamento departamento) {
    this.departamento = departamento;
  }

  public ArrayList<Contrato> getContratos() {
    return contratos;
  }

  public void adicionarContrato(Contrato contrato) {
    contratos.add(contrato);
  }

  public void removerContrato(Contrato contrato) {
    contratos.remove(contrato);
  }

  public double rendaNoPeríodo (int ano, int mes) {
    double soma = salarioBase;
    Calendar calendario = Calendar.getInstance();

    for (Contrato contrato: contratos) {
      calendario.setTime(contrato.getData());
      int c_ano = calendario.get(Calendar.YEAR);
      int c_mes = 1 + calendario.get(Calendar.MONTH);

      if (ano == c_ano && mes == c_mes) {
        soma += contrato.valorTotal();
      }
    }
    return soma;
  }

  @Override
  public String toString() {
    return "Funcionario [nome=" + nome + ", senioridade=" + senioridade + ", salarioBase=" + salarioBase
        + ", departamento=" + departamento + ", contratos=" + contratos + "]";
  }
}
