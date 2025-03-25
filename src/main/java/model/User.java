package model;

public class User {
	
	    private int id;
	    private String username;
	    private String email;
	    private String PasswordHash;

	    // Constructor vacío
	    public User() {
	    }

	    // Constructor con parámetros
	    public User(int id, String username, String email, String PasswordHash) {
	        this.id = id;
	        this.username = username;
	        this.email = email;
	        this.PasswordHash = PasswordHash;
	    }

	    // Getters y Setters
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPasswordHash() {
			return PasswordHash;
		}

		public void setPasswordHash(String passwordHash) {
			this.PasswordHash = passwordHash;
		}
	    
	    
}
