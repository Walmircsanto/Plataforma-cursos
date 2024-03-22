package com.example.aula001.domain;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Curso implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private Double preco;
    @Column(nullable = false)
    private String nivel;

    @JoinColumn(nullable = false)
    @OneToOne(cascade = CascadeType.MERGE)
    private Professor professor;

    @Column(nullable = false)
    private StatusCurso statusCurso;

    @Column(nullable = false)
    @OneToMany // um curso tem muitas turmas
    private List<Turma> turma = new ArrayList<>();

    public Curso() {
    }

    public Curso(Long id, String name, String descricao, Double preco, String nivel) {
        this.id = id;
        this.name = name;
        this.descricao = descricao;
        this.preco = preco;
        this.nivel = nivel;
        this.statusCurso= StatusCurso.ABERTO;
    }

    public List<Turma> getTurma() {
        return turma;
    }

    public void setTurma(List<Turma> turma) {
        this.turma = turma;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public StatusCurso getStatusCurso() {
        return statusCurso;
    }

    public void setStatusCurso(StatusCurso statusCurso) {
        this.statusCurso = statusCurso;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", nivel='" + nivel + '\'' +
                '}';
    }
}
