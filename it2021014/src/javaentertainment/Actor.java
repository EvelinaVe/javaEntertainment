package javaentertainment;

import java.util.ArrayList;
import java.util.Date;

public class Actor {
    // Fields
    private String name; // Name of the actor
    private Date dateOfBirth; // Date of birth of the actor
    private String countryOfBirth; // Country of birth of the actor
    private String website; // Website of the actor
    private ArrayList<Production> productions; // List of productions the actor has been a part of
    private String actorID; // ID of the actor

    // Constructor
    public Actor(String actorID, String name, Date dateOfBirth, String countryOfBirth, String website) {
        this.name = name;
        this.actorID = actorID;
        this.dateOfBirth = dateOfBirth;
        this.countryOfBirth = countryOfBirth;
        this.website = website;
        this.productions = new ArrayList<>(); // Initialize the list to store productions the actor has been a part of
    }

    // Getters and setters for the fields

    public String getActorID() {
        return actorID;
    }

    public void setActorID(String actorID) {
        this.actorID = actorID;
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

    // Method to add a production to the actor's list of productions
    public void addProduction(Production production) {
        if (!productions.contains(production)) {
            productions.add(production); // Add the production to the actor's list
            production.getActors().add(this); // Add the actor to the production's list of actors
        }
    }

    // Method to remove a production from the actor's list of productions
    public void removeProduction(Production production) {
        if (productions.contains(production)) {
            productions.remove(production); // Remove the production from the actor's list
            production.getActors().remove(this); // Remove the actor from the production's list of actors
        }
    }

    // Method to get the production with the highest average rating for the actor
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

    // Method to get the production with the lowest average rating for the actor
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

