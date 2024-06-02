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
        Integer qntdNinhos,
        @NotBlank
        Integer qntdOvos,
        @NotBlank
        String riscos,
        @NotBlank
        String especie,
        @NotBlank
        String usuarioLogin) {
}
