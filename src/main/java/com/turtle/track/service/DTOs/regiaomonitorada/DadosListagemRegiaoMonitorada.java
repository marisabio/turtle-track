package com.turtle.track.service.DTOs.regiaomonitorada;

import com.turtle.track.domain.entities.RegiaoMonitorada;

public record DadosListagemRegiaoMonitorada(
        Long id,
        String regiao,
        String praia,
        int qntdNinhos,
        int qntdOvos,
        String riscos,
        String especie,
        String usuarioLogin
        ) {

        public DadosListagemRegiaoMonitorada(RegiaoMonitorada regiaoMonitorada) {
            this(regiaoMonitorada.getId(), regiaoMonitorada.getRegiao(), regiaoMonitorada.getPraia(), regiaoMonitorada.getQntdNinhos(), regiaoMonitorada.getQntdOvos(),
                    regiaoMonitorada.getRiscos(), regiaoMonitorada.getEspecie(), regiaoMonitorada.getUsuarioLogin());
        }
}
