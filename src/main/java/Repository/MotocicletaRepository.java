package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Config.DatabaseConfig;
import model.Motocicleta;

public class MotocicletaRepository {
    public List<Motocicleta> obtenerTodas() throws SQLException {
        List<Motocicleta> motocicletas = new ArrayList<>();
        String query = "SELECT * FROM motocicletas";

        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Motocicleta moto = new Motocicleta(
                    rs.getInt("id"),
                    rs.getString("marca"),
                    rs.getString("modelo"),
                    rs.getInt("anio"),
                    rs.getDouble("precio")
                );
                motocicletas.add(moto);
            }
        }
        return motocicletas;
    }

    public void guardar(Motocicleta moto) throws SQLException {
        String query = "INSERT INTO motocicletas (marca, modelo, anio, precio) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, moto.getMarca());
            stmt.setString(2, moto.getModelo());
            stmt.setInt(3, moto.getAnio());
            stmt.setDouble(4, moto.getPrecio());
            stmt.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException {
        String query = "DELETE FROM motocicletas WHERE id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
