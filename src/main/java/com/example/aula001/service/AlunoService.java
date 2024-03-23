package com.example.aula001.service;

import com.example.aula001.DTO.AlunoDTO;
import com.example.aula001.domain.Aluno;
import com.example.aula001.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public AlunoDTO getById(Long id) {
        AlunoDTO alunoDTO;
        Aluno aluno = alunoRepository.getById(id);
        return new AlunoDTO(aluno);
    }

    public AlunoDTO addAluno(Aluno aluno){
        Aluno a = alunoRepository.save(aluno);
        return new AlunoDTO(a);

    }

    public List<AlunoDTO> getAll(){
        List<Aluno> alunos = alunoRepository.findAll();
        List<AlunoDTO> alunosDTO = new ArrayList<>();
        for(Aluno a: alunos){
            alunosDTO.add(new AlunoDTO(a));
        }
        return alunosDTO;
    }

    public void delete(Long id){
        AlunoDTO alunoDTO = getById(id);
        Aluno aluno = new Aluno(alunoDTO);
        if(alunoDTO != null){
          alunoRepository.delete(aluno);
        }
    }

    public void update(Aluno aluno){
        AlunoDTO alunoDTO = getById(aluno.getId());
        Aluno alunoo = new Aluno(alunoDTO);
        if(alunoo != null){
            alunoRepository.save(aluno);
        }
    }
}
