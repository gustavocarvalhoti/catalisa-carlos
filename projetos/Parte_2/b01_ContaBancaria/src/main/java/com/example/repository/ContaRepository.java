package com.example.repository;

import com.example.model.ContaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContaRepository extends JpaRepository<ContaModel, Long> {
    //com.example.repository = interface

    //Aqui caso queira consultar por número de conta
    @Query("select c from ContaModel c where c.numero_conta = :numero_conta")
    Optional<ContaModel> exibirContaPorNumeroConta(@Param("numero_conta") String numero_conta);

    }


