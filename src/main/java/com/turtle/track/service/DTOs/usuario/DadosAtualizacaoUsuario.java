package com.turtle.track.service.DTOs.usuario;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoUsuario(
        @NotNull
        String login,
        String nome,
        String email,
        String senha
        ) {
}
