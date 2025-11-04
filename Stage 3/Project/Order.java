/**
 * This class creates a Order with the associated attributes(instance variables) and has associated methods
 * to update order and retreive order attributes
 * Contains 7 instance variables
 * @author Jacob Chavez
 * @date Nov 3, 2025
 */


public class Order {
    //Instance Variables
    private int orderID;
    private Cart cart;
    private User customer;
    private Restaurant restaurant;
    private String status;
    private double totalPrice;
    private DeliveryPerson deliveryPerson;

    //Constructor
    public Order(User customer, Restaurant restaurant, Cart cart, DeliveryPerson deliveryPerson){
        this.orderID = IDgenerator.generateOrderID();
        this.customer = customer;
        this.restaurant = restaurant;
        this.cart = cart;
        this.deliveryPerson = deliveryPerson;
        this.status = "Pending";
        this.totalPrice = cart.calculateTotal();
    }

    /**
     * This method returns the order ID number
     */
    public int getOrderID(){
        return orderID;
    }

    /**
     * This method returns the User(customer) associated with the order
     */
    public User getCustomer(){
        return customer;
    }

    /**
     * This method returns the Resturaunt the order is placed at
     */
    public Restaurant getRestaurant(){
        return restaurant;
    }

    /**
     * This method returns the object Cart for this order
     */
    public Cart getCart(){
        return cart;
    }

    /**
     * This method returns the status of the order in a string
     */
    public String getStatus(){
        return status;
    }

    /**
     * This method recieves the string status and sets the order status to that string
     */
    public void setStatus(String status){
        this.status = status;
    }

    /**
     * This mehtod retunrs th total price of the order as a double
     */
    public double getTotalPrice(){
        return totalPrice;
    }

    /**
     * This method assignes a delivery person to the order by recieving object delivery person and 
     * calls the DeliveryPerson class method assign Order to do so
     */
    public void assignDeliveryPerson(DeliveryPerson deliveryPerson){
        this.deliveryPerson = deliveryPerson;
        deliveryPerson.assignOrder(this);
    }

    /**
     * This method returns the delivery person associated with the order.
     */
    public DeliveryPerson getDeliveryPerson(){
        return deliveryPerson;
    }

}
