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
        String query = "SELECT id, marca, modelo, cilindraje, color, precio FROM motocicletas"; 


        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Motocicleta moto = new Motocicleta(
                	    rs.getInt("id"),
                	    rs.getString("marca"),
                	    rs.getString("modelo"),
                	    rs.getInt("cilindraje"), 
                	    rs.getString("color"),
                	    rs.getDouble("precio")
                	);

                motocicletas.add(moto);
            }
        }
        return motocicletas;
    }

    public void guardar(Motocicleta moto) throws SQLException {
        String query = "INSERT INTO motocicletas (marca, modelo, cilindraje, color, precio) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) { 

            if (moto == null) {
                throw new SQLException("El objeto moto es nulo.");
            }

            stmt.setString(1, moto.getMarca());
            stmt.setString(2, moto.getModelo());
            stmt.setLong(3, moto.getCilindraje()); // 🔥 Corregido: Se usa getCilindraje()
            stmt.setString(4, moto.getColor());
            stmt.setDouble(5, moto.getPrecio());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
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