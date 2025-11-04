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

    public User(String name, String email, String phoneNumber, String password, String address) {
        super(name, email, phoneNumber);
        this.userID = IDgenerator.generateUserID();
        this.password = password;
        this.address = address;
        this.cart = null;
        this.orderHistory = new ArrayList<>();
    }

    public int getUserID() { return userID; }
    public void setUserID(int ID) { this.userID = ID; }
    public void setPasswordUser(String pw) { this.password = pw; }
    public String getPassword(){return password;}
    public String getAddressUser() { return address; }
    public void setAddressUser(String addr) { this.address = addr; }
    public Cart getCart() { return cart; }
    public void setCart(Cart cart) { this.cart = cart; }
    public List<Order> getOrderHistory() { return orderHistory; }
    public void addOrder(Order o) { orderHistory.add(o); }

    public Review restaurantReview(Restaurant restaurant, int rating, String comment) {
        Review r = new Review(IDgenerator.generateReviewID(), this, restaurant, rating, comment);
        restaurant.addReview(r);
        return r;
    }

    public Review deliveryReview(DeliveryPerson driver, int rating, String comment) {
        Review r = new Review(IDgenerator.generateReviewID(), this, driver, rating, comment);
        driver.addReview(r);
        return r;
    }

    @Override
    public String toString() {
        return String.format("User ID:%d Name:%s Address:%s", userID, name, address);
    }

}