package com.example.demo.service;

import com.example.demo.model.*;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BibliotecaService {
    private final List<Livro> acervo = new ArrayList<>();
    private static int nextUserId = 200;

    public BibliotecaService() {
        acervo.add(new Livro("978-01", "Design Patterns", "Gamma et al."));
        acervo.add(new Livro("978-02", "Distributed Systems", "Coulouris"));
    }

    public String adicionarLivro(Livro livro) {
        acervo.add(livro);
        return "Livro '" + livro.titulo + "' adicionado com sucesso via API.";
    }

    public Livro buscarLivro(String titulo) {
        return acervo.stream()
        .filter(l -> l.titulo.equalsIgnoreCase(titulo))
        .findFirst()
        .orElse(null);
    }

    public String emprestarLivro(Emprestimo emprestimo) {
        if (emprestimo == null || emprestimo.livro == null) return "Dados inválidos";

        Optional<Livro> acervoLivro = acervo.stream()
        .filter(l -> l.isbn.equals(emprestimo.livro.isbn))
        .findFirst();

        if (acervoLivro.isPresent() && acervoLivro.get().disponivel) {
            acervoLivro.get().disponivel = false;
            return "Empréstimo de '" + emprestimo.livro.titulo + "' realizado com sucesso.";
        }
        return "Falha: Livro indisponível ou inexistente.";
    }

    public Membro registrarUsuario(Membro membro) {
        membro.id = nextUserId++;
        return membro;
    }

    public List<Livro> listarTodosLivros() {
        return acervo;
    }
}