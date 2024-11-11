package com.es.planificadoraalpha.aulas;

import com.es.planificadoraalpha.services.ICrudService;
import com.es.planificadoraalpha.usuarios.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AulaService implements ICrudService<Aula> {

    private final AulaRepository aulaRepository;

    @Autowired
    public AulaService(AulaRepository aulaRepository) {
        this.aulaRepository = aulaRepository;
    }

    public List<Aula> findByPacoteAulaId() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return aulaRepository.findByPacoteAulaId(((Professor)userDetails).getId());
    }

    @Override
    public List<Aula> findAll() {
        return null;
    }

    @Override
    public Aula findById(int id) {
        Optional<Aula> result = aulaRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public Aula save(Aula aula) {
        return aulaRepository.save(aula);
    }

    @Override
    public void deleteById(int id) {
        aulaRepository.deleteById(id);
    }

}
