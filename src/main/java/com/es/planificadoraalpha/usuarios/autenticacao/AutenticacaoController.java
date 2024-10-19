package com.es.planificadoraalpha.usuarios.autenticacao;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${app.base-url}/auth")
public class AutenticacaoController {

    private final AuthenticationManager authenticationManager;
    private final AuthService authService;

    @Autowired
    public AutenticacaoController(AuthenticationManager authenticationManager, AuthService authService) {
        this.authenticationManager = authenticationManager;
        this.authService = authService;
    }

    @PostMapping("/logout")
    public ResponseEntity logout() {
        authService.logout();
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AutenticacaoDto autenticacaoDto) {
        return ResponseEntity.ok(authService.login(autenticacaoDto, authenticationManager));
    }

}
