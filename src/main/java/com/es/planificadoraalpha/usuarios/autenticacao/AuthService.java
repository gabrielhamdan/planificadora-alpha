package com.es.planificadoraalpha.usuarios.autenticacao;

import com.es.planificadoraalpha.usuarios.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    private ProfessorRepository professorRepository;

    @Autowired
    public AuthService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return professorRepository.findByUsuario(username);
    }

}
