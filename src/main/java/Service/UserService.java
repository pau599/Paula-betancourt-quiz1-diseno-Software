package Service;

import java.sql.SQLException;

import DTO.UserDTO;
import Exception.InvalidUserDataException;
import Repository.UserRepository;
import util.UserValidator;

public class UserService {
	 private UserRepository userRepository;

	    @Autowired
	    private BCryptPasswordEncoder passwordEncoder;

	    public String login(String email, String password) {
	        Optional<User> user = userRepository.findByEmail(email);
	        if (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
	            return JwtUtil.generateToken(email);
	        }
	        return null;
	    }
}
