package javaentertainment;

import java.util.ArrayList;
import java.util.List;

public class Production {
    // Fields
    private String id; // Unique ID of the production
    private String title; // Title of the production
    private int yearOfFirstRelease; // Year of the first release of the production
    private String type; // Type of the production (movie, series, etc.)
    private String countryOfProduction; // Country where the production was made
    private Director director; // Director of the production
    private ArrayList<Actor> actors; // List of actors in the production
    private double averageRating; // Average rating given by users
    private final ArrayList<UserRating> ratings; // List of user ratings and comments
    private final List<String> usernames; // List of usernames who rated the production
    private final List<Integer> userRatings; // List of ratings given by users

    // Constructor
    public Production(String id, String title, int yearOfFirstRelease, String type, String countryOfProduction,
                      Director director, ArrayList<Actor> actors) {
        this.id = id;
        this.title = title;
        this.yearOfFirstRelease = yearOfFirstRelease;
        this.type = type;
        this.countryOfProduction = countryOfProduction;
        this.director = director;
        this.actors = actors;
        this.ratings = new ArrayList<>(); // Initialize the list to store user ratings and comments
        this.usernames = new ArrayList<>(); // Initialize the list to store usernames who rated the production
        this.userRatings = new ArrayList<>(); // Initialize the list to store ratings given by users
    }

    // Getters and setters for the fields

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearOfFirstRelease() {
        return yearOfFirstRelease;
    }

    public void setYearOfFirstRelease(int yearOfFirstRelease) {
        this.yearOfFirstRelease = yearOfFirstRelease;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountryOfProduction() {
        return countryOfProduction;
    }

    public void setCountryOfProduction(String countryOfProduction) {
        this.countryOfProduction = countryOfProduction;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }

    public double getRating() {
        return averageRating;
    }

    public void setRating(double rating) {
        this.averageRating = rating;
    }

    // Method to add a new user rating for the production
    public void addRating(String username, double rating) {
        UserRating userRating = new UserRating(username, (int) rating);
        ratings.add(userRating); // Add the new rating and comment to the list
        usernames.add(username); // Add the username to the list of usernames who rated the production
        userRatings.add((int) rating); // Add the rating to the list of ratings given by users
    }

    // Method to calculate the average rating of the production
    double calculateAverageRating() {
        if (ratings.isEmpty()) {
            return 0.0; // If there are no ratings, return 0.0
        }

        double sum = 0.0;

        for (UserRating userRating : ratings) {
            sum += userRating.getRating();
        }

        return sum / ratings.size(); // Calculate and return the average rating
    }

    public List<String> getUsernames() {
        return usernames;
    }

    public List<Integer> getUserRatings() {
        return userRatings;
    }
}

