package javaentertainment;


import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
    private final List<User> users;
    
    public UserDatabase() {
        users = new ArrayList<>();
    }
    
    public void addUser(User user) {
        users.add(user);
    }
    
    public User findUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }
        return null;
    }
    
    public User findUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }
        return null;
    }
   public User signInUser(String username, String password) {
    User user = findUserByUsername(username);
    if (user != null && user.getPassword().equals(password)) {
        return user; // User found, return the User object
    }
    return null; // User not found or password doesn't match, return null
}


    
     public User registerUser(String username, String email, String password) {
    // Check if the username or email already exists
    if (findUserByUsername(username) != null || findUserByEmail(email) != null) {
        return null; // Registration failed, username or email already exists
    }

    // Create a new User object
    User user = new User(username, email, password);

    // Add the user to the userDatabase ArrayList
    users.add(user);

    return user; // Registration successful
}


    public void displayUsers() {
    for (User user : users) {
        System.out.println("Username: " + user.getUsername());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Password: " + user.getPassword());
        System.out.println("------------------------");
    }
}


}
     
    


