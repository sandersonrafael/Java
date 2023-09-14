package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
  private static final SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

  private Integer quarto;
  private Date entrada;
  private Date saida;

  public Reserva(Integer quarto, Date entrada, Date saida) {
    this.quarto = quarto;
    this.entrada = entrada;
    this.saida = saida;
  }

  public Integer getQuarto() {
    return quarto;
  }

  public void setQuarto(Integer quarto) {
    this.quarto = quarto;
  }

  public Date getEntrada() {
    return entrada;
  }

  public Date getSaida() {
    return saida;
  }

  public long duracao() {
    long tempo = saida.getTime() - entrada.getTime();
    return TimeUnit.DAYS.convert(tempo, TimeUnit.MILLISECONDS);
  }

  public void atualizarDatas(Date entrada, Date saida) {
    this.entrada = entrada;
    this.saida = saida;
  }

  @Override
  public String toString() {
    return "Quarto "
      + quarto
      + ", entrada: "
      + formato.format(entrada)
      + ", saída: "
      + formato.format(saida)
      + ", "
      + duracao()
      + " noites.";
  }
}
