package com.cursojava.springmongo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document // no MongoDB, diferente do Jpa com MySQL, usamos @Document e não @Entity, pois é um NoSQL (orientado a documentos)
// é possível fazer a notação @Document(collection = "nomePersonalizadoParaColeção"), como o @Table(name = "tal"), do Jpa
public class User implements Serializable {
    // Serializable permite que os objetos sejam convertidos em bytes, para trafegar em rede, gravar em arquivo, etc
    private static final long serialVersionUID = 1L;

    @Id // neste caso, é igual ao Jpa
    private String id;
    private String name;
    private String email;

    @DBRef(lazy = true) // determina que essa variável é formada por referência a outra ou outras variáveis no mongodb
    // lazy garante que ao carregar usuários, os seus posts não sejam carregados, para evitar perde de performance
    // ao se buscar uma lista de usuários, por exemplo, onde só se desejam os usuários e não seus posts
    private List<Post> posts = new ArrayList<>();

    public User() {
    }

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public List<Post> getPosts() {
        return posts;
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
