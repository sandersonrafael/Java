package com.cursojava.spring.entities;

import java.io.Serializable;

import com.cursojava.spring.entities.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId // não utilizamos @Id, pois ele não é obtido automaticamente e sim pelo pela composição
    // como o id não tem order ou product diretamente, não podemos usar o @JsonIgnore aqui. Usaremos no get abaixo
    private OrderItemPK id = new OrderItemPK();
    private Integer quantity;
    private Double price;

    public OrderItem() {
    }

    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        id.setOrder(order); // aqui setamos o pedido e o produto que está recionado a ele
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    // como essa entidade em si não possui o produto e o pedido, criaremos o get independente de acordo
    // com o OrderItemPK id
    @JsonIgnore // para que não dê o erro de múltiplas chamadas
    public Order getOrder() {
        return id.getOrder();
    }

    public void setOrder(Order order) {
        id.setOrder(order);
    }

    public Product getProduct() {
        return id.getProduct();
    }

    public void setProduct(Product product) {
        id.setProduct(product);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    // para o Java EE, para aparecer o resultado no JSON, precisa ser um "get", então subTotal ficará getSubTotal()
    public Double getSubTotal() {
        return quantity * price;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OrderItem other = (OrderItem) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
