package com.turtle.track.domain.entities;

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

}
