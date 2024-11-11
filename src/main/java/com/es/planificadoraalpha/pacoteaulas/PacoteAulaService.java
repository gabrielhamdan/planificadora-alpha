package com.es.planificadoraalpha.pacoteaulas;

import com.es.planificadoraalpha.services.ICrudService;
import com.es.planificadoraalpha.usuarios.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacoteAulaService implements ICrudService<PacoteAula> {

    private final PacoteAulaRepository pacoteAulaRepository;

    @Autowired
    public PacoteAulaService(PacoteAulaRepository pacoteAulaRepository) {
        this.pacoteAulaRepository = pacoteAulaRepository;
    }

    public List<PacoteAula> findByIdProfessor() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return pacoteAulaRepository.findByProfessorId(((Professor) userDetails).getId());
    }

    @Override
    public List<PacoteAula> findAll() {
        return null;
    }

    @Override
    public PacoteAula findById(int id) {
        return null;
    }

    @Override
    public PacoteAula save(PacoteAula pacoteAula) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

}
