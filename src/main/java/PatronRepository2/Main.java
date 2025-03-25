package PatronRepository2;

import java.sql.SQLException;

import DTO.UserDTO;
import Exception.InvalidUserDataException;
import Service.UserService;

public class Main {
	public static void main (String [] args) {
		UserService userService = new UserService();
		
		try {
			//crear nuevo usuario
			userService.createUser("John Doe", "john.doe@example.com");
			
			//obtener el usuario por ID
			UserDTO user = userService.getUserById(1);
			if (user != null) {
				System.out.println("User ID: " + user.getId());
				System.out.println("User Name: " + user.getName());
				System.out.println("User Email: " + user.getEmail());
			} else {
				System.out.println("User not found.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InvalidUserDataException e) {
			System.err.println(e.getMessage());
		}
	}
}
