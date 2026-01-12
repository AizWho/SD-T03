package com.example.demo.model;

//import java.time.LocalDate;

public class Emprestimo {
    public Livro livro;
    public Membro membro;
    public String dataEmprestimo; // Simplificado para String para facilitar JSON
    public String dataPrevistaDevolucao;

    public Emprestimo() {}
}