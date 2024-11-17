package com.es.planificadoraalpha.aulas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AulaRepository extends JpaRepository<Aula, Integer> {

    @Query("SELECT new com.es.planificadoraalpha.aulas.AulaAlunoDTO(" +
            "a.id, a.data, a.horaInicial, a.horaFinal, a.tarefasDeCasa, a.statusAula, aln.nome) " +
            "FROM Aula a " +
            "JOIN a.pacoteAula pal " +
            "JOIN pal.aluno aln " +
            "WHERE a.professorId = :professorId AND a.data >= CURDATE()")
    List<AulaAlunoDTO> findAulasByProfessorId(@Param("professorId") int professorId);

}
