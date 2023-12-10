package javaentertainment;

import java.util.ArrayList;
import java.util.List;

public class User {
    // Fields
    private final String username; // User's username
    private final String email; // User's email
    private final String password; // User's password
    private final ArrayList<UserRating> userRatings; // User's personal ratings
    private final List<Actor> favoriteActors; // User's favorite actors
    private final List<Director> favoriteDirectors; // User's favorite directors

    // Constructor
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.userRatings = new ArrayList<>();
        this.favoriteActors = new ArrayList<>();
        this.favoriteDirectors = new ArrayList<>();
    }

    // Getters for the fields
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<UserRating> getPersonalRatings() {
        return userRatings;
    }

    // Method to add a personal rating
    public void addPersonalRating(UserRating rating) {
        userRatings.add(rating);
    }

    // Method to display the user's personal ratings
    public void displayPersonalRatings() {
        System.out.println("Personal ratings by " + username + ":");
        for (UserRating rating : userRatings) {
            System.out.println("Production ID: " + rating.getProductionId() + ", Personal Rating: " + rating.getRating());
        }
    }

    // Getters for favorite actors and directors
    public List<Actor> getFavoriteActors() {
        return favoriteActors;
    }

    public List<Director> getFavoriteDirectors() {
        return favoriteDirectors;
    }

    // Methods to add favorite actors and directors
    public void addFavoriteActor(Actor actor) {
        favoriteActors.add(actor);
    }

    public void addFavoriteDirector(Director director) {
        favoriteDirectors.add(director);
    }

    // Method to display favorite actors
    public void displayFavoriteActors() {
        System.out.println("Favorite actors for " + username + ":");
        for (Actor actor : favoriteActors) {
            System.out.println("Actor Name: " + actor.getName());
        }
    }

    // Method to display favorite directors
    public void displayFavoriteDirectors() {
        System.out.println("Favorite directors for " + username + ":");
        for (Director director : favoriteDirectors) {
            System.out.println("Director Name: " + director.getName());
        }
    }
}
