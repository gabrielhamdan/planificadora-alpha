package com.es.planificadoraalpha.pagamentos;

import com.es.planificadoraalpha.aulas.Aula;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="data_pagamento")
    private LocalDate dataPagamento;

    @Column(name="valor_pago")
    private float valorPago;

    @OneToOne
    @JoinColumn(name="aula_id")
    @JsonBackReference
    private Aula aula;

    public Pagamento() {}

    public Pagamento(LocalDate dataPagamento, float valorPago) {
        this.dataPagamento = dataPagamento;
        this.valorPago = valorPago;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public float getValorPago() {
        return valorPago;
    }

    public void setValorPago(float valorPago) {
        this.valorPago = valorPago;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

}
