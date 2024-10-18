package com.es.planificadoraalpha.alunos;

import com.es.planificadoraalpha.usuarios.Professor;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private SituacaoAluno situacao;

    private String nome;

    private String cpf;

    @Column(name="data_nascimento")
    private LocalDate dataNascimento;

    private String email;

    private String telefone;

    private String endereco;

    private String nivel;

    @Column(name="objetivo_aprendizado")
    private String objetivoAprendizado;

    @Column(name = "professor_id")
    private int professorId;

    public Aluno() { }

    public Aluno(String nome, String cpf, LocalDate dataNascimento, String email, String telefone, String endereco, String nivel, String objetivoAprendizado, int professorId) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.nivel = nivel;
        this.objetivoAprendizado = objetivoAprendizado;
        this.professorId = professorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SituacaoAluno getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoAluno situacao) {
        this.situacao = situacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getObjetivoAprendizado() {
        return objetivoAprendizado;
    }

    public void setObjetivoAprendizado(String objetivoAprendizado) {
        this.objetivoAprendizado = objetivoAprendizado;
    }

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

}
