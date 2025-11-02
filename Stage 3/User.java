import java.util.ArrayList;
import java.util.List;

/**
 * User.java
 * Customer class extends Person; holds a cart and order history.
 */
public class User extends Person {
    private Cart cart;
    private List<Order> orderHistory;

    public User(int userID, String name, String address) {
        super(userID, name);
        this.address = address;
        cart = new Cart();
        orderHistory = new ArrayList<>();
    }

    public int getUserID() { return id; }
    public void setUserID(int ID) { this.id = ID; }
    public void setPasswordUser(String pw) { this.password = pw; }
    public String getAddressUser() { return address; }
    public void setAddressUser(String addr) { this.address = addr; }
    public Cart getCart() { return cart; }
    public void setCart(Cart cart) { this.cart = cart; }
    public List<Order> getOrderHistory() { return orderHistory; }
    public void addOrder(Order o) { orderHistory.add(o); }

    public Review restaurantReview(Restaurant restaurant, int rating, String comment) {
        Review r = new Review(this, rating, comment);
        restaurant.addReview(r);
        return r;
    }

    public Review deliveryReview(DeliveryPerson driver, int rating, String comment) {
        Review r = new Review(this, rating, comment);
        driver.addReview(r);
        return r;
    }

    @Override
    public String toString() {
        return String.format("User ID:%d Name:%s Address:%s", id, name, address);
    }
}