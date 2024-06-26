package com.turtle.track.service.DTOs.regiaomonitorada;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroRegiaoMonitorada(
        @NotBlank
        Long id,
        @NotBlank
        String regiao,
        @NotBlank
        String praia,
        @NotBlank
        int qntd_ninhos,
        @NotBlank
        int qntd_ovos,
        @NotBlank
        String riscos,
        @NotBlank
        String especie,
        @NotBlank
        String usuario_login) {
}
