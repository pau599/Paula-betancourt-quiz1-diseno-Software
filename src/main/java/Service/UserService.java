package Service;

import java.sql.SQLException;

import DTO.UserDTO;
import Exception.InvalidUserDataException;
import Repository.UserRepository;
import util.UserValidator;

public class UserService {
	private UserRepository userRepository = new UserRepository();
	
	public UserDTO getUserById(int id) throws SQLException{
		return userRepository.findById(id);
	}
	
	public void createUser(String name, String email) throws SQLException, InvalidUserDataException{
		if (!UserValidator.validateName(name) || !UserValidator.validateEmail (email)) {
			throw new InvalidUserDataException ("Invalid user data");
		}
		UserDTO user = new UserDTO (0, name, email);
		userRepository.save(user);
	}
}
