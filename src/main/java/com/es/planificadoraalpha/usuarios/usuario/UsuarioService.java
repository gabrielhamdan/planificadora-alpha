package com.es.planificadoraalpha.usuarios.usuario;

import com.es.planificadoraalpha.services.ICrudService;
import com.es.planificadoraalpha.usuarios.Professor;
import com.es.planificadoraalpha.usuarios.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements ICrudService<Professor> {

    private ProfessorRepository professorRepository;

    @Autowired
    public UsuarioService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    public List<Professor> findAll() {
        return null;
    }

    @Override
    public Professor findById(int id) {
        Optional<Professor> result = professorRepository.findById(id);
        return result.orElse(null);
    }

    public UsuarioDto buscaUsuario(int id) {
        Professor professor = findById(id);

        return new UsuarioDto(
                professor.getId(),
                professor.getUsuario(),
                professor.getNome(),
                professor.getCpf(),
                professor.getArea()
        );
    }

    @Override
    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }

    public void alteraUsuario(UsuarioDto usuarioDto) {
        Professor professor = findById(usuarioDto.id());
        professor.setNome(usuarioDto.nome());
        professor.setCpf(usuarioDto.cpf());
        professor.setArea(usuarioDto.area());
        save(professor);
    }

    @Override
    public void deleteById(int id) {
        professorRepository.deleteById(id);
    }

    public Professor findByUsuario(String usuario) {
        return professorRepository.findByUsuario(usuario);
    }

    public ResponseEntity registraUsuario(Professor professor) {
        if (findByUsuario(professor.getUsuario()) != null) return ResponseEntity.badRequest().build(); // TODO: retorna response de que usuário já existe

        professor.setSenha(encriptaSenha(professor.getSenha()));
        save(professor);

        return ResponseEntity.ok().build();
    }

    public ResponseEntity alteraSenha(SenhaDto senhaDto) {
        if (!senhaDto.novaSenha().equals(senhaDto.confirmacaoSenha()))
            return ResponseEntity.badRequest().body("senhas diferem"); // TODO: tratamento do erro

        Professor professor = findById(senhaDto.idUsuario());
        professor.setSenha(encriptaSenha(senhaDto.novaSenha()));
        save(professor);

        return ResponseEntity.ok().build();
    }

    public String encriptaSenha(String senha) {
        return new BCryptPasswordEncoder().encode(senha);
    }

}
