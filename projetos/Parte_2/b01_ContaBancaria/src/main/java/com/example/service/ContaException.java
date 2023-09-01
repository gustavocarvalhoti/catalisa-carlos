package com.example.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//Método de tratamento de exceções usando um Exception Handler

//Curiosidades:
//Aqui lida com o tratamento de exceções será usada automaticamente pelo Spring Framework para capturar e
// lidar com exceções em toda a aplicação. Ela foi anotada com @ControllerAdvice,
// o que a torna um "Advice" global para a aplicação, permitindo que ela intercepte exceções lançadas
// de qualquer controlador.
@ControllerAdvice
public class ContaException {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Ocorreu um erro na sua Requisição. " + e.getMessage());

    }

}
