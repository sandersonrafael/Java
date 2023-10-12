package com.cursojava.spring.entities.enums;

public enum OrderStatus { // atribuindo valores numéricos manualmente para os enums
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code;

    private OrderStatus(int code) { // o construtor de um enum é um caso especial. Precisa ser private
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static OrderStatus valueOf(int code) {
        for (OrderStatus value : OrderStatus.values()) {
            if (value.getCode() == code) return value;
        }
        throw new IllegalArgumentException("Invalid OrderStatus code");
    }
}
