import java.util.ArrayList;
import java.util.List;

/**
 * Restaurant.java
 * Represents a restaurant with menu and reviews.
 */
public class Restaurant {
    private int restaurantID;
    private String name;
    private String address;
    private String phoneNumber;
    private Menu menu;
    private List<Review> reviews;

    public Restaurant(int restaurantID, String name, String address, String phoneNumber) {
        this.restaurantID = restaurantID;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.menu = new Menu();
        this.reviews = new ArrayList<>();
    }

    public int getRestaurantID() { return restaurantID; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getPhoneNumber() { return phoneNumber; }
    public Menu getMenu() { return menu; }
    public void setMenu(Menu m) { this.menu = m; }

    public void addReview(Review r) { reviews.add(r); }
    public List<Review> getReview() { return reviews; }

    public double getAverageRating() {
        if (reviews.isEmpty()) return 0.0;
        int s = 0;
        for (Review r : reviews) s += r.getRating();
        return (double) s / reviews.size();
    }

    @Override
    public String toString() {
        return String.format("Restaurant %d: %s (%s) Phone: %s AvgRating: %.2f",
                restaurantID, name, address, phoneNumber, getAverageRating());
    }
}