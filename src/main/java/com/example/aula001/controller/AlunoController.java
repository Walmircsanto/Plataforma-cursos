package com.example.aula001.controller;

import com.example.aula001.DTO.AlunoDTO;
import com.example.aula001.domain.Aluno;
import com.example.aula001.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aluno")

public class AlunoController {

    @Autowired
    private AlunoService alunoService;
    @PostMapping
    public ResponseEntity<AlunoDTO> addAluno(@RequestBody Aluno aluno){
        return new ResponseEntity<>(  alunoService.addAluno(aluno), HttpStatus.CREATED);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<AlunoDTO> getById(@PathVariable String id){
         Long a = Long.parseLong(id);
         AlunoDTO alunoDTO = alunoService.getById(a);
             return ResponseEntity.ok().body(alunoDTO);

    }

    @GetMapping(value = "/alunos")
    public ResponseEntity<List<AlunoDTO>> getAll(){
        List<AlunoDTO> alunos = alunoService.getAll();
        return ResponseEntity.ok(alunos);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete( @PathVariable Long id){
       //Esse metodo utilizando o optional  deveria  ser implementado no service ja que o mesmo não deve
        // ser tão verboso(O controller)
           this.alunoService.delete(id);
            return ResponseEntity.ok().build();
    }
    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Aluno aluno){
        this.alunoService.update(aluno);
        return  ResponseEntity.ok().build();


    }
}
