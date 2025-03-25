package Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Config.DatabaseConfig;
import DTO.UserDTO;
//import modelado.DatabaseConfig;

public class UserRepository {
	public UserDTO findById(int id) throws SQLException{
		String query = "SELECT * FROM users WHERE id =" + id;
		try (Connection connection = DatabaseConfig.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query)) {
			if (resultSet.next()) {
				return new UserDTO(
				resultSet.getInt("id"),
				resultSet.getString("name"),
				resultSet.getString("email")
				);
			} else {
				return null;
			}
		}
	}
	
	public void save (UserDTO user) throws SQLException{
		String query = "INSERT INTO users (name, email) VALUES ('" + user.getName() + "', '" + user.getEmail() + "')";
		try (Connection connection = DatabaseConfig.getConnection();
				Statement statement = connection.createStatement()){
			statement.executeUpdate(query);
		}
	}
}
