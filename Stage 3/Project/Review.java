

public class Review {
    //Instance variables
    private int reviewID;
    private User reviewer;
    private int rating;
    private String comment;
    private Restaurant restaurant;
    private DeliveryPerson deliveryPerson;

    //Constructor for Restaraunt review
    public Review(int reviewID, User reviewer, Restaurant restaurant, int rating, String comment){
        this.reviewID = reviewID;
        this.reviewer = reviewer;
        this.restaurant = restaurant;
        this.rating = rating;
        this.comment = comment;
        this.deliveryPerson = null;
    }

    //Constructor for DeliveryPerson review
    public Review(int reviewID, User reviewer, DeliveryPerson deliveryPerson, int rating, String comment){
        this.reviewID = reviewID;
        this.reviewer = reviewer;
        this.deliveryPerson = deliveryPerson;
        this.rating = rating;
        this.comment = comment;
        this.restaurant = null;
    }

    /**
     * 
     */
    public int getReviewid(){
        return reviewID;
    }

    /**
     * 
     */
    public User getReviewer(){
        return reviewer;
    }

    /**
     * 
     */
    public int getRating(){
        return rating;
    }

    /**
     * 
     */
    public void setRating(int rating){
        this.rating = rating;
    }

    /**
     * 
     */
    public String getComment(){
        return comment;
    }

    /**
     * 
     */
    public void setComment(String comment){
        this.comment = comment;
    }

    /**
     * 
     */
    public Restaurant getRestaurant(){
        return restaurant;
    }

    /**
     * 
     */
    public DeliveryPerson getDeliveryPerson(){
        return deliveryPerson;
    }

    

    
}
