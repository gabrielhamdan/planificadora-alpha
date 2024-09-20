package com.es.planificadoraalpha.alunos;

import com.es.planificadoraalpha.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService implements IService<Aluno> {

    private AlunoRepository alunoRepository;

    @Autowired
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Override
    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    @Override
    public Aluno findById(int id) {
        Optional<Aluno> restult = alunoRepository.findById(id);
        return restult.orElse(null);
    }

    @Override
    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @Override
    public void deleteById(int id) {
        alunoRepository.deleteById(id);
    }

}
