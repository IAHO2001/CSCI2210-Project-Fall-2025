
import java.util.ArrayList;
import java.util.List;

public class FoodDeliverySystem {
    //Instance variables
    private List<User> users;
    private List<Restaurant> restaurants;
    private List<Order> orders;
    private List<DeliveryPerson> deliveryPersonnel;
    private LoginManager loginManager;

    /**
     * Constructor
     */
    public FoodDeliverySystem(){
        this.users = new ArrayList<>();
        this.restaurants = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.deliveryPersonnel = new ArrayList<>();
        this.loginManager = new LoginManager();
    }

    /**
     * This method adds a user to the list of users
     * @param user
     */
    public void addUser(User user){
        if(user != null) users.add(user);
    }

    /**
     * This method adds a restaurant to the list of restaurants
     * @param restaurant
     */
    public void addRestaurant(Restaurant restaurant){
        if(restaurant != null) restaurants.add(restaurant);
    }

    /**
     * This method adds an order to the list of orders
     * @param order
     */
    public void addOrder(Order order){
        if(order != null) orders.add(order);
    }

    /**
     * This method adds a delivery person to the list of delivery personnel
     * @param driver
     */
    public void addDeliveryPerson(DeliveryPerson driver){
        if(driver != null) deliveryPersonnel.add(driver);
    }

    /**
     * This method returns the lsit of Users
     * @return List<User> user
     */
    public List<User> getUsers(){
        return users;
    }

    /**
     * This method returns the lsit of Restaurants
     * @return List<Restaurant> restaurants
     */
    public List<Restaurant> getRestaurants(){
        return restaurants;
    }

    /**
     * This method returns the list of Ordrs
     * @return List<Order> orders
     */
    public List<Order> getOrders(){
        return orders;
    }

    /**
     * This method returns the list of drivers
     * @return List<DeliveryPerson> deliveryPersonnel
     */
    public List<DeliveryPerson> getDeliveryPersonnel(){
        return deliveryPersonnel;
    }

    /**
     * This method returns the Login manager
     * @return LoginManager
     */
    public LoginManager getLoginManager(){
        return loginManager;
    }

    /**
     * This method receieves an object Order and assignes a delivery person to the order .
     * @param order
     * @return DeliveryPerson
     */
    public DeliveryPerson assignDeliveryPerson(Order order){
        for(DeliveryPerson driver : deliveryPersonnel){
            if(driver.getAvailability().equalsIgnoreCase("Available")){
                order.assignDeliveryPerson(driver);
                return driver;
            }
        }
        return null;
    }

    /**
     * This method receives a string the name of the restaurant and searches through the list of Restauranats for a match. If the restaurant exist
     * method will return the object Restaurant. If doesn't exist will return null
     * @param name
     * @return Restaurant
     */
    public Restaurant searchRestaurant(String name){
        for(Restaurant restaurant : restaurants){
            if(restaurant.getName().equalsIgnoreCase(name)){
                return restaurant;
            }
        }
        return null;
    }

    /**
     * This method receives a string email and searches through the list of Users for a match. If the user exists the method will return the 
     * object User. IF doesn't exist then will return null
     * @param email
     * @return User
     */
    public User searchUser(String email){
        for(User user : users){
            if(user.getEmail().equalsIgnoreCase(email)){
                return user;
            }
        }
        return null;
    }


}

