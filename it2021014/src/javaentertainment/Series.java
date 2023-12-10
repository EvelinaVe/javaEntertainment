package javaentertainment;

import java.util.ArrayList;

public class Series extends Production {
    // Fields
    private int numSeasons; // Number of seasons in the series
    private int[] numEpisodesPerSeason; // Array storing the number of episodes per season
    private int latestYearOfProduction; // Latest year of production of the series

    // Constructor
    public Series(String id, String title, int yearOfFirstRelease, String type, String countryOfProduction,
                  Director director, ArrayList<Actor> actors, int numSeasons, int[] numEpisodesPerSeason,
                  int latestYearOfProduction) {
        super(id, title, yearOfFirstRelease, type, countryOfProduction, director, actors);
        this.numSeasons = numSeasons;
        this.numEpisodesPerSeason = numEpisodesPerSeason;
        this.latestYearOfProduction = latestYearOfProduction;
    }

    // Method to set the number of episodes for a specific season
    public void setNumEpisodesForSeason(int seasonNum, int numEpisodes) {
        // Check if the season number is valid
        if (seasonNum >= 1 && seasonNum <= numSeasons) {
            // Update the number of episodes for the specified season
            numEpisodesPerSeason[seasonNum - 1] = numEpisodes;
            System.out.println("Number of episodes for season " + seasonNum + " updated successfully.");
        } else {
            System.out.println("Invalid season number.");
        }
    }
     
    // Method to set the latest year of release of the series
    public void setYearOfLatestRelease(int yearOfLatestRelease) {
        this.latestYearOfProduction = yearOfLatestRelease;
        System.out.println("Year of latest release updated successfully.");
    }
    
    // Getters and setters for the fields
    public int getNumSeasons() {
        return numSeasons;
    }

    public void setNumSeasons(int numSeasons) {
        this.numSeasons = numSeasons;
    }

    public int[] getNumEpisodesPerSeason() {
        return numEpisodesPerSeason;
    }

    public void setNumEpisodesPerSeason(int[] numEpisodesPerSeason) {
        this.numEpisodesPerSeason = numEpisodesPerSeason;
    }

    public int getLatestYearOfProduction() {
        return latestYearOfProduction;
    }

    public void setLatestYearOfProduction(int latestYearOfProduction) {
        this.latestYearOfProduction = latestYearOfProduction;
    }
}
