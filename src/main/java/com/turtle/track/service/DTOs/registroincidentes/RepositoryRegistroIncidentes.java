package com.turtle.track.service.DTOs.registroincidentes;

import com.turtle.track.domain.entities.RegistroIncidentes;
import jakarta.persistence.Id;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryRegistroIncidentes extends JpaRepository<RegistroIncidentes, Id> {
    Page<RegistroIncidentes> findAll(Pageable paginacao);
}
