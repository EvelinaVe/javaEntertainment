package javaentertainment;


public class UserRating {
    // Fields
    private final String productionId; // ID of the production being rated
    private final int rating; // User's rating for the production

    // Constructor
    public UserRating(String productionId, int rating) {
        this.productionId = productionId;
        this.rating = rating;
    }

    // Getter for the production ID
    public String getProductionId() {
        return productionId;
    }

    // Getter for the rating
    public int getRating() {
        return rating;
    }
}