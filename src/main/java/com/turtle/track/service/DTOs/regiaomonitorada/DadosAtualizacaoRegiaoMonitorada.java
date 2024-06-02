package com.turtle.track.service.DTOs.regiaomonitorada;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoRegiaoMonitorada(
        @NotNull
        Long id,
        String regiao,
        String praia,
        int qntdNinhos,
        int qntdOvos,
        String riscos,
        String especie,
        String usuarioLogin
        ) {
}
