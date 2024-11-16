package com.es.planificadoraalpha.aulas;

import com.es.planificadoraalpha.pacoteaulas.PacoteAula;
import com.es.planificadoraalpha.pagamentos.Pagamento;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="aula")
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name="status_aula")
    private StatusAula statusAula;

    private LocalDate data;

    @Column(name="hora_inicial")
    private LocalTime horaInicial;

    @Column(name="hora_final")
    private LocalTime horaFinal;

    @Column(name="tarefas_de_casa")
    private String tarefasDeCasa;

    private String anotacoes;

    @OneToOne(mappedBy = "aula")
    @JsonManagedReference
    private Pagamento pagamento;

    @ManyToOne
    @JoinColumn(name = "pacote_aula_id")
    @JsonBackReference
    private PacoteAula pacoteAula;

    @Column(name = "professor_id")
    private int professorId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StatusAula getStatusAula() {
        return statusAula;
    }

    public void setStatusAula(StatusAula statusAula) {
        this.statusAula = statusAula;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(LocalTime horaInicial) {
        this.horaInicial = horaInicial;
    }

    public LocalTime getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(LocalTime horaFinal) {
        this.horaFinal = horaFinal;
    }

    public String getTarefasDeCasa() {
        return tarefasDeCasa;
    }

    public void setTarefasDeCasa(String tarefasDeCasa) {
        this.tarefasDeCasa = tarefasDeCasa;
    }

    public String getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public PacoteAula getPacoteAula() {
        return pacoteAula;
    }

    public void setPacoteAula(PacoteAula pacoteAula) {
        this.pacoteAula = pacoteAula;
    }

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

}
