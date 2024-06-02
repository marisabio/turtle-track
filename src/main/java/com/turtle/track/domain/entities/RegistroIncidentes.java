package com.turtle.track.domain.entities;

import com.turtle.track.service.DTOs.registroincidentes.DadosAtualizacaoRegistroIncidentes;
import com.turtle.track.service.DTOs.registroincidentes.DadosCadastroRegistroIncidentes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "registros_incidentes")
public class RegistroIncidentes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date data;
    private String especie;
    private String descricao;

    @OneToOne(targetEntity = Usuario.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "login")
    private String usuarioLogin;

    @OneToOne(targetEntity = RegiaoMonitorada.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private Long regiaoMonitoradaId;

    public RegistroIncidentes(DadosCadastroRegistroIncidentes dados) {
        this.id = dados.id();
        this.data = dados.data();
        this.especie = dados.especie();
        this.descricao = dados.descricao();
        this.usuarioLogin = dados.usuarioLogin();
        this.regiaoMonitoradaId = dados.regiaoMonitoradaId();
    }

    public void atualizarInformacoes(DadosAtualizacaoRegistroIncidentes dados) {
        if (dados.id() != null) {
            this.id = dados.id();
        }
        if (dados.data() != null) {
            this.data = dados.data();
        }
        if (dados.especie() != null) {
            this.especie = dados.especie();
        }
        if (dados.descricao() != null) {
            this.descricao = dados.descricao();
        }
        if (dados.usuarioLogin() != null) {
            this.usuarioLogin = dados.usuarioLogin();
        }
        if (dados.regiaoMonitoradaId() != null) {
            this.regiaoMonitoradaId = dados.regiaoMonitoradaId();
        }
    }

}
