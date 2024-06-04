CREATE TABLE regiao_monitorada (
                                   id            INTEGER NOT NULL,
                                   regiao        VARCHAR(50) NOT NULL,
                                   praia         VARCHAR(50) NOT NULL,
                                   qntd_ninhos   INTEGER,
                                   qntd_ovos     INTEGER,
                                   riscos        VARCHAR(500),
                                   especie       VARCHAR(100) NOT NULL,
                                   usuario_login VARCHAR(50) NOT NULL
);

ALTER TABLE regiao_monitorada ADD CONSTRAINT regiao_monitorada_pk PRIMARY KEY ( id );

CREATE TABLE registro_incidentes (
                                     id                   INTEGER NOT NULL,
                                     data                 DATE NOT NULL,
                                     especie              VARCHAR(100),
                                     descricao            VARCHAR(500) NOT NULL,
                                     usuario_login        VARCHAR(50) NOT NULL,
                                     regiao_monitorada_id INTEGER NOT NULL
);

ALTER TABLE registro_incidentes ADD CONSTRAINT registro_incidentes_pk PRIMARY KEY ( id );

CREATE TABLE usuario (
                         login VARCHAR(50) NOT NULL,
                         nome  VARCHAR(500) NOT NULL,
                         email VARCHAR(100) NOT NULL,
                         senha VARCHAR (50) NOT NULL
);

ALTER TABLE usuario ADD CONSTRAINT usuario_pk PRIMARY KEY ( login );

ALTER TABLE regiao_monitorada
    ADD CONSTRAINT regiao_monitorada_usuario_fk FOREIGN KEY ( usuario_login )
        REFERENCES usuario ( login );

ALTER TABLE registro_incidentes
    ADD CONSTRAINT registro_incidentes_regiao_monitorada_fk FOREIGN KEY ( regiao_monitorada_id )
        REFERENCES regiao_monitorada ( id );

ALTER TABLE registro_incidentes
    ADD CONSTRAINT registro_incidentes_usuario_fk FOREIGN KEY ( usuario_login )
        REFERENCES usuario ( login );