package javaentertainment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;





public class It2021014 {
    // define data structures
    private static final ArrayList<Production> productions = new ArrayList<>();
    private static final ArrayList<Director> directors = new ArrayList<>();
    private static final ArrayList<Actor> actors = new ArrayList<>();
    private static int actorCount = 0;
    private static int directorCount = 0;
    private static int nextDirectorId = 1;
    private static int nextActorId = 1;
    private static int lastSeriesId = 0;
private static int lastMovieId = 0;
    
   public static void main(String[] args) throws ParseException {
    Scanner input = new Scanner(System.in);
     UserDatabase userDatabase = new UserDatabase();
     
    boolean quit = false;
    
   /* Director director1 = new Director("D1", "Director 1", new Date(), "Country 1", "Website 1");
Director director2 = new Director("D2", "Director 2", new Date(), "Country 2", "Website 2");
Actor actor1 = new Actor("A1", "Actor 1", new Date(), "Country 1", "Website 1");
Actor actor2 = new Actor("A2", "Actor 2", new Date(), "Country 2", "Website 2");
Actor actor3 = new Actor("A3", "Actor 3", new Date(), "Country 3", "Website 3");
Production production1 = new Production("P1", "Production 1", 2022, "Type 1", "Country 1", director1, new ArrayList<>());
Production production2 = new Production("P2", "Production 2", 2023, "Type 2", "Country 2", director2, new ArrayList<>());

// Add actors and director to the productions
production1.getActors().add(actor1);
production1.getActors().add(actor2);
production2.getActors().add(actor2);
production2.getActors().add(actor3);
director1.getProductions().add(production1);
director2.getProductions().add(production2);*/


    
    while (!quit) {
   

        // display menu of options
        System.out.println("WELCOME TO JAVA ENTERNTAINMENT");
        System.out.println("------------------------------- ");
        System.out.println("What would you like to do?");
        System.out.println("1. Enter a production");
        System.out.println("2. Update series");
        System.out.println("3. Search for information and evaluate a production");
        System.out.println("4. Search for information and favorite actor/director");
        System.out.println("5. Exit");
        System.out.print("Option: ");

        try {
            int choice = input.nextInt();
            input.nextLine(); 
            OUTER: {
                switch (choice) {
                    
                    // ENTER PRODUCTION
                    
                    case 1 -> {
                      
                        //ASK THE USER INFORMATION ABOUT THE PRODUCTION
                System.out.println("Enter the title:");
                String title = input.nextLine();
                Production existingProduction = findProduction(title);
                if (existingProduction != null) {
                    System.out.println("A production with the same name already exists. Please enter a different name.");
                    break;
                }
                System.out.println("Enter the year of first release:");
                int year = 0;
                while (true) {
                    try {
                        year = input.nextInt();
                        if (year < 1895 || year > 2200) {
                            throw new Exception();
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println("Error! Please enter a valid year:");
                        input.nextLine(); 
                    }
                }
                input.nextLine();

                // check for invalid input
                System.out.println("Enter the type (separate multiple types with commas):");
                String type = input.nextLine().trim();
                

                System.out.println("Enter the country of production:");
                String country = input.nextLine();



                // ASK THE USER DIRECTOR INFORMATION
               System.out.println("Enter the director's name:");
String directorName = input.nextLine();
Director director = findDirector(directorName);

if (director == null) {
    System.out.println("Enter the director's date of birth (yyyy-mm-dd):");
    String directorDobString = input.nextLine();

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    formatter.setLenient(false);

    Date directorDob = null;
    boolean validDate = false;

    while (!validDate) {
        try {
            directorDob = formatter.parse(directorDobString);
            Calendar cal = Calendar.getInstance();
            cal.setTime(directorDob);
            int directorYear = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH) + 1; // Calendar.MONTH starts from 0
            int day = cal.get(Calendar.DAY_OF_MONTH);

            if (directorYear < 1000 || directorYear > 2023 || month < 1 || month > 12 || day < 1 || day > 31) {
                System.out.println("Invalid date format. Please enter a valid date in yyyy-mm-dd format:");
                directorDobString = input.nextLine();
            } else {
                validDate = true;
            }
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter a valid date in yyyy-mm-dd format:");
            directorDobString = input.nextLine();
        }
    }

    System.out.println("Enter the director's country of birth:");
    String directorCountryOfBirth = input.nextLine();
    System.out.println("Enter the director's website (or press enter if not applicable):");
    String directorWebsite = input.nextLine();
    String directorID = generatedirectorID();
    director = new Director(directorID, directorName, directorDob, directorCountryOfBirth, directorWebsite);
    directors.add(director); // Add the director to the directors list
} else {
                    System.out.println("Information about this Director already exist.");
                    break;
                            
                }



                // ASK THE USERACTOR INFORMATION
                ArrayList<Actor> actorsInProduction = new ArrayList<>();
boolean addAnotherActor = true;
while (addAnotherActor && actorsInProduction.size() < 10) {
    System.out.println("Enter an actor's name (or enter 'done' to stop adding actors):");
    String actorName = input.nextLine();
    if (actorName.equals("done")) {
        addAnotherActor = false;
    } else {
        Actor actor = findActor(actorName);
        if (actor == null) {
            boolean validDate = false;
            Date actorDob = null;
            while (!validDate) {
                System.out.println("Enter the actor's date of birth (yyyy-mm-dd):");
                String actorDobString = input.nextLine();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    actorDob = formatter.parse(actorDobString);
                    String[] parts = actorDobString.split("-");
                    if (parts.length == 3) {
                        int actorYear = Integer.parseInt(parts[0]);
                        int month = Integer.parseInt(parts[1]);
                        int day = Integer.parseInt(parts[2]);
                        if (actorYear >= 1000 && actorYear <= 2023 && month >= 1 && month <= 12 && day >= 1 && day <= 31) {
                            validDate = true;
                        } else {
                            System.out.println("Invalid date format. Please enter a valid date in yyyy-mm-dd format.");
                        }
                    } else {
                        System.out.println("Invalid date format. Please enter a valid date in yyyy-mm-dd format.");
                    }
                } catch (ParseException e) {
                    System.out.println("Invalid date format. Please enter a valid date in yyyy-mm-dd format.");
                }
            }
            System.out.println("Enter the actor's country of birth:");
            String actorCountryOfBirth = input.nextLine();
            System.out.println("Enter the actor's website (or press enter if not applicable):");
            String actorWebsite = input.nextLine();
            String actorID = generateActorID();
            actor = new Actor(actorID, actorName, actorDob, actorCountryOfBirth, actorWebsite);
            actors.add(actor); // Add the actor to the actors list
        }
                        actorsInProduction.add(actor);
                    }
                }


                // ASK THE USER SERIES INFORMATION
                System.out.println("Is this a series? (y/n):");
                String isSeriesString = input.nextLine();
                boolean isSeries = isSeriesString.equalsIgnoreCase("y");
                String id;
                if (isSeries) {
                    System.out.println("Enter the number of seasons:");
                    int numSeasons = input.nextInt();
                    input.nextLine(); // consume the newline character
                    int[] numEpisodesPerSeason = new int[numSeasons];
                    for (int i = 0; i < numSeasons; i++) {
                        System.out.println("Enter the number of episodes for season " + (i + 1) + ":");
                        numEpisodesPerSeason[i] = input.nextInt();
                        input.nextLine(); // consume the newline character
                    }

                    System.out.println("Enter the year of the latest release (or enter 0 if it's still ongoing):");
                    int latestYearOfProduction = input.nextInt();
                    input.nextLine(); // consume the newline character
                    id = generateUniqueId(true);
                    productions.add(new Series(id, title, year, type, country, director, actors, numSeasons, numEpisodesPerSeason, latestYearOfProduction ));
                } else {
                    id = generateUniqueId(false);
                    productions.add(new Production(id, title, year, type, country, director, actors));
                }


                // PRINT OUT THE NEW ADDED PRODUCTION DETAILS
                System.out.println("Production added successfully! Production details:");
                for (Production production : productions) {
                    System.out.println("Unique identification code: " + id);
                    System.out.println("Title: " + production.getTitle());
                    System.out.println("Type: " + (production instanceof Series ? "Series" : "Movie"));
                    System.out.println("Genre: " + production.getType());
                    System.out.println("Director: " + production.getDirector().getName());
                    System.out.println("-----------------------");
                }
         break;   } 
                    

    
                  
                   //UPDATE SERIES
                    case 2 -> {
                       
                        //ask the user to choose how they want to search the series.
                        System.out.println("Select how to search for the series:");
                        System.out.println("1. By title");
                        System.out.println("2. By ID");
                        System.out.print("Enter your choice: ");
                        int searchChoice = Integer.parseInt(input.nextLine());
                        Production productionToUpdate = null;
                        switch (searchChoice) {
                    case 1 -> {
        // Search by title
        System.out.print("Enter the production title: ");
        String productionTitle = input.nextLine();
        for (Production production : productions) {
            if (production instanceof Series && production.getTitle().equalsIgnoreCase(productionTitle)) {
                productionToUpdate = production;
                break;
            }
        }
    }
    case 2 -> {
        // Search by ID
        System.out.print("Enter the production ID: ");
        String productionID = input.nextLine();
        for (Production production : productions) {
            if (production instanceof Series && production.getId().equalsIgnoreCase(productionID)) {
                productionToUpdate = production;
                break;
            }
        }
    }
    default -> {
        System.out.println("Invalid option.");
        break; 
    }
}
// If the production was not found or is a movie, display an error message
if (productionToUpdate == null) {
    System.out.println("Series not found.");
    break;
}

                        // DISPLAY THIS MENU AFTER THE USER ENTERS SERIES
                        System.out.println("Select what to update:");
                        System.out.println("1. Number of seasons");
                        System.out.println("2. Number of episodes for a season");
                        System.out.println("3. Year of latest release");
                        System.out.print("Enter your choice: ");
                        int updateChoice = Integer.parseInt(input.nextLine());
                         switch (updateChoice) {
                            
                            
                            case 1 -> {
                                // Update number of seasons
                                System.out.print("Enter the new number of seasons: ");
                                int numSeasons = Integer.parseInt(input.nextLine());
                                if (productionToUpdate instanceof Series series) {
                                    series.setNumSeasons(numSeasons);
                                    System.out.println("Number of seasons updated successfully.");
                                }
                    }
                                
                            case 2 -> {
                                // Update number of episodes for a season
                                if (productionToUpdate instanceof Series series) {
                                    System.out.print("Enter the season number to update (starting from 1): ");
                                    int seasonNum = Integer.parseInt(input.nextLine());
                                    System.out.print("Enter the new number of episodes for season " + seasonNum + ": ");
                                    int numEpisodes = Integer.parseInt(input.nextLine());
                                    series.setNumEpisodesForSeason(seasonNum, numEpisodes);
                                    System.out.println("Number of episodes for season " + seasonNum + " updated successfully.");
                                } else {
                                    System.out.println("Cannot update number of episodes for a movie.");
                                }
                    }
                                
                          
                            
                            case 3 -> {
                        // Update year of latest release
                        if (productionToUpdate instanceof Series series) {
                            System.out.print("Enter the new year of latest release: ");
                            int yearOfLatestRelease = Integer.parseInt(input.nextLine());
                            series.setYearOfLatestRelease(yearOfLatestRelease);
                            System.out.println("Year of latest release updated successfully.");
                        } else {
                            System.out.println("Cannot update year of latest release for a movie.");
                        }
                            }
                         }
                        break;
                    }
                    
                    
                    
                    
                    
                    
                    // SEARCH INFORMATION AND EVALUATE A PRODUCTION
                    case 3 -> {
                        
                        //ask how they want to search
 System.out.println("Search for a show:");
System.out.println("1. By ID");
System.out.println("2. By Title");
System.out.print("Enter your choice: ");
int searchChoice = Integer.parseInt(input.nextLine());

ArrayList<Production> searchResults = new ArrayList<>();

switch (searchChoice) {
    case 1 -> {
        // Search by ID
        System.out.print("Enter the production ID: ");
        String productionID = input.nextLine();
        for (Production production : productions) {
            if (production.getId().equalsIgnoreCase(productionID)) {
                searchResults.add(production);
            }
        }
    }
    case 2 -> {
        // Search by title
        System.out.print("Enter the production title: ");
        String productionTitle = input.nextLine();
        for (Production production : productions) {
            if (production.getTitle().equalsIgnoreCase(productionTitle)) {
                searchResults.add(production);
            }
        }
    }
    default -> {
        System.out.println("Invalid option.");
        break;
    }
}
// handle case where there is no mathcing tittle
if (searchResults.isEmpty()) {
    System.out.println("No matching productions found.");
} else {
    
    // print production information
    for (Production production : searchResults) {
        System.out.println("Unique identification code: " + production.getId());
        System.out.println("Title: " + production.getTitle());
        System.out.println("Year of First Release: " + production.getYearOfFirstRelease());
        System.out.println("Type: " + (production instanceof Series ? "Series" : "Movie"));
        System.out.println("Director: " + production.getDirector().getName());
         
        // code in case of series
        if (production instanceof Series series) {
            int numSeasons = series.getNumSeasons();
            int latestYearOfProduction = series.getLatestYearOfProduction();
            System.out.println("Number of Seasons: " + numSeasons);
            if (latestYearOfProduction > 0) {
                System.out.println("Year of Latest Release: " + latestYearOfProduction);
            } else {
                System.out.println("Status: Still Airing");
            }
        }

        // Average user rating
        double averageRating = production.calculateAverageRating();
        System.out.println("Average User Rating: " + averageRating);

        // Optional rating by the user
        System.out.println("Do you want to rate this show? (y/n): ");
    
        String rateOption = input.nextLine();
         
        // ask the user if they have an account or not
        if (rateOption.equalsIgnoreCase("y")) {
            System.out.println("Do you want to sign in or register?");
            System.out.println("1. Sign in");
            System.out.println("2. Register");
            System.out.print("Enter your choice: ");
            int signInOrRegisterChoice = Integer.parseInt(input.nextLine());

            switch (signInOrRegisterChoice) {
               
                case 1 -> {
                    // SIGN IN
                    System.out.print("Enter your username: ");
                    String username = input.nextLine();
                    System.out.print("Enter your password: ");
                    String password = input.nextLine();
                    
                    // Sign in the user
                    User user = userDatabase.signInUser(username, password);
                    if (user == null) {
                        System.out.println("Invalid username or password. Rating not added.");
                    } else {
                        System.out.println("Hello " + user.getUsername() + "! You are now able to rate.");
                        System.out.print("Enter your rating (1-10): ");
                        int rating = Integer.parseInt(input.nextLine());

                        // Add the rating
                        production.addRating(user.getUsername(), rating);
                        System.out.println("Rating added successfully!");

                        // Calculate the new average rating
                        double newAverageRating = production.calculateAverageRating();
                        production.setRating(newAverageRating);
                    }
                }
                case 2 -> {
                    // REGISTER
                    System.out.print("Enter your username: ");
                    String username = input.nextLine();
                    System.out.print("Enter your email: ");
                    String email = input.nextLine();
                    System.out.print("Enter your password: ");
                    String password = input.nextLine();
                   
                    // Register the user
                    User user = userDatabase.registerUser(username, email, password);
                    if (user == null) {
                        System.out.println("Username or email already exists. Registration failed.");
                    } else {
                        System.out.println("Hello " + user.getUsername() + "! You are now able to rate.");
                        System.out.print("Enter your rating (1-10): ");
                        int rating = Integer.parseInt(input.nextLine());

                        // Add the rating
                        production.addRating(user.getUsername(), rating);
                        System.out.println("Rating added successfully!");

                        // Calculate the new average rating
                        double newAverageRating = production.calculateAverageRating();
                        production.setRating(newAverageRating);
                    }
                }
                default -> System.out.println("Invalid choice. Rating not added.");
            }
        }
        
        // ask if they want to view all the ratings for the production
        System.out.println("Do you want to view all the ratings for this movie/series?");
        String viewRatingsOption = input.nextLine();

if (viewRatingsOption.equalsIgnoreCase("y")) {
    // Call a method to display all users' ratings for the production
     userDatabase.displayUsers();
    displayUsersRatings(production);
} else {
    System.out.println("Returning to the main menu...");
}
        System.out.println("---------------------------------");
    }
}
break;

}

    




                       
                  //INFORMATION SEARCH AND FAVORITE ACTOR/DIRECTOR.  
                   case 4 -> {

    // Ask the user to select an option
    System.out.println("Select an option:");
    System.out.println("1. Search for an actor or director");
    System.out.println("2. Select favorite actor or director");
    System.out.println("3. View all favorite actors and directors");
    System.out.print("Enter your choice: ");
    int optionChoice = Integer.parseInt(input.nextLine());

    
    switch (optionChoice) {
        // search for actor or director option
        // ask director or actor
        case 1 -> {
            System.out.println("Search for an actor or a director:");
            System.out.println("1. Actor");
            System.out.println("2. Director");
            System.out.print("Enter your choice: ");
            int searchChoice = Integer.parseInt(input.nextLine());

            switch (searchChoice) {
                
                case 1 -> {
                    
    // Search for an actor
    System.out.print("Enter the actor's name: ");
    String actorName = input.nextLine();

    // Perform actor search and display results
    ArrayList<Actor> matchingActors = new ArrayList<>();
    for (Actor actor : actors) {
        if (actor.getName().equalsIgnoreCase(actorName)) {
            matchingActors.add(actor);
        }
    }

    if (matchingActors.isEmpty()) {
        System.out.println("No matching actors found.");
    } else {
        System.out.println("Matching Actors:");
        for (Actor actor : matchingActors) {
            System.out.println("Name: " + actor.getName());
            System.out.println("Actor ID: " + actor.getActorID());
            System.out.println("Productions Participated:");
            for (Production production : actor.getProductions()) {
                System.out.println("- " + production.getTitle());
            }
            System.out.println("--------------------");

            // Check if the user wants to see the highest rated and lowest rated productions
            System.out.print("Do you want to see the actor's highest rated and lowest rated productions? (y/n): ");
            String productionOption = input.nextLine();
            if (productionOption.equalsIgnoreCase("y")) {
                Production highestRatedProduction = actor.getHighestRatedProduction();
                Production lowestRatedProduction = actor.getLowestRatedProduction();

                if (highestRatedProduction != null) {
                    System.out.println("Highest Rated Production:");
                    System.out.println("Title: " + highestRatedProduction.getTitle());
                    System.out.println("Average Rating: " + highestRatedProduction.getRating());
                    System.out.println("--------------------");
                } else {
                    System.out.println("No highest rated production found for actor: " + actor.getName());
                    System.out.println("--------------------");
                }

                if (lowestRatedProduction != null) {
                    System.out.println("Lowest Rated Production:");
                    System.out.println("Title: " + lowestRatedProduction.getTitle());
                    System.out.println("Average Rating: " + lowestRatedProduction.getRating());
                    System.out.println("--------------------");
                } else {
                    System.out.println("No lowest rated production found for actor: " + actor.getName());
                    System.out.println("--------------------");
                }
            }
        }
    }
}
                
                
                
                case 2 -> {
                    // Search for a director
                    System.out.print("Enter the director's name: ");
                    String directorName = input.nextLine();
                    
                    // Perform director search and display results
                    ArrayList<Director> matchingDirectors = new ArrayList<>();
                    for (Director director : directors) {
                        if (director.getName().equalsIgnoreCase(directorName)) {
                            matchingDirectors.add(director);
                        }
                    }
                    
                    if (matchingDirectors.isEmpty()) {
                        System.out.println("No matching directors found.");
                    } else {
                        System.out.println("Matching Directors:");
                        for (Director director : matchingDirectors) {
                            System.out.println("Name: " + director.getName());
                            System.out.println("Director ID: " + director.getDirectorId());
                            System.out.println("Productions:");
                            for (Production production : director.getProductions()) {
                                System.out.println("- " + production.getTitle());
                            }
                            System.out.println("--------------------");
                            
                            // Ask if the user wants to see highest and lowest rated productions
                            System.out.print("Do you want to see their highest and lowest rated productions? (y/n): ");
                            String showRatingsOption = input.nextLine();
                            if (showRatingsOption.equalsIgnoreCase("y")) {
                                Production highestRatedProduction = director.getHighestRatedProduction();
                                Production lowestRatedProduction = director.getLowestRatedProduction();
                                
                                if (highestRatedProduction != null) {
                                    System.out.println("Highest Rated Production: " + highestRatedProduction.getTitle());
                                    System.out.println("Average Rating: " + highestRatedProduction.getRating());
                                } else {
                                    System.out.println("No highest rated production found.");
                                }
                                
                                if (lowestRatedProduction != null) {
                                    System.out.println("Lowest Rated Production: " + lowestRatedProduction.getTitle());
                                    System.out.println("Average Rating: " + lowestRatedProduction.getRating());
                                } else {
                                    System.out.println("No lowest rated production found.");
                                }
                                System.out.println("--------------------");
                            }
                        }
                    }       }

                default -> System.out.println("Invalid option. Please try again.");
            }
        }
        
       
        
        
        
        // ENTER AN ACTOR OR DIRECTOR TO FAVORITES
        case 2 -> {
            
            // ask if user has account
            System.out.println("Do you want to sign in or register?");
            System.out.println("1. Sign in");
            System.out.println("2. Register");
            System.out.print("Enter your choice: ");
            int signInOrRegisterChoice = Integer.parseInt(input.nextLine());
            
            
            User signedInUser = null;
            switch (signInOrRegisterChoice) {
    case 1 -> {
        // Sign in
        System.out.print("Enter your username: ");
        String username = input.nextLine();
        System.out.print("Enter your password: ");
        String password = input.nextLine();

        // Sign in the user
        signedInUser = userDatabase.signInUser(username, password);
        if (signedInUser == null) {
            System.out.println("Invalid username or password. Rating not added.");
        } else {
            System.out.println("Hello " + signedInUser.getUsername());

            // Select favorite actor or director
            System.out.println("Select favorite actor or director:");
            System.out.println("1. Favorite actor");
            System.out.println("2. Favorite director");
            System.out.print("Enter your choice: ");
            int favoriteChoice = Integer.parseInt(input.nextLine());

            switch (favoriteChoice) {
                case 1 -> {
                    // Select favorite actor
                    System.out.print("Enter the actor's name: ");
                    String actorName = input.nextLine();

                    // Perform actor search to find the actor by name
                    // If found, add the actor to the user's favorite actors
                    Actor actor = searchActorByName(actors, actorName);
                    if (actor == null) {
                        System.out.println("Actor not found.");
                    } else {
                        signedInUser.addFavoriteActor(actor);
                        System.out.println("Actor " + actor.getName() + " added to favorites.");
                    }
                }
                case 2 -> {
                    // Select favorite director
                    System.out.print("Enter the director's name: ");
                    String directorName = input.nextLine();

                    // Perform director search to find the director by name
                    // If found, add the director to the user's favorite directors
                    Director director = searchDirectorByName(directors, directorName);
                    if (director == null) {
                        System.out.println("Director not found.");
                    } else {
                        signedInUser.addFavoriteDirector(director);
                        System.out.println("Director " + director.getName() + " added to favorites.");
                    }
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
    case 2 -> {
        // Register
        System.out.print("Enter your username: ");
        String username = input.nextLine();
        System.out.print("Enter your email: ");
        String email = input.nextLine();
        System.out.print("Enter your password: ");
        String password = input.nextLine();

        // Register the user
        signedInUser = userDatabase.registerUser(username, email, password);
        if (signedInUser == null) {
            System.out.println("Username or email already exists. Registration failed.");
        } else {
            System.out.println("Hello " + signedInUser.getUsername() + "! You are now able to rate.");

            // Select favorite actor or director
            System.out.println("Select favorite actor or director:");
            System.out.println("1. Favorite actor");
            System.out.println("2. Favorite director");
            System.out.print("Enter your choice: ");
            int favoriteChoice = Integer.parseInt(input.nextLine());

            switch (favoriteChoice) {
                case 1 -> {
                    // Select favorite actor
                    System.out.print("Enter the actor's name: ");
                    String actorName = input.nextLine();

                    // Perform actor search to find the actor by name
                    // If found, add the actor to the user's favorite actors
                    Actor actor = searchActorByName(actors, actorName);
                    if (actor == null) {
                        System.out.println("Actor not found.");
                    } else {
                        signedInUser.addFavoriteActor(actor);
                        System.out.println("Actor " + actor.getName() + " added to favorites.");
                    }
                }
                case 2 -> {
                    // Select favorite director
                    System.out.print("Enter the director's name: ");
                    String directorName = input.nextLine();

                    // Perform director search to find the director by name
                    // If found, add the director to the user's favorite directors
                    Director director = searchDirectorByName(directors, directorName);
                    if (director == null) {
                        System.out.println("Director not found.");
                    } else {
                        signedInUser.addFavoriteDirector(director);
                        System.out.println("Director " + director.getName() + " added to favorites.");
                    }
                }
                default -> System.out.println("Invalid option.");
            }
            
                    }
            
            
        }
            }
        }
        
        // VIEW ALL FAVORITES
        case 3 -> {
            // View all favorite actors and directors
            User signedInUser = null;
            System.out.print("Enter your username: ");
        String username = input.nextLine();
        System.out.print("Enter your password: ");
        String password = input.nextLine();

        // Sign in the user
        signedInUser = userDatabase.signInUser(username, password);
        if (signedInUser == null) {
            System.out.println("Invalid username or password. Rating not added.");
        } else {
            System.out.println("Hello " + signedInUser.getUsername());
            System.out.println("Favorite actors and directors for " + signedInUser.getUsername() + ":");
            System.out.println("Favorite Actors:");
            signedInUser.displayFavoriteActors();
            System.out.println("Favorite Directors:");
            signedInUser.displayFavoriteDirectors();
        }
        }
        default -> System.out.println("Invalid option. Please try again.");
    }
}
                   

                    
                    
                    
            
                   // EXIT PROGRAM
                    case 5 -> {
                        
                        quit = true;
                        break;
                    }
                    
                    //INVALID MENU OPTION
                    default -> {
                        System.out.println("Invalid option. Please select a valid option from the menu.");
                        break;
                    }
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid option from the menu.");
            input.nextLine(); // consume the invalid input
        }
    }
}
       
   
   
   
   
   
 // Method to find a production by title
public static Production findProduction(String title) {
    for (Production production : productions) {
        if (production.getTitle().equals(title)) {
            return production;
        }
    }
    return null; // Return null if no matching production is found
}

// Method to find an actor by name
public static Actor findActor(String actorName) {
    for (Actor actor : actors) {
        if (actor.getName().equals(actorName)) {
            return actor;
        }
    }
    return null; // Return null if no matching actor is found
}

// Method to find a director by name
public static Director findDirector(String directorName) {
    for (Director director : directors) {
        if (director.getName().equalsIgnoreCase(directorName)) {
            return director;
        }
    }
    return null; // Return null if no matching director is found
}

// Method to generate a unique ID for productions (movies or series)
public static String generateUniqueId(boolean isSeries) {
    if (isSeries) {
        lastSeriesId++;
        return "s" + lastSeriesId;
    } else {
        lastMovieId++;
        return "m" + lastMovieId;
    }
}

// Method to generate an actor ID
private static String generateActorID() {
    actorCount++; // Increment the actor count
    return "a" + actorCount; // Return the generated ID
}

// Method to generate a director ID
private static String generatedirectorID() {
    directorCount++; // Increment the director count
    return "d" + directorCount; // Return the generated ID
}

// Method to display user ratings for a production
public static void displayUsersRatings(Production production) {
    List<String> usernames = production.getUsernames();
    List<Integer> userRatings = production.getUserRatings();

    if (usernames.isEmpty()) {
        System.out.println("No user ratings available for this production.");
    } else {
        System.out.println("User Ratings for " + production.getTitle() + ":");
        for (int i = 0; i < usernames.size(); i++) {
            String username = usernames.get(i);
            int rating = userRatings.get(i);
            System.out.println("Username: " + username + ", Rating: " + rating);
        }
    }
}

// Method to search for an actor by name in a given list of actors
private static Actor searchActorByName(ArrayList<Actor> actors, String actorName) {
    for (Actor actor : actors) {
        if (actor.getName().equalsIgnoreCase(actorName)) {
            return actor;
        }
    }
    return null;
}

// Method to search for a director by name in a given list of directors
private static Director searchDirectorByName(ArrayList<Director> directors, String directorName) {
    for (Director director : directors) {
        if (director.getName().equalsIgnoreCase(directorName)) {
            return director;
        }
    }
    return null;
}




}
        

                
  




         
                            
                   
