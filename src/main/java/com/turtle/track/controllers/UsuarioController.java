package com.turtle.track.controllers;

import com.turtle.track.domain.entities.Usuario;
import com.turtle.track.exceptions.ResourceNotFoundException;
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
import com.turtle.track.service.DTOs.usuario.DadosAtualizacaoUsuario;
import com.turtle.track.service.DTOs.usuario.DadosCadastroUsuario;
import com.turtle.track.service.DTOs.usuario.DadosListagemUsuario;
import com.turtle.track.service.DTOs.usuario.RepositoryUsuario;

@RestController
@RequestMapping("/usuarios")
@Tag(name = "Usuario", description = "CRUD do Usuario.")
public class UsuarioController {

    @Autowired
    private RepositoryUsuario repositoryUsuario;

    @PostMapping
    @Transactional
    @Operation(summary = "Cadastro de usuário", description = "Endpoint do cadastro de novos usuários.")
    public ResponseEntity<DadosListagemUsuario> cadastrar(@RequestBody @Valid DadosCadastroUsuario dados, UriComponentsBuilder uriBuilder) {
        var usuario = new Usuario(dados);
        repositoryUsuario.save(usuario);
        var uri = uriBuilder.path("/usuarios/{login}").buildAndExpand(usuario.getLogin()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemUsuario(usuario));
    }

    @GetMapping(produces = "application/json")
    @Operation(summary = "Listagem de usuários", description = "Endpoint da listagem de usuários cadastrados.")
    public ResponseEntity<Page<DadosListagemUsuario>> listar(@PageableDefault(size = 10) Pageable paginacao) {
        var page = repositoryUsuario.findAll(paginacao).map(DadosListagemUsuario::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping(path = "/{login}", produces = "application/json")
    @Operation(summary = "Exibir usuário", description = "Endpoint da exibição de um único usuário cadastrado.")
    public ResponseEntity<DadosListagemUsuario> exibir(@PathVariable String login) {
        var usuario = repositoryUsuario.findById(login)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o Id :: " + login));
        return ResponseEntity.ok(new DadosListagemUsuario(usuario));
    }

    @PutMapping
    @Transactional
    @Operation(summary = "Atualizar usuário", description = "Endpoint da atualização de um único usuário cadastrado.")
    public ResponseEntity<DadosListagemUsuario> atualizar(@RequestBody @Valid DadosAtualizacaoUsuario dados) {
        var usuario = repositoryUsuario.findById(dados.login())
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o Id :: " + dados.login()));
        usuario.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosListagemUsuario(usuario));
    }

    @DeleteMapping(path = "/{login}")
    @Transactional
    @Operation(summary = "Excluir usuário", description = "Endpoint da exclusão de um único usuário cadastrado.")
    public ResponseEntity<String> excluir(@PathVariable String login) {
        var cliente = repositoryUsuario.findById(login)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o Id :: " + login));
        repositoryUsuario.delete(cliente);
        return ResponseEntity.ok("Usuário " + login + " deletado.");
    }

}
