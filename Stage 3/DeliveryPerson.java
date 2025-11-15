/**
 * This class creates a Deliver Person with associated attributes inheriting class person. 
 * Associated get/set methods included
 * Contains 5 instance variables
 * @author Jacob Chavez
 * @date Nov 3, 2025
 */

import java.util.ArrayList;
import java.util.List;

public class DeliveryPerson extends Person{
    //instance variables
    private String password;
    private int deliveryPersonID;
    private String vehicleType;
    private String availability;
    private Order currentOrder;
    private List<Review> reviews;
    private List<Order> assignedOrders;
    private FoodDeliverySystem system;

    /**
     * Constructor
     * @param name
     * @param email
     * @param phoneNumber
     * @param password
     * @param vehichleType
     * @param availability
     * @param system
     */
    public DeliveryPerson(String name, String email, String phoneNumber, String password, String vehichleType, String availability, FoodDeliverySystem system){
            super(name, email, phoneNumber);
            this.password = password;
            this.deliveryPersonID = IDgenerator.generateDeliveryPersonID();
            this.vehicleType = vehichleType;
            this.availability = availability;
            this.system = system;
            this.reviews = new ArrayList<>();
            this.assignedOrders = new ArrayList<>();

             }

    /**
     * This method returns the drivers password
     * @return
     */
    public String getPassword(){
        return password;
    }

    /**
     * This method returnts the delivery persons ID
     * @return int deliverPersonID
     */
    public int getDeliveryPersonID(){
        return deliveryPersonID;
    }
    
    /**
     * This method sets a delivery persons ID. This . 
     * @param ID
     */
    public void setDeliveryPersonID(int ID){
        this.deliveryPersonID = ID;
    }

    /**
     * This method returns a string wiht the drivers vehicle type
     * @return String vehicleType
     */
    public String getVehicleType(){
        return vehicleType;
    }

    /**
     * This method recieves a string vehicleType and sets this as the vehicle type
     * @param vehicleType
     */
    public void setVehicleType(String vehicleType){
        this.vehicleType = vehicleType;
    }

    /**
     * This method returns the availability of the driver
     * @return String availability
     */
    public String getAvailability(){
        return availability;
    }

    /**
     * This method receives a string availability and sets it as the drivers availability
     * @param availability
     */
    public void setAvailability(String availability){
        this.availability = availability;
    }

    /**
     * This method receives an object order and assigns the order to the driver
     * @param order
     */
    public void assignOrder(Order order){
        if(!assignedOrders.contains(order)){
            assignedOrders.add(order);
        }
        this.currentOrder = order;
    }


    /**
     * This method completes the order by setting the driver order to null and availability to available
     */
    public void completeDelivery(){
        this.currentOrder = null;
        this.availability = "Available";
    }

    /**
     * This method reveives object review and adds it to the list of reviews
     * @param review
     */
    public void addReview( Review review){
        reviews.add(review);
    }

    /**
     * This method returns the list of objects Review called reviews
     * @return List<Review> reviews
     */
    public List<Review> getReviews(){
        return reviews;
    }

    /**
     * This method returns the average rating of a driver by calculating the average
     * @return
     */
    public double getAverageRating(){
        if(reviews.isEmpty()){
            return 0.0;
        }
        double sum = 0.0;
        for(Review review : reviews){
            sum += review.getRating();
        }
        return sum/reviews.size();
    }

    /**
     * This method returns the list of assignedOrders
     * @return List<Order>
     */
    public List<Order> getAssignedOrders(){
        return assignedOrders;
    }

    /**
     * This method retursn the system that the driver is associated with
     * @return
     */
    public FoodDeliverySystem getSystem(){
        return system;
    }
}
