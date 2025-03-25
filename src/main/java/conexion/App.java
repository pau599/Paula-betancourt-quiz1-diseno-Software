package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3307/supermercado";
		String user = "root";
		String password = "Paulabetancourt";
		try (Connection connection = DriverManager.getConnection(url, user, password)) {
			if (connection != null) {
				System.out.println("Conexión exitosa!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
