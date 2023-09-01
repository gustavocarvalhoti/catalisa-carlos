package com.biblioteca.bibliotecaSpring.service;

import com.biblioteca.bibliotecaSpring.model.LivrosModel;
import com.biblioteca.bibliotecaSpring.repository.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivrosService {

    @Autowired
    LivrosRepository livrosRepository;

    //Método que busca todos os livros no banco de dados
    public List<LivrosModel> exibirTodosLivros() {
        return livrosRepository.findAll();
    }

    //Método que busca um livro pelo id
    public Optional<LivrosModel> exibirLivroPorId(Long id) {
        return livrosRepository.findById(id);
    }

    //Método para cadastrar um livro no banco de dados
    public LivrosModel cadastrarLivro(LivrosModel livrosModel) {
        return livrosRepository.save(livrosModel);
    }

    //Método para alterar um livro no banco de dados
    public LivrosModel alterarLivro(Long id, LivrosModel livrosModel) {
        LivrosModel livro = livrosRepository.findById(id).get();
        if (livro != null) {
            livro.setNome_livro(livrosModel.getNome_livro());
            livro.setAutor_livro(livrosModel.getAutor_livro());
            livro.setData_lancamento(livrosModel.getData_lancamento());
            livro.setCodigo_livro(livrosModel.getCodigo_livro());

        }
        return livrosRepository.save(livrosModel);
    }

    //Método para excluir um livro do banco de dados
    //Não retorna nenhuma resposta, então é void
    public void excluirLivro(Long id) {
        livrosRepository.deleteById(id);
    }


//    //metodo para cadastrar vários livros
//    public List<LivrosModel> cadastrarLivros(List<LivrosModel> livrosModel) {
//        return livrosRepository.saveAll(livrosModel);
//    }
}
