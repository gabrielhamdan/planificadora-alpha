package com.es.planificadoraalpha.alunos;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${app.base-url}/alunos")
public class AlunoController {

    private AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public List<Aluno> listarAlunos() {
        return alunoService.findAll();
    }

    @GetMapping("/{id}")
    public Aluno pesquisarAluno(@PathVariable int id) {
        return alunoService.findById(id);
    }

    @PostMapping
    public Aluno cadastrarAluno(@RequestBody Aluno aluno) {
        return alunoService.save(aluno);
    }

    @PutMapping
    public Aluno alterarAluno(@RequestBody Aluno aluno) {
        return alunoService.save(aluno);
    }

    @DeleteMapping("/{id}")
    public void excluirAluno(@PathVariable int id) {
        alunoService.deleteById(id);
    }

}
