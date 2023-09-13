package entities;

import java.util.Date;

import entities.enums.StatusDoPedido;

public class Pedido {
  private Integer id;
  private Date instante;
  private StatusDoPedido status;

  public Pedido() {}

  public Pedido(Integer id, Date instante, StatusDoPedido status) {
    this.id = id;
    this.instante = instante;
    this.status = status;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setInstante(Date instante) {
    this.instante = instante;
  }

  public void setStatus(StatusDoPedido status) {
    this.status = status;
  }

  public Date getInstante() {
    return instante;
  }

  public StatusDoPedido getStatus() {
    return status;
  }

  @Override
  public String toString() {
    return "Pedido [id=" + id + ", instante=" + instante + ", status=" + status + "]";
  }

}
