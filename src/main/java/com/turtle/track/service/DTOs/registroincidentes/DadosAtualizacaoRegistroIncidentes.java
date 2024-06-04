package com.turtle.track.service.DTOs.registroincidentes;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record DadosAtualizacaoRegistroIncidentes(
        @NotNull
        Long id,
        Date data,
        String especie,
        String descricao,
        String usuario_login,
        Long regiao_monitorada_id
        ) {
}
