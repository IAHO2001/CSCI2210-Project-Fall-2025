import java.util.List;

public class RestaurantSubMenuManager {
    //Instance variables
    private FoodDeliverySystem system;
    private User customer;
    private Restaurant restaurant;

    /**
     * Constructor
     * @param customer
     * @param system
     * @param restaurant
     */
    public RestaurantSubMenuManager(User customer, FoodDeliverySystem system, Restaurant restaurant){
        this.customer = customer;
        this.system = system;
        this.restaurant = restaurant;
    }

    /**
     * This method shows the restaurants menu items
     */
    public void viewMenuItems(){
        List<MenuItem> items = restaurant.getMenu().getItems();
        if (items.isEmpty()) {
            System.out.println("No items in this restaurant's menu.");
            return;
        }
        System.out.println("\n--- Menu Items ---");
        for (MenuItem item : items) {
            System.out.printf("%s - $%.2f%n", item.getName(), item.getPrice());
        }
    }

    /**
     * This method takes the user to the CartMenuManager to create and manage a cart
     */
    public void manageCart(){
        new CartMenuManager(customer, system, restaurant).showMenu();
    }

    /**
     * This method prints the reviews associated with the restaurant
     */
    public void viewRestaurantReviews() {
        System.out.println("\n--- Reviews for " + restaurant.getName() + " ---");

        List<Review> reviews = restaurant.getReviews(); 

        if (reviews == null || reviews.isEmpty()) {
            System.out.println("No reviews available for this restaurant yet.");
            return;
        }

        System.out.println("Average Rating: " + restaurant.getAverageRating());
        System.out.println("-----------------------------");

        for (Review review : reviews) {
            System.out.printf("Rating: %d/5 | Comment: %s%n",
                    review.getRating(),
                    review.getComment());
        }
    }  
}
