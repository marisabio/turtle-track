package com.turtle.track.service.DTOs.usuario;

import com.turtle.track.domain.entities.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryUsuario extends JpaRepository<Usuario, String> {
    Page<Usuario> findAll(Pageable paginacao);
}
