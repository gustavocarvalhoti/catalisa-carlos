package utilidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ItemUtilidades {
    private Connection connection;
    private Map<String, Integer> precosItens;

    public ItemUtilidades(Connection connection) {
        this.connection = connection;
        inicializarPrecosItens();
    }

    private void inicializarPrecosItens() {
        precosItens = new HashMap<>();
        precosItens.put("Arma", 100);
        precosItens.put("Munição", 30);
        precosItens.put("Água", 5);
        precosItens.put("Comida", 15);

    }

    public void comprarItem(int rebeldeId, String item, int quantidade) {
        var preco = precosItens.getOrDefault(item, 0);
        var total = preco * quantidade;

        if (!rebeldeTemRecursos(rebeldeId, total)) {
            System.out.println("Rebelde sem recursos suficientes para comprar.");
            return;

        }
        adicionarItemInventario(rebeldeId, item, quantidade);
        deduzirRecursosRebelde(rebeldeId, total);

        System.out.println("Compra efetuada com sucesso.");

    }

    private boolean rebeldeTemRecursos(int rebeldeId, int total) {

        var sql = "SELECT recursos FROM rebeldes WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, rebeldeId);
            var rs = statement.executeQuery();


            if (rs.next()) {
                int recursos = rs.getInt("recursos");
                return recursos >= total;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    private void adicionarItemInventario(int rebeldeId, String item, int quantidade) {
        var sql = "UPDATE rebeldes SET inventario = jsonb_set(inventario, '{" + item + "}', " +
                "COALESCE(inventario->>'" + item + "', '0')::int + ?::int, true) WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, quantidade);
            statement.setInt(2, rebeldeId);

            statement.executeUpdate();
        }catch  (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deduzirRecursosRebelde(int rebeldeId, int total){
        var sql = "UPDATE rebeldes SET recursos = recursos - ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, total);
            statement.setInt(2, rebeldeId);
            statement.executeUpdate();
        }catch  (SQLException e) {
            e.printStackTrace();
        }

    }

}


