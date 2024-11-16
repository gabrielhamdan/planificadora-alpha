package com.es.planificadoraalpha.pacoteaulas;

import com.es.planificadoraalpha.aulas.Aula;
import com.es.planificadoraalpha.aulas.AulaRepository;
import com.es.planificadoraalpha.services.ICrudService;
import com.es.planificadoraalpha.usuarios.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacoteAulaService implements ICrudService<PacoteAula> {

    private final PacoteAulaRepository pacoteAulaRepository;
    private final AulaRepository aulaRepository;

    @Autowired
    public PacoteAulaService(PacoteAulaRepository pacoteAulaRepository, AulaRepository aulaRepository) {
        this.pacoteAulaRepository = pacoteAulaRepository;
        this.aulaRepository = aulaRepository;
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
        Optional<PacoteAula> result = pacoteAulaRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public PacoteAula save(PacoteAula pacoteAula) {
        PacoteAula savedPacoteAula = pacoteAulaRepository.save(pacoteAula);

        for (Aula aula : savedPacoteAula.getAulas()) {
            aula.setPacoteAula(savedPacoteAula);
            aula.setProfessorId(savedPacoteAula.getProfessorId());
        }

        aulaRepository.saveAll(savedPacoteAula.getAulas());

        return savedPacoteAula;
    }

    @Override
    public void deleteById(int id) {
        pacoteAulaRepository.deleteById(id);
    }

}
