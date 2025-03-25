package Controller;

import java.sql.SQLException;
import Service.UserService;

public class UserController {
    private UserService userService;

    public UserController() {
        this.userService = new UserService();
    }

    public String login(String email, String password) throws SQLException {
        boolean isValid = userService.validateUser(email, password);
        return isValid ? "Inicio de sesión exitoso." : "Credenciales incorrectas.";
    }
}
