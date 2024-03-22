package com.example.aula001.DTO;

import com.example.aula001.domain.Aluno;
import com.example.aula001.domain.Turma;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class AlunoDTO {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String cpf;

    private String email;


    private String telefone;



    private List<Turma> turma = new ArrayList<>();

    public AlunoDTO() {
    }

    public AlunoDTO(Aluno aluno) {
        this.id = aluno.getId();
        this.name = aluno.getName();
        this.cpf = aluno.getCpf();
        this.email = aluno.getEmail();
        this.telefone = aluno.getTelefone();
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    @Override
    public String toString() {
        return "AlunoDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", turma=" + turma +
                '}';
    }
}
