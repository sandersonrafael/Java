package application;

import java.util.Date;

import entities.Pedido;
import entities.enums.StatusDoPedido;

public class Programa {
  public static void main(String[] args) {
    Pedido pedido = new Pedido(1080, new Date(), StatusDoPedido.AGUARDANDO_PAGAMENTO);

    // por padrão, o código converte a notação do enum para string
    System.out.println(pedido);

    StatusDoPedido sdp1 = StatusDoPedido.ENTREGUE;
    StatusDoPedido sdp2 = StatusDoPedido.valueOf("ENTREGUE");

    System.out.println(sdp1 + " == " + sdp2);
  }
}
