package com.turtle.track.domain.entities;

import com.turtle.track.service.DTOs.regiaomonitorada.DadosAtualizacaoRegiaoMonitorada;
import com.turtle.track.service.DTOs.regiaomonitorada.DadosCadastroRegiaoMonitorada;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@Entity
@Table(name = "regiao_monitorada")
public class RegiaoMonitorada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String regiao;
    private String praia;
    private int qntd_ninhos;
    private int qntd_ovos;
    private String riscos;
    private String especie;

    @OneToOne(targetEntity = Usuario.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "login")
    private String usuario_login;

    public RegiaoMonitorada(DadosCadastroRegiaoMonitorada dados) {
        this.id = dados.id();
        this.regiao = dados.regiao();
        this.praia = dados.praia();
        this.qntd_ninhos = dados.qntd_ninhos();
        this.qntd_ovos = dados.qntd_ovos();
        this.riscos = dados.riscos();
        this.especie = dados.especie();
        this.usuario_login = dados.usuario_login();
    }

    public void atualizarInformacoes(DadosAtualizacaoRegiaoMonitorada dados) {
        if (dados.id() != null) {
            this.id = dados.id();
        }
        if (dados.regiao() != null) {
            this.regiao = dados.regiao();
        }
        if (dados.praia() != null) {
            this.praia = dados.praia();
        }
        if (dados.qntd_ninhos() != 0) {
            this.qntd_ninhos = dados.qntd_ninhos();
        }
        if (dados.qntd_ovos() != 0) {
            this.qntd_ovos = dados.qntd_ovos();
        }
        if (dados.riscos() != null) {
            this.riscos = dados.riscos();
        }
        if (dados.especie() != null) {
            this.especie = dados.especie();
        }
        if (dados.usuario_login() != null) {
            this.usuario_login = dados.usuario_login();
        }
    }

}
