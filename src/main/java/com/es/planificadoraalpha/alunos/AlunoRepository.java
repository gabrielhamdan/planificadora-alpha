package com.es.planificadoraalpha.alunos;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    List<Aluno> findByProfessorId(int id);

    List<Aluno> findByNomeContainingIgnoreCaseAndProfessorId(String nome, int id);

}
