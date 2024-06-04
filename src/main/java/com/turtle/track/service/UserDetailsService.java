package com.turtle.track.service;

import com.turtle.track.domain.entities.Usuario;
import com.turtle.track.service.DTOs.usuario.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsService {

    @Autowired
    private RepositoryUsuario repositoryUsuario;

    public UserDetails carregarDetalhesPorLogin(String login) {
        Usuario usuario = repositoryUsuario.findById(login)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Usuário não encontrado: " + login));

        return new User(usuario.getLogin(),usuario.getSenha(),new ArrayList<>());
    }
}
