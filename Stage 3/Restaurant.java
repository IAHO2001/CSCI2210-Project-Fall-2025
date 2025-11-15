import java.util.ArrayList;
import java.util.List;

/**
 * Restaurant.java
 * Represents a restaurant with menu and reviews.
 */
public class Restaurant {
    //Instance variables
    private int restaurantID;
    private String name;
    private String address;
    private String phoneNumber;
    private Menu menu;
    private List<Review> reviews;

    /**
     * Constructor
     * @param name
     * @param address
     * @param phoneNumber
     */
    public Restaurant(String name, String address, String phoneNumber) {
        this.restaurantID = IDgenerator.generateRestaurantID();
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.menu = new Menu(this);
        this.reviews = new ArrayList<>();
    }

    /**
     * This method returns the restaurant ID
     * @return int restaurantID
     */
    public int getRestaurantID() { return restaurantID; }

    /**
     * This method returns the name of the restaurant
     * @return String name
     */
    public String getName() { return name; }

    /**
     * This method returns the address of the restaurnat
     * @return String address
     */
    public String getAddress() { return address; }

    /**
     * This method returns the restaurants phoneNumber
     * @return String phoneNumber
     */
    public String getPhoneNumber() { return phoneNumber; }

    /**
     * This emthod returns the restaurants menu
     * @return Menu menu
     */
    public Menu getMenu() { return menu; }

    /**
     * This method assigns an object Menu to the restaurant
     * @param m Menu
     */
    public void setMenu(Menu m) { this.menu = m; }

    /**
     * This method receives and object review and adds it to the restaurants list of reviews
     * @param r Review
     */
    public void addReview(Review r) { reviews.add(r); }

    /**
     * This method returns the restaurants lsit of reviews
     * @return List<Review> review
     */
    public List<Review> getReviews() { return reviews; }

    /**
     * This method returns the average rating of the restaurants
     * @return double 
     */
    public double getAverageRating() {
        if (reviews.isEmpty()) return 0.0;
        int s = 0;
        for (Review r : reviews) s += r.getRating();
        return (double) s / reviews.size();
    }

    /**
     * This method returns the string with restaurant information
     * @return String
     */
    @Override
    public String toString() {
        return String.format("Restaurant %d: %s (%s) Phone: %s AvgRating: %.2f",
                restaurantID, name, address, phoneNumber, getAverageRating());
    }
}