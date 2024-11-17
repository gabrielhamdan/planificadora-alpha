package com.es.planificadoraalpha.aulas;

import java.time.LocalDate;
import java.time.LocalTime;

public class AulaAlunoDTO {

    private int idAula;
    private LocalDate data;
    private LocalTime horaInicial;
    private LocalTime horaFinal;
    private String tarefasDeCasa;
    private StatusAula statusAula;
    private String nomeAluno;

    public AulaAlunoDTO(int idAula, LocalDate data, LocalTime horaInicial, LocalTime horaFinal, String tarefasDeCasa, StatusAula statusAula, String nomeAluno) {
        this.idAula = idAula;
        this.data = data;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
        this.tarefasDeCasa = tarefasDeCasa;
        this.statusAula = statusAula;
        this.nomeAluno = nomeAluno;
    }

    // Getters e setters
    public int getIdAula() {
        return idAula;
    }

    public void setIdAula(int idAula) {
        this.idAula = idAula;
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

    public StatusAula getStatusAula() {
        return statusAula;
    }

    public void setStatusAula(StatusAula statusAula) {
        this.statusAula = statusAula;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

}
