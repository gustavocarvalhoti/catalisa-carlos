package org.example.conexaoBD;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

//Conexão com o banco de dados PostgreSQL
public class ConexaoBD {

//   (NÃO DELETAR private static String url = "jdbc:postgresql://localhost:5432/estacionamento";
    private static String url = "jdbc:postgresql://database-1.ct2jygfmnue8.sa-east-1.rds.amazonaws.com:5432/parkzup";
    private static String user = "postgres";
    private static String password = "catalisa";


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);


    }
}





