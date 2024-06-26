package com.turtle.track.service.DTOs.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public record DadosCadastroUsuario(
        @NotBlank
        String login,
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String senha
        ) {
}
