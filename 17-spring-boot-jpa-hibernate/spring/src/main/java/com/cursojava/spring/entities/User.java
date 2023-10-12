package com.cursojava.spring.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

// as entidades precisam implementar Serializable no spring
@Entity // define que trata-se de uma entidade para que o JPA converta o objeto para
        // "tabela"
@Table(name = "tb_user") // define o nome da entidade na tabela, pois no H2, user é uma palavra reservada
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    // faltam as associações
    @Id // define que o atributo seguinte trata-se da chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // define que os valores serão gerados automaticamente de 1 em 1
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;

    @JsonIgnore // serve para que não fique em loop infinito de cliente chama pedido que chama cliente e etc novamente
    @OneToMany(mappedBy = "client") // declara que uma entidade "cliente" possui várias entidades "pedido" e que o
                                    // nome do atributo do tipo User é o "client" na entidade pedido
    private List<Order> orders = new ArrayList<>();

    public User() { // obrigatório por se tratar de um framework (construtor vazio)
    }

    public User(Long id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrders() {
        return orders;
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
        User other = (User) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
