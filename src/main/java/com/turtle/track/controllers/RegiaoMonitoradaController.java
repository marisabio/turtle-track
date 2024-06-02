package com.turtle.track.controllers;

import com.turtle.track.domain.entities.RegiaoMonitorada;
import com.turtle.track.exceptions.ResourceNotFoundException;
import com.turtle.track.service.DTOs.regiaomonitorada.DadosAtualizacaoRegiaoMonitorada;
import com.turtle.track.service.DTOs.regiaomonitorada.DadosCadastroRegiaoMonitorada;
import com.turtle.track.service.DTOs.regiaomonitorada.DadosListagemRegiaoMonitorada;
import com.turtle.track.service.DTOs.regiaomonitorada.RepositoryRegiaoMonitorada;
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
@RequestMapping("/regioes")
@Tag(name = "Região Monitorada", description = "CRUD de Regiões Monitoradas.")
public class RegiaoMonitoradaController {

    @Autowired
    private RepositoryRegiaoMonitorada repositoryRegiaoMonitorada;

    @PostMapping
    @Transactional
    @Operation(summary = "Cadastro de região monitorada", description = "Endpoint do cadastro de novas região monitoradas.")
    public ResponseEntity<DadosListagemRegiaoMonitorada> cadastrar(@RequestBody @Valid DadosCadastroRegiaoMonitorada dados, UriComponentsBuilder uriBuilder) {
        var regiao = new RegiaoMonitorada(dados);
        repositoryRegiaoMonitorada.save(regiao);
        var uri = uriBuilder.path("/regioes/{id}").buildAndExpand(regiao.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemRegiaoMonitorada(regiao));
    }

    @GetMapping(produces = "application/json")
    @Operation(summary = "Listagem de regiões monitoradas", description = "Endpoint da listagem de regiões monitoradas.")
    public ResponseEntity<Page<DadosListagemRegiaoMonitorada>> listar(@PageableDefault(size = 10) Pageable paginacao) {
        var page = repositoryRegiaoMonitorada.findAll(paginacao).map(DadosListagemRegiaoMonitorada::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    @Operation(summary = "Exibir região monitorada", description = "Endpoint da exibição de uma única região monitorada.")
    public ResponseEntity<DadosListagemRegiaoMonitorada> exibir(@PathVariable Long id) {
        var regiao = repositoryRegiaoMonitorada.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Região não encontrada com o Id :: " + id));
        return ResponseEntity.ok(new DadosListagemRegiaoMonitorada(regiao));
    }

    @PutMapping
    @Transactional
    @Operation(summary = "Atualizar região monitorada", description = "Endpoint da atualização de uma única região monitorada.")
    public ResponseEntity<DadosListagemRegiaoMonitorada> atualizar(@RequestBody @Valid DadosAtualizacaoRegiaoMonitorada dados) {
        var regiao = repositoryRegiaoMonitorada.findById(dados.id())
                .orElseThrow(() -> new ResourceNotFoundException("Região não encontrada com o Id :: " + dados.id()));
        regiao.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosListagemRegiaoMonitorada(regiao));
    }

    @DeleteMapping(path = "/{id}")
    @Transactional
    @Operation(summary = "Excluir região monitorada", description = "Endpoint da exclusão de uma única região monitorada.")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        var regiao = repositoryRegiaoMonitorada.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Região não encontrada com o Id :: " + id));
        repositoryRegiaoMonitorada.delete(regiao);
        return ResponseEntity.ok("Região " + id + " deletada.");

    }
}
