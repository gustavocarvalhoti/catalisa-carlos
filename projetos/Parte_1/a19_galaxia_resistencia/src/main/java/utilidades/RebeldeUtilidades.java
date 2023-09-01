package utilidades;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class RebeldeUtilidades {
    private Connection connection;

    public RebeldeUtilidades(Connection connection) {
        this.connection = connection;
    }



    public double calcularPorcentagemTraidores(){
        var sql = "SELECT COUNT(*) FROM rebeldes";
        double totalRebeldes = contarRegistros(sql);

        sql = "SELECT COUNT(*) FROM traidores";
        double totalTraidores = contarRegistros(sql);

        if(totalRebeldes == 0){
            return 0.0;
        }

        return (totalTraidores / totalRebeldes) * 100;

    }

    public double calcularPorcentagemRebeldes(){
        var sql = "SELECT COUNT(*) FROM rebeldes";
        double totalRebeldes = contarRegistros(sql);

        sql = "SELECT COUNT(*) FROM traidores";
        double totalTraidores = contarRegistros(sql);

        if(totalRebeldes == 0){
            return 0.0;
        }

        return ((totalRebeldes - totalTraidores) / totalRebeldes) * 100;
    }

    private double contarRegistros(String sql){
        try (Statement statement = connection.createStatement()) {
            var rs = statement.executeQuery(sql);

            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0.0;
    }

}

