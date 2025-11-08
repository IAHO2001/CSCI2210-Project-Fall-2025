import java.util.ArrayList;
import java.util.List;

/**
 * User.java
 * Customer class extends Person; holds a cart and order history.
 */
public class User extends Person {
    private int userID;
    private String password;
    private String address;
    private Cart cart;
    private List<Order> orderHistory;

    /**
     * Constructor
     * @param name
     * @param email
     * @param phoneNumber
     * @param password
     * @param address
     */
    public User(String name, String email, String phoneNumber, String password, String address) {
        super(name, email, phoneNumber);
        this.userID = IDgenerator.generateUserID();
        this.password = password;
        this.address = address;
        this.cart = null;
        this.orderHistory = new ArrayList<>();
    }

    /**
     * This method returns the user id
     * @return
     */
    public int getUserID() { return userID; }

    /**
     * This method sets the User id. Method receives int ID
     * @param ID
     */
    public void setUserID(int ID) { this.userID = ID; }

    /**
     * This method sets the users password. Method receives String password
     * @param pw
     */
    public void setPasswordUser(String pw) { this.password = pw; }

    /**
     * THis method returns the String password
     * @return String passwrod
     */
    public String getPassword(){return password;}

    /**
     * This method returns the users address
     * @return String address
     */
    public String getAddressUser() { return address; }

    /**
     * This method sets the users address. Method receives string address
     * @param addr
     */
    public void setAddressUser(String addr) { this.address = addr; }

    /**
     * This method returns the object cart associated with user
     * @return Cart
     */
    public Cart getCart() { return cart; }

    /**
     * This method sets the cart. Method receives the object cart
     * @param cart
     */
    public void setCart(Cart cart) { this.cart = cart; }

    /**
     * This method returns the List of object Order as the orderhistory
     * @return List<Order> orderHistory
     */
    public List<Order> getOrderHistory() { return orderHistory; }

    /**
     * This method adds an order to the list of order history
     * @param o Order
     */
    public void addOrder(Order o) { orderHistory.add(o); }

    /**
     * This method is for a user to create a review for a restaurant. The method receives a restaurant rating and comment to pass
     * to the Review class to create a restaurant review. The mehtod then returns the object Review. 
     * @param restaurant
     * @param rating
     * @param comment
     * @return Review
     */
    public Review restaurantReview(Restaurant restaurant, int rating, String comment) {
        Review r = new Review(IDgenerator.generateReviewID(), this, restaurant, rating, comment);
        restaurant.addReview(r);
        return r;
    }

    /**
     * This method is for a user to create a reiew for a delivery driver. The method reveives a driver rating and comment to pass
     * to the Review class to create a Delivery person review. The method returns th eobject Review
     * @param driver
     * @param rating
     * @param comment
     * @return Review
     */
    public Review deliveryReview(DeliveryPerson driver, int rating, String comment) {
        Review r = new Review(IDgenerator.generateReviewID(), this, driver, rating, comment);
        driver.addReview(r);
        return r;
    }

    /**
     * This method returns the String which is a combined line  of The users information
     * @return String
     */
    @Override
    public String toString() {
        return String.format("User ID:%d name:%s Address:%s", userID, this.getName(), address);
    }

}