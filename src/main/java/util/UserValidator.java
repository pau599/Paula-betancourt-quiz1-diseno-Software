package util;

public class UserValidator {
	public static boolean validateName(String name) {
		return name != null && !name.trim().isEmpty();
	}
	
	public static boolean validateEmail(String email) {
		return email != null && email.contains("@");
	}
}
