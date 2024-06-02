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
@AllArgsConstructor
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
    private Integer qntdNinhos;
    private Integer qntdOvos;
    private String riscos;
    private String especie;

    @OneToOne(targetEntity = Usuario.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "login")
    private String usuarioLogin;

    public RegiaoMonitorada(DadosCadastroRegiaoMonitorada dados) {
        this.id = dados.id();
        this.regiao = dados.regiao();
        this.praia = dados.praia();
        this.qntdNinhos = dados.qntdNinhos();
        this.qntdOvos = dados.qntdOvos();
        this.riscos = dados.riscos();
        this.especie = dados.especie();
        this.usuarioLogin = dados.usuarioLogin();
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
        if (dados.qntdNinhos() != null) {
            this.qntdNinhos = dados.qntdNinhos();
        }
        if (dados.qntdOvos() != null) {
            this.qntdOvos = dados.qntdOvos();
        }
        if (dados.riscos() != null) {
            this.riscos = dados.riscos();
        }
        if (dados.especie() != null) {
            this.especie = dados.especie();
        }
        if (dados.usuarioLogin() != null) {
            this.usuarioLogin = dados.usuarioLogin();
        }
    }

}
