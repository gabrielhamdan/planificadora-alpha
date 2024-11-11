package com.es.planificadoraalpha.pacoteaulas;

import com.es.planificadoraalpha.alunos.Aluno;
import com.es.planificadoraalpha.aulas.Aula;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="pacote_aula")
public class PacoteAula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalAula localAula;

    private float valorHoraAula;

    @OneToMany(mappedBy = "pacoteAula")
    private List<Aula> aulas;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @Column(name = "professor_id")
    private int professorId;

    public PacoteAula() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalAula getLocalAula() {
        return localAula;
    }

    public void setLocalAula(LocalAula localAula) {
        this.localAula = localAula;
    }

    public float getValorHoraAula() {
        return valorHoraAula;
    }

    public void setValorHoraAula(float valorHoraAula) {
        this.valorHoraAula = valorHoraAula;
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

}
