package com.example.aula001.exception;

public class ConverteString {

    //Tenho que verifica se oque esta vindo e um letra e caso for um numero lança uma exeção
    public Long converte(String id){
        Long a = Long.parseLong(id);
        System.out.println("TEste Develop");
        return a;

    }
}
