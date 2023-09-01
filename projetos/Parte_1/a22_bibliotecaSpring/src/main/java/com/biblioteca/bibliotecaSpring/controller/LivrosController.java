package com.biblioteca.bibliotecaSpring.controller;

import com.biblioteca.bibliotecaSpring.model.LivrosModel;
import com.biblioteca.bibliotecaSpring.service.LivrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LivrosController {

    @Autowired
    LivrosService livrosService;

    //Endpoints de consulta
    // Requisição GET para exibir todos os livros
    @GetMapping(path = "/livros")
    public List<LivrosModel> exibirTodosLivros() {
        return livrosService.exibirTodosLivros();
    }

    //Requisição GET para exibir um livro por id
    @GetMapping(path = "/livros/{id}")
    public Optional<LivrosModel> exibirLivroPorId(@PathVariable Long id) {
        return livrosService.exibirLivroPorId(id);

    }

    //Endpoints de cadastro
    //Requisição POST para cadastrar um livro
    @PostMapping(path = "/livros")
    @ResponseStatus(HttpStatus.CREATED)
    public LivrosModel cadastrarLivro(@RequestBody LivrosModel livrosModel) {
        return livrosService.cadastrarLivro(livrosModel);

    }

//    //Requisição POST para cadastrar vários livros
//    @PostMapping(path = "/livros")
//    public ResponseEntity<LivrosModel> cadastrarLivros(@RequestBody List<LivrosModel> livrosModel) {
//        return (ResponseEntity<LivrosModel>) livrosService.cadastrarLivros(livrosModel);
//
//    }

    //Requisição PUT para alterar um livro dentro do banco de dados
    @PutMapping(path = "/livros/{id}")
    public LivrosModel alterarLivro(@PathVariable Long id,
                                    @RequestBody LivrosModel livrosModel) {
        return livrosService.alterarLivro(id, livrosModel);

    }

    //Requisição DELETE para excluir um livro
    //aqui não retorna nenhuma resposta
    @DeleteMapping(path = "/livros/{id}")
    public void excluirLivro(@PathVariable Long id) {
        livrosService.excluirLivro(id);
    }
}