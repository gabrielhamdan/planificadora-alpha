package com.es.planificadoraalpha.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

   Professor findByUsuario(String usuario);

}
