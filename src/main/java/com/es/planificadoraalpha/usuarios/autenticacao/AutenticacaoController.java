package com.es.planificadoraalpha.usuarios.autenticacao;

import com.es.planificadoraalpha.security.TokenService;
import com.es.planificadoraalpha.usuarios.Professor;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${app.base-url}/auth")
public class AutenticacaoController {

    private AuthenticationManager authenticationManager;
    private AutenticacaoService autenticacaoService;
    private TokenService tokenService;

    @Autowired
    public AutenticacaoController(AuthenticationManager authenticationManager, AutenticacaoService autenticacaoService, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.autenticacaoService = autenticacaoService;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AutenticacaoDto autenticacaoDto) {
        var login = new UsernamePasswordAuthenticationToken(autenticacaoDto.usuario(), autenticacaoDto.senha());
        var auth = authenticationManager.authenticate(login);

        var token = tokenService.gerarToken((Professor) auth.getPrincipal());

        return ResponseEntity.ok(new AutenticacaoResponseDto(token));
    }

    @PostMapping("/register")
    public ResponseEntity registraUsuario(@RequestBody Professor professor) {
        if (autenticacaoService.findById(professor.getId()) != null) return ResponseEntity.badRequest().build();

        String senhaBCrypt = new BCryptPasswordEncoder().encode(professor.getSenha());
        professor.setSenha(senhaBCrypt);
        autenticacaoService.save(professor);

        return ResponseEntity.ok().build();
    }

}
