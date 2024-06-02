package com.turtle.track.service.DTOs.usuario;

import com.turtle.track.domain.entities.Usuario;

public record DadosListagemUsuario(
        String login,
        String nome,
        String email,
        String senha
        ) {

        public DadosListagemUsuario(Usuario usuario) {
                this(usuario.getLogin(), usuario.getNome(), usuario.getEmail(), usuario.getSenha());
        }
}
