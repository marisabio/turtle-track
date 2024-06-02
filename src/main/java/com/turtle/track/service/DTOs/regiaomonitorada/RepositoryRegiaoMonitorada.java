package com.turtle.track.service.DTOs.regiaomonitorada;

import com.turtle.track.domain.entities.RegiaoMonitorada;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryRegiaoMonitorada extends JpaRepository<RegiaoMonitorada, Long> {
    Page<RegiaoMonitorada> findAll(Pageable paginacao);
}
