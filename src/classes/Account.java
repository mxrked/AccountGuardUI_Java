package classes;

/**
 * This is the Account class which is used to create an instance of an account
 */

public class Account {
    private String type;
    private String email;
    private String password;

    public Account(String type, String email, String password) {
        this.type = type;
        this.email = email;
        this.password = password;
    }

    // Getters
    public String getType() {
        return type;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }

    // Setters
    public void setType(String type) {
        this.type = type;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
