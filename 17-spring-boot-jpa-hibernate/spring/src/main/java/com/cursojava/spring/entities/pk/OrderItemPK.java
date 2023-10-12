package com.cursojava.spring.entities.pk;

import java.io.Serializable;

import com.cursojava.spring.entities.Order;
import com.cursojava.spring.entities.Product;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

// chave composta
// trata-se de uma chave primária que é formada pela juntação de duas chaves estrangeiras de dois outros
// objetos (Order e Product, no caso)
/* Necessário implementar o Serializable pois trata-se de entidades também */
@Embeddable // utilizado para declarar que é uma chave composta por duas FK
public class OrderItemPK implements Serializable {
    private static final long serialVersionUID = 1L;

    // Trata-se de um relacionamento de muitos para um com pedido (um) e produtos (muitos)
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    // por se tratar somente de uma associação, ela não terá construtores

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    // nesse caso, como a chave é formada pelos dois, o hashCode e equals será com os dois
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((order == null) ? 0 : order.hashCode());
        result = prime * result + ((product == null) ? 0 : product.hashCode());
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
        OrderItemPK other = (OrderItemPK) obj;
        if (order == null) {
            if (other.order != null)
                return false;
        } else if (!order.equals(other.order))
            return false;
        if (product == null) {
            if (other.product != null)
                return false;
        } else if (!product.equals(other.product))
            return false;
        return true;
    }
}
