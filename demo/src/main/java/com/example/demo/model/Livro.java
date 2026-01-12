package com.example.demo.model;

public class Livro {
    public String isbn;
    public String titulo;
    public String autor;
    public boolean disponivel;

    public Livro() {} // Construtor vazio para JSON

    public Livro(String isbn, String titulo, String autor) {
    this.isbn = isbn;
    this.titulo = titulo;
    this.autor = autor;
    this.disponivel = true;
    }
}