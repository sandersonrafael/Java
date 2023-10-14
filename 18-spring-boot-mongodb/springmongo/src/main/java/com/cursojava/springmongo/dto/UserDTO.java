package com.cursojava.springmongo.dto;

import java.io.Serializable;

import com.cursojava.springmongo.domain.User;

// trata-se de um objeto que expõe a informação requisitada de maneira personalizada,
// por exemplo, um usuário que tem senha: a resposta do get pode ser enviada sem exibir a senha
/* EM RESUMO -> Trata-se de um objeto que recebe os atributos do objeto original e devolve só o necessário */
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String email;

    public UserDTO() {
    }

    // o construtor não vazio recebe o usuário e manipula como será exibido
    public UserDTO(User user) {
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
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
}
