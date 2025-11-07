// Miranda 
// Lopez

import java.util.ArrayList;
import java.util.List;


    // Represents the central food delivery system, which manages users, restaurants, orders, and delivery personnel.
 
public class FoodDeliverySystem {
    private List<User> users;
    private List<Restaurant> restaurants;
    private List<Order> orders;
    private List<DeliveryPerson> deliveryPersonnel;

    
   //Constructs a new, empty FoodDeliverySystem.
     
    public FoodDeliverySystem() {
        users = new ArrayList<>();
        restaurants = new ArrayList<>();
        orders = new ArrayList<>();
        deliveryPersonnel = new ArrayList<>();
    }

    //Methods to add entities
    public void addUser(User user) { users.add(user); }
    public void addRestaurant(Restaurant restaurant) { restaurants.add(restaurant); }
    public void addOrder(Order order) { orders.add(order); }
    public void addDeliveryPerson(DeliveryPerson driver) { deliveryPersonnel.add(driver); }

    //Getters
    public List<User> getUsers() { return users; }
    public List<Restaurant> getRestaurants() { return restaurants; }
    public List<Order> getOrders() { return orders; }
    public List<DeliveryPerson> getDeliveryPersonnel() { return deliveryPersonnel; }

    
    //* Assigns an available delivery person to an order.
    //* @param order order to assign
    //* @return assigned delivery person or null if none are available
     
    public DeliveryPerson assignDeliveryPerson(Order order) {
        for (DeliveryPerson d : deliveryPersonnel) {
            if (d.getAvailability().equalsIgnoreCase("Available")) {
                d.assignOrder(order);
                return d;
            }
        }
        return null;
    }

    
    //Searches for restaurant by name
    
    public Restaurant searchRestaurant(String name) {
        for (Restaurant r : restaurants) {
            if (r.getName().equalsIgnoreCase(name)) return r;
        }
        return null;
    }

    
    //Searches for user by email
     
    public User searchUser(String email) {
        for (User u : users) {
            if (u.getEmail().equalsIgnoreCase(email)) return u;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Food Delivery System: " + restaurants.size() + " restaurants, " +
               users.size() + " users, " + orders.size() + " orders.";
    }
}
