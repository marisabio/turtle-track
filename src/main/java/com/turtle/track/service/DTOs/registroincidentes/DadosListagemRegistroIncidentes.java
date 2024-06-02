package com.turtle.track.service.DTOs.registroincidentes;

import com.turtle.track.domain.entities.RegistroIncidentes;

import java.util.Date;

public record DadosListagemRegistroIncidentes(
        Long id,
        Date data,
        String especie,
        String descricao,
        String usuarioLogin,
        Long regiaoMonitoradaId
        ) {

        public DadosListagemRegistroIncidentes(RegistroIncidentes registroIncidentes) {
            this(registroIncidentes.getId(), registroIncidentes.getData(), registroIncidentes.getEspecie(), registroIncidentes.getDescricao(),
                    registroIncidentes.getUsuarioLogin(), registroIncidentes.getRegiaoMonitoradaId());
        }
}
