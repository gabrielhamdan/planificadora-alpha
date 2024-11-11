package com.es.planificadoraalpha.pacoteaulas;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PacoteAulaRepository extends JpaRepository<PacoteAula, Integer> {

    List<PacoteAula> findByProfessorId(int id);

}
