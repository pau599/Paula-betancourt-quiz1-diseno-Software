package Controller;

import java.util.Map;

import Service.UserService;

public class UserController {
	private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
        String token = userService.login(request.get("email"), request.get("password"));
        if (token != null) {
            return ResponseEntity.ok(Map.of("token", token));
        } else {
            return ResponseEntity.status(401).body("Credenciales incorrectas.");
        }
    }
}
