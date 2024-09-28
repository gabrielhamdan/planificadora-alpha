package com.es.planificadoraalpha.usuarios.usuario;

import com.es.planificadoraalpha.usuarios.Professor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${app.base-url}/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/{id}")
    public UsuarioDto findById(@PathVariable int id) {
        return usuarioService.buscaUsuario(id);
    }

    @PostMapping
    public ResponseEntity registraUsuario(@RequestBody Professor professor) {
        return usuarioService.registraUsuario(professor);
    }

    @PutMapping
    public void alteraUsuario(@RequestBody UsuarioDto usuarioDto) {
        usuarioService.alteraUsuario(usuarioDto);
    }

    @PutMapping("/pwd")
    public ResponseEntity alteraSenha(@RequestBody SenhaDto senhaDto) {
        return usuarioService.alteraSenha(senhaDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        usuarioService.deleteById(id);
    }

}
