package javaentertainment;

import java.util.ArrayList;
import java.util.Date;


public class Director {
    // Fields
    private String directorID; // ID of the director
    private String name; // Name of the director
    private Date dateOfBirth; // Date of birth of the director
    private String countryOfBirth; // Country of birth of the director
    private String website; // Website of the director
    private ArrayList<Production> productions; // List of productions directed by the director

    // Constructor
    public Director(String directorID, String name, Date dateOfBirth, String countryOfBirth, String website) {
        this.directorID = directorID;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.countryOfBirth = countryOfBirth;
        this.website = website;
        this.productions = new ArrayList<>(); // Initialize the list to store productions directed by the director
    }

    // Getters and setters for the fields

    public String getDirectorId() {
        return directorID;
    }

    public void setDirectorId(String directorId) {
        this.directorID = directorId;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    public void setCountryOfBirth(String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public ArrayList<Production> getProductions() {
        return productions;
    }

    public void setProductions(ArrayList<Production> productions) {
        this.productions = productions;
    }

    // Method to add a production to the director's list of productions
    public void addProduction(Production production) {
        if (production.getDirector() == null) {
            productions.add(production); // Add the production to the director's list
            production.setDirector(this); // Set the director of the production to the current director
        }
    }

    // Method to remove a production from the director's list of productions
    public void removeProduction(Production production) {
        if (productions.contains(production)) {
            productions.remove(production); // Remove the production from the director's list
            production.setDirector(null); // Remove the director association from the production
        }
    }

    // Method to get the production with the highest average rating directed by the director
    public Production getHighestRatedProduction() {
        Production highestRatedProduction = null;
        double highestRating = Double.MIN_VALUE;

        for (Production production : productions) {
            double averageRating = production.getRating();
            if (averageRating > highestRating) {
                highestRating = averageRating;
                highestRatedProduction = production;
            }
        }

        return highestRatedProduction;
    }

    // Method to get the production with the lowest average rating directed by the director
    public Production getLowestRatedProduction() {
        Production lowestRatedProduction = null;
        double lowestRating = Double.MAX_VALUE;

        for (Production production : productions) {
            double averageRating = production.getRating();
            if (averageRating < lowestRating) {
                lowestRating = averageRating;
                lowestRatedProduction = production;
            }
        }

        return lowestRatedProduction;
    }
}