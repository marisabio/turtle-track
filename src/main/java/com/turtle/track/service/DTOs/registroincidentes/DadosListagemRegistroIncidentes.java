package com.turtle.track.service.DTOs.registroincidentes;

import com.turtle.track.domain.entities.RegistroIncidentes;

import java.util.Date;

public record DadosListagemRegistroIncidentes(
        Long id,
        Date data,
        String especie,
        String descricao,
        String usuario_login,
        Long regiao_monitorada_id
        ) {

        public DadosListagemRegistroIncidentes(RegistroIncidentes registroIncidentes) {
            this(registroIncidentes.getId(), registroIncidentes.getData(), registroIncidentes.getEspecie(), registroIncidentes.getDescricao(),
                    registroIncidentes.getUsuario_login(), registroIncidentes.getRegiao_monitorada_id());
        }
}
