import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerMenuManager {
    //Instance
    private FoodDeliverySystem system;
    private Scanner in;
    private User loggedInCustomer;

    /**
     * Constructor
     * @param system
     * @param customer
     */
    public CustomerMenuManager(FoodDeliverySystem system, User customer) {
        this.system = system;
        this.in = new Scanner(System.in);
        this.loggedInCustomer = customer;
    }

    /**
     * This method provides the list of restaurants in the system with a menu to select restaurant
     */
    public void browseRestaurants() {

        List<Restaurant> restaurants = system.getRestaurants();

        if (restaurants.isEmpty()) {
            System.out.println("No restaurants available.");
            return;
        }

        int option = 0;

        do {
            System.out.println("\n--- Restaurants ---");

            for (int i = 0; i < restaurants.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, restaurants.get(i).getName());
            }

            System.out.println((restaurants.size() + 1) + ". Back to Customer Menu");
            System.out.print("Select a restaurant: ");

            if(in.hasNextInt()){
                option = in.nextInt();
                in.nextLine();
            
                if (option >= 1 && option <= restaurants.size()) {
                    new RestaurantSubMenu(loggedInCustomer, system, restaurants.get(option - 1)).showMenu(restaurants.get(option-1));
                } else if (option == restaurants.size() + 1) {
                    System.out.println("Returning to Customer Menu...");
                } else {
                    System.out.println("Invalid option.");
                }
            } else{
                String invalid = in.nextLine();
                System.out.println("\nInvalid input. Please enter a number.");
            }
        } while (option != restaurants.size() + 1);
    }


    /**
     * This method provides the user with their orderHistor 
     */
    public void viewOrderHistory() {
        List<Order> orders = system.getOrders();
        boolean hasOrders = false;

        System.out.println("\n--- Your Order History ---");

        for (Order order : orders) {
            if (order.getCustomer() != null && order.getCustomer().equals(loggedInCustomer)) {
                hasOrders = true;
                System.out.println("Order ID: " + order.getOrderID());
                System.out.println("Restaurant: " + order.getRestaurant().getName());
                System.out.println("Items:");
                for (MenuItem item : order.getCart().getItems()) {
                    System.out.println(" - " + item.getName() + " ($" + String.format("%.2f", item.getPrice()) + ")");
                }
                System.out.println("Total: $" + String.format("%.2f", order.getTotalPrice()));
                System.out.println("Status: " + order.getStatus());
                DeliveryPerson driver = order.getDeliveryPerson();
                System.out.println("Delivery Driver: " + (driver != null ? driver.getName() : "Not assigned"));
                System.out.println("-----------------------------");
            }
        }
        if (!hasOrders) {
            System.out.println("You have not placed any orders yet.");
        }
    }

    /**
     * This method is for a user to leave a review. The method shows the customer a list of their orders to leave a review on and has them 
     * select a order. then they are given the option to leave a review for driver, restaurant, or both. Then the method gathers information
     * and creates a new review and assigns it to driver/restaurant.
     * @param customer
     */
    public void leaveReview(User customer) {
        List<Order> orders = system.getOrders();
        int choice = -1;

        List<Order> customerOrders = new ArrayList<>();
        for (Order order : orders) {
            if (order.getCustomer() != null &&
                order.getCustomer().equals(customer) &&
                "Completed".equalsIgnoreCase(order.getStatus())) {
                customerOrders.add(order);
            }
        }

        if (customerOrders.isEmpty()) {
            System.out.println("You have no completed orders to leave a review for.");
            return;
        }

        System.out.println("\n--- Your Completed Orders ---");
        for (int i = 0; i < customerOrders.size(); i++) {
            Order order = customerOrders.get(i);
            System.out.printf("%d. Order ID: %d | Restaurant: %s | Total: $%.2f%n",
                    i + 1,
                    order.getOrderID(),
                    order.getRestaurant().getName(),
                    order.getTotalPrice());
        }

        System.out.print("Select an order to leave a review for: ");

        if(in.hasNextInt()){
            choice = in.nextInt();
            in.nextLine();
        
            if (choice < 1 || choice > customerOrders.size()) {
                System.out.println("Invalid selection.");
                return;
            }

            Order selectedOrder = customerOrders.get(choice - 1);
            Restaurant restaurant = selectedOrder.getRestaurant();
            DeliveryPerson driver = selectedOrder.getDeliveryPerson();

            System.out.println("1. Leave review for restaurant");
            System.out.println("2. Leave review for delivery driver");
            System.out.println("3. Leave review for both");
            System.out.print("Choose an option: ");
            int reviewOption = -1;

            if(in.hasNextInt()){
                reviewOption = in.nextInt();
                in.nextLine();
            
                System.out.print("Enter your rating (1-5): ");
                int rating = -1;

                if(in.hasNextInt()){
                    rating = in.nextInt();
                    in.nextLine();
                
                    System.out.print("Enter your comment: ");
                    String comment = in.nextLine();

                    //Review for restaurant
                    if (reviewOption == 1) {
                        Review review = new Review(customer, restaurant, rating, comment);
                        restaurant.addReview(review);
                        system.addReview(review);
                        System.out.println("Thank you! Your review for the restaurant has been submitted.");
                    } 
                    //Review for Driver
                    else if (reviewOption == 2) {
                        if (driver == null) {
                            System.out.println("No driver assigned for this order.");
                            return;
                        }
                        Review review = new Review(customer, driver, rating, comment);
                        driver.addReview(review);
                        system.addReview(review);
                        System.out.println("Thank you! Your review for the delivery driver has been submitted.");
                    } 
                    //Review for both 
                    else if (reviewOption == 3) {
                        if (driver == null) {
                            System.out.println("No driver assigned for this order.");
                            return;
                        }
                        Review restReview = new Review(customer, restaurant, rating, comment);
                        Review driverReview = new Review(customer, driver, rating, comment);
                        system.addReview(restReview);
                        restaurant.addReview(restReview);
                        system.addReview(driverReview);
                        driver.addReview(driverReview);
                        System.out.println("Thank you! Your reviews for both restaurant and driver have been submitted.");
                    } 
                    else {
                        System.out.println("Invalid option.");
                    }
                } else{
                    String invalid = in.nextLine();
                    System.out.println("\nInvalid input. Please enter a number.");
                }
            } else{
                String invalid = in.nextLine();
                System.out.println("\nInvalid input. Please enter a number");
            }
        } else{
            String invalid = in.nextLine();
            System.out.println("\nInvalid input. Please enter a number.");
        }
    }
}
