package com.biblioteca.bibliotecaSpring.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tabela_livros")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LivrosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    private String nome_livro;

    @Column(length = 255, nullable = false)
    private String autor_livro;

    @Column(length = 10, nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date data_lancamento;

    @Column(length = 50, nullable = false)
    private String codigo_livro;
}