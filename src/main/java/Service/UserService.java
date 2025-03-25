package Service;

import java.sql.SQLException;
import Repository.UserRepository;
import model.User;

public class UserService {

    private UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    public boolean validateUser(String email, String password) {
        try {
            User user = userRepository.findByEmail(email);
            return user != null && user.getPasswordHash().equals(password);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
