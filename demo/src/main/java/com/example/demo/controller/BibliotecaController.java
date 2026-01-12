package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.BibliotecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BibliotecaController {

    @Autowired
    private BibliotecaService service;

    // GET: http://localhost:8080/api/livros
    @GetMapping("/livros")
    public List<Livro> listarLivros() {
        return service.listarTodosLivros();
    }

    // GET: http://localhost:8080/api/livros/busca?titulo=Design Patterns
    @GetMapping("/livros/busca")
    public Livro buscarLivro(@RequestParam String titulo) {
        return service.buscarLivro(titulo);
    }

    // POST: http://localhost:8080/api/livros
    @PostMapping("/livros")
    public String adicionarLivro(@RequestBody Livro livro) {
        return service.adicionarLivro(livro);
    }

    // POST: http://localhost:8080/api/usuarios
    @PostMapping("/usuarios")
    public Membro registrarUsuario(@RequestBody Membro membro) {
        return service.registrarUsuario(membro);
    }

    // POST: http://localhost:8080/api/emprestimos
    @PostMapping("/emprestimos")
    public String emprestar(@RequestBody Emprestimo emprestimo) {
        return service.emprestarLivro(emprestimo);
    }
}