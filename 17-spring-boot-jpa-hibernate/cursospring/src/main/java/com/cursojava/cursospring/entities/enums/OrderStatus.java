package com.cursojava.cursospring.entities.enums;

// os valores padrões podem ser alterados com ()
public enum OrderStatus {
    WAITING_PAYMENT(1), // Padrão a "WAITING_PAYMENT" (String) ou 0 int
    PAID(2), // Padrão a "PAID" (String) ou 1 int
    SHIPPED(3), // Padrão a "SHIPPED" (String) ou 2 int
    DELIVERED(4), // Padrão a "DELIVERED" (String) ou 3 int
    CANCELED(5); // Padrão a "CANCELED" (String) ou 4 int

    // criando construtor para o tipo enum
    private int code;

    private OrderStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static OrderStatus valueOf(int code) {
        for (OrderStatus value : OrderStatus.values()) {
            if (value.getCode() == code) return value;
        }
        throw new IllegalArgumentException("Código do OrderStatus informado é inválido!");
    }
}
