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
    private int deliveryPersonID;
    private String vehicleType;
    private String availability;
    private Order currentOrder;
    private List<Review> reviews;

    //constructor
    public DeliveryPerson(String name, String email, String phoneNumber, String vehichleType, String availability){

            super(name, email, phoneNumber);
            this.deliveryPersonID = IDgenerator.generateDeliveryPersonID();
            this.vehicleType = vehichleType;
            this.availability = availability;
            this.reviews = new ArrayList<>();

             }

    /**
     * This method returns the delivery person ID
     */
    public int getDeliveryPersonID(){
        return deliveryPersonID;
    }
    
    /**
     * this method sets the delivery person ID
     */
    public void setDeliveryPersonID(int ID){
        this.deliveryPersonID = ID;
    }

    /**
     * This method returs the Drivers vehicle type
     */
    public String getVehicleType(){
        return vehicleType;
    }

    /**
     * this method sets the drivers vehicle type
     */
    public void setVehicleType(String vehicleType){
        this.vehicleType = vehicleType;
    }

    /**
     * this method returns the drivers availabilty
     */
    public String getAvailability(){
        return availability;
    }

    /**
     * This method sets the drivers availabity
     */
    public void setAvailability(String availability){
        this.availability = availability;
    }

    /**
     * This method assigns an order to driver (Object Order) and sets availability. 
     */
    public void assignOrder(Order order){
        this.currentOrder = order;
        this.availability = "On Delivery";
    }

    /**
     * This method completes a delivery by setting current order to null and availability to 
     * available
     */
    public void completeDelivery(){
        this.currentOrder = null;
        this.availability = "Available";
    }

    /**
     * This method adds a review to driver by appending object review to arraylist of reviews
     */
    public void addReview( Review review){
        reviews.add(review);
    }

    /**
     * This method returns the list of reviews
     */
    public List<Review> getReviews(){
        return reviews;
    }

    /**
     * This method returns the average rating for a driver by calculating it. 
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


}
