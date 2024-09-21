package com.es.planificadoraalpha.usuarios.autenticacao;

import com.es.planificadoraalpha.services.ICrudService;
import com.es.planificadoraalpha.usuarios.Professor;
import com.es.planificadoraalpha.usuarios.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutenticacaoService implements ICrudService<Professor> {

    private ProfessorRepository professorRepository;

    @Autowired
    public AutenticacaoService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    public List<Professor> findAll() {
        return null;
    }

    @Override
    public Professor findById(int id) {
        Optional<Professor> result = professorRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    public void deleteById(int id) {
        professorRepository.deleteById(id);
    }
}
