package com.es.planificadoraalpha.aulas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${app.base-url}/aulas")
public class AulaController {

    private final AulaService aulaService;

    @Autowired
    public AulaController(AulaService aulaService) {
        this.aulaService = aulaService;
    }

    @GetMapping
    public List<Aula> listarAulas() {
        return aulaService.findByPacoteAulaId();
    }

    @GetMapping("/{id}")
    public Aula pesquisarAula(@PathVariable int id) {
        return aulaService.findById(id);
    }

    @PostMapping
    public Aula cadastrarAula(@RequestBody Aula aula) {
        return aulaService.save(aula);
    }

    @PutMapping
    public Aula alterarAula(@RequestBody Aula aula) {
        return aulaService.save(aula);
    }

    @DeleteMapping("/{id}")
    public void excluirAula(@PathVariable int id) {
        aulaService.deleteById(id);
    }

}
