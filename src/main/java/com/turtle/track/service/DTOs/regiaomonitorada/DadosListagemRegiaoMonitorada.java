package com.turtle.track.service.DTOs.regiaomonitorada;

import com.turtle.track.domain.entities.RegiaoMonitorada;

public record DadosListagemRegiaoMonitorada(
        Long id,
        String regiao,
        String praia,
        int qntd_ninhos,
        int qntd_ovos,
        String riscos,
        String especie,
        String usuario_login
        ) {

        public DadosListagemRegiaoMonitorada(RegiaoMonitorada regiaoMonitorada) {
            this(regiaoMonitorada.getId(), regiaoMonitorada.getRegiao(), regiaoMonitorada.getPraia(), regiaoMonitorada.getQntd_ninhos(), regiaoMonitorada.getQntd_ovos(),
                    regiaoMonitorada.getRiscos(), regiaoMonitorada.getEspecie(), regiaoMonitorada.getUsuario_login());
        }
}
