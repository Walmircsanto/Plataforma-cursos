package com.example.aula001.domain;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Turma implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String turno;
    @Column(nullable = false)
    private Date dataInicio;
    @Column(nullable = false)
    private Date dataFIm;
    @Column(nullable = false)
    private String horas;
    @Column(nullable = false)
    private Integer quantVagas;

    @Column(nullable = false)
    @OneToMany // uma turma tem muitos cursos
    private List<Curso> curso;
    @Column(nullable = false)
    @ManyToMany

    private List<Aluno> alunos = new ArrayList<>();

    public Turma() {
    }

    public Turma(Long id, String turno, Date dataInicio, Date dataFIm, String horas, Integer quantVagas) {
        this.id = id;
        this.turno = turno;
        this.dataInicio = dataInicio;
        this.dataFIm = dataFIm;
        this.horas = horas;
        this.quantVagas = quantVagas;
    }



    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Curso> getCurso() {
        return curso;
    }

    public void setCurso(List<Curso> curso) {
        this.curso = curso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFIm() {
        return dataFIm;
    }

    public void setDataFIm(Date dataFIm) {
        this.dataFIm = dataFIm;
    }

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }

    public Integer getQuantVagas() {
        return quantVagas;
    }

    public void setQuantVagas(Integer quantVagas) {
        this.quantVagas = quantVagas;
    }
}
