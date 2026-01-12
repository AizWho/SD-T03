package com.example.demo.model;
public abstract class Usuario {
    public int id;
    public String nome;
    public Usuario() {}
    public Usuario(int id, String nome) { this.id = id; this.nome = nome; }
}