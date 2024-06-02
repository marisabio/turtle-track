package com.turtle.track.domain.entities;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import com.turtle.track.service.DTOs.usuario.DadosAtualizacaoUsuario;
import com.turtle.track.service.DTOs.usuario.DadosCadastroUsuario;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    private String login;

    private String nome;
    private String email;
    private String senha;

    public Usuario(DadosCadastroUsuario dados) {
        this.login = dados.login();
        this.nome = dados.nome();
        this.email = dados.email();
        this.senha = dados.senha();
    }

    public void atualizarInformacoes(DadosAtualizacaoUsuario dados) {
        if (dados.login() != null) {
            this.login = dados.login();
        }
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.email() != null) {
            this.email = dados.email();
        }
        if (dados.senha() != null) {
            this.senha = dados.senha();
        }
    }

}


