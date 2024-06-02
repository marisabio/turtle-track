package com.turtle.track.controllers;

import com.turtle.track.domain.entities.RegistroIncidentes;
import com.turtle.track.exceptions.ResourceNotFoundException;
import com.turtle.track.service.DTOs.registroincidentes.DadosAtualizacaoRegistroIncidentes;
import com.turtle.track.service.DTOs.registroincidentes.DadosCadastroRegistroIncidentes;
import com.turtle.track.service.DTOs.registroincidentes.DadosListagemRegistroIncidentes;
import com.turtle.track.service.DTOs.registroincidentes.RepositoryRegistroIncidentes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/incidentes")
@Tag(name = "Registro de Incidentes", description = "CRUD do Registro de Incidentes.")
public class RegistroIncidentesController {

    @Autowired
    private RepositoryRegistroIncidentes repositoryRegistroIncidentes;

    @PostMapping
    @Transactional
    @Operation(summary = "Cadastro de um registro de incidente", description = "Endpoint do cadastro de um registro de incidente.")
    public ResponseEntity<DadosListagemRegistroIncidentes> cadastrar(@RequestBody @Valid DadosCadastroRegistroIncidentes dados, UriComponentsBuilder uriBuilder) {
        var incidente = new RegistroIncidentes(dados);
        repositoryRegistroIncidentes.save(incidente);
        var uri = uriBuilder.path("/incidentes/{id}").buildAndExpand(incidente.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemRegistroIncidentes(incidente));
    }

    @GetMapping(produces = "application/json")
    @Operation(summary = "Listagem de registros de incidentes", description = "Endpoint da exibição de registros de incidentes.")
    public ResponseEntity<Page<DadosListagemRegistroIncidentes>> listar(@PageableDefault(size = 10)Pageable paginacao) {
        var page = repositoryRegistroIncidentes.findAll(paginacao).map(DadosListagemRegistroIncidentes::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    @Operation(summary = "Exibir registro de incidente", description = "Endpoint da exibição de um único registro de incidente.")
    public ResponseEntity<DadosListagemRegistroIncidentes> exibir(@PathVariable Long id) {
        var incidente = repositoryRegistroIncidentes.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Registro de incidente não encontrado com o Id :: " + id));
        return ResponseEntity.ok(new DadosListagemRegistroIncidentes(incidente));
    }

    @PutMapping
    @Transactional
    @Operation(summary = "Atualizar registro de incidente", description = "Endpoint da atualização de um único registro de incidente.")
    public ResponseEntity<DadosListagemRegistroIncidentes> atualizar(@RequestBody @Valid DadosAtualizacaoRegistroIncidentes dados) {
        var incidente = repositoryRegistroIncidentes.findById(dados.id())
                .orElseThrow(() -> new ResourceNotFoundException("Registro de incidente não encontrado com o Id :: " + dados.id()));
        incidente.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosListagemRegistroIncidentes(incidente));
    }

    @DeleteMapping(path = "/{id}")
    @Transactional
    @Operation(summary = "Excluir registro de incidente", description = "Endpoint da exclusão de um único registro de incidente.")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        var incidente = repositoryRegistroIncidentes.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Registro de incidente não encontrado com o Id :: " + id));
        repositoryRegistroIncidentes.delete(incidente);
        return ResponseEntity.ok("Incidente " + id + " deletado.");
    }
}
