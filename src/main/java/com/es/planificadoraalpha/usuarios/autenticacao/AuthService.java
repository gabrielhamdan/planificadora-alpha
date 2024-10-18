package com.es.planificadoraalpha.usuarios.autenticacao;

import com.es.planificadoraalpha.security.TokenService;
import com.es.planificadoraalpha.usuarios.Professor;
import com.es.planificadoraalpha.usuarios.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    private final TokenService tokenService;
    private final ProfessorRepository professorRepository;

    @Autowired
    public AuthService(TokenService tokenService, ProfessorRepository professorRepository) {
        this.tokenService = tokenService;
        this.professorRepository = professorRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return professorRepository.findByUsuario(username);
    }

    public AutenticacaoResponseDto login(AutenticacaoDto autenticacaoDto, AuthenticationManager authenticationManager) {
        var login = new UsernamePasswordAuthenticationToken(autenticacaoDto.usuario(), autenticacaoDto.senha());
        var auth = authenticationManager.authenticate(login);

        var token = tokenService.gerarToken((Professor) auth.getPrincipal());

        return new AutenticacaoResponseDto(token, ((Professor) auth.getPrincipal()).getId());
    }

}
