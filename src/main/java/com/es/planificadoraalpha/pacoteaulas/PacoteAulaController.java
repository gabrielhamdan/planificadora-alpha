package com.es.planificadoraalpha.pacoteaulas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${app.base-url}/pacote-aulas")
public class PacoteAulaController {

    private final PacoteAulaService pacoteAulaService;

    @Autowired
    public PacoteAulaController(PacoteAulaService pacoteAulaService) {
        this.pacoteAulaService = pacoteAulaService;
    }

    @GetMapping()
    public List<PacoteAula> listarPacotesAula() {
        return pacoteAulaService.findByIdProfessor();
    }

    @GetMapping("{id}")
    public PacoteAula pesquisarPacoteAula(@PathVariable int id) {
        return pacoteAulaService.findById(id);
    }

    @PostMapping()
    public PacoteAula cadastrarPacoteAula(@RequestBody PacoteAula pacoteAula) {
        return pacoteAulaService.save(pacoteAula);
    }

    @PutMapping()
    public PacoteAula alterarPacoteAula(@RequestBody PacoteAula pacoteAula) {
        return pacoteAulaService.save(pacoteAula);
    }

    @DeleteMapping("{id}")
    public void excluirPacoteAula(@PathVariable int id) {
        pacoteAulaService.deleteById(id);
    }

}
