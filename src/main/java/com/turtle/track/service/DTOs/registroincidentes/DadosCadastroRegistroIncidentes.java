package com.turtle.track.service.DTOs.registroincidentes;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record DadosCadastroRegistroIncidentes(
        @NotBlank
        Long id,
        @NotBlank
        Date data,
        @NotBlank
        String especie,
        @NotBlank
        String descricao,
        @NotBlank
        String usuario_login,
        @NotBlank
        Long regiao_monitorada_id
        ) {
}
