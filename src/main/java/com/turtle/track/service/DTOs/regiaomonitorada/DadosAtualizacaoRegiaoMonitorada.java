package com.turtle.track.service.DTOs.regiaomonitorada;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoRegiaoMonitorada(
        @NotNull
        Long id,
        String regiao,
        String praia,
        int qntd_ninhos,
        int qntd_ovos,
        String riscos,
        String especie,
        String usuario_login
        ) {
}
