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

    /**
     * Constructor
     * @param customer
     * @param restaurant
     * @param cart
     */
    public Order(User customer, Restaurant restaurant, Cart cart){
        this.orderID = IDgenerator.generateOrderID();
        this.customer = customer;
        this.restaurant = restaurant;
        this.cart = cart;
        this.deliveryPerson = null;
        this.status = "Pending";
        this.totalPrice = cart.calculateTotal();
    }

    /**
     * This method returns the Order ID
     * @return int orderID
     */
    public int getOrderID(){
        return orderID;
    }

    /**
     * This method returns the customer associated with the order
     * @return User customer
     */
    public User getCustomer(){
        return customer;
    }

    /**
     * This method returns the restaurant associated with the order
     * @return Restaurant restaurant
     */
    public Restaurant getRestaurant(){
        return restaurant;
    }

    /**
     * This method returns the cart associated with the order
     * @return Cart cart
     */
    public Cart getCart(){
        return cart;
    }

    /**
     * This method returns the status of the order
     * @return String status
     */
    public String getStatus(){
        return status;
    }

    /**
     * This method receives the String status and sets the order status
     * @param status
     */
    public void setStatus(String status){
        this.status = status;
    }

    /**
     * This method returns the total price of the Order
     * @return double totalPrice
     */
    public double getTotalPrice(){
        return totalPrice;
    }

     /**
      * This method assigns a delivery person to the order by receiving object delivery person and 
      * calls the DeliverPerson class method assign Order to do so
      * @param deliveryPerson
      */
    public void assignDeliveryPerson(DeliveryPerson deliveryPerson){
        this.deliveryPerson = deliveryPerson;
        deliveryPerson.assignOrder(this);
    }

    /**
     * This method returns the delivery person associated with the order
     * @return deliveryPerson
     */
    public DeliveryPerson getDeliveryPerson(){
        return deliveryPerson;
    }

}
