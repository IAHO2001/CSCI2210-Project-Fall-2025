
public class Review {
    //Instance variables
    private int reviewID;
    private User reviewer;
    private int rating;
    private String comment;
    private Restaurant restaurant;
    private DeliveryPerson deliveryPerson;

    /**
     * Constructor for Restaurant review
     * @param reviewID
     * @param reviewer
     * @param restaurant
     * @param rating
     * @param comment
     */
    public Review(int reviewID, User reviewer, Restaurant restaurant, int rating, String comment){
        this.reviewID = IDgenerator.generateReviewID();
        this.reviewer = reviewer;
        this.restaurant = restaurant;
        this.rating = rating;
        this.comment = comment;
        this.deliveryPerson = null;
    }

    /**
     * Constructor for deliveryPerson rewiew
     * @param reviewID
     * @param reviewer
     * @param deliveryPerson
     * @param rating
     * @param comment
     */
    public Review(int reviewID, User reviewer, DeliveryPerson deliveryPerson, int rating, String comment){
        this.reviewID = IDgenerator.generateReviewID();
        this.reviewer = reviewer;
        this.deliveryPerson = deliveryPerson;
        this.rating = rating;
        this.comment = comment;
        this.restaurant = null;
    }

    /**
     * 
     * @return int(reviewID)
     */
    public int getReviewid(){
        return reviewID;
    }

    /**
     * 
     * @return User(reviewer)
     */
    public User getReviewer(){
        return reviewer;
    }

    /**
     * 
     * @return int rating
     */
    public int getRating(){
        return rating;
    }

    /**
     * 
     * @param rating
     */
    public void setRating(int rating){
        this.rating = rating;
    }

    /**
     * 
     * @return String Comment
     */
    public String getComment(){
        return comment;
    }

    /**
     * 
     * @param comment
     */
    public void setComment(String comment){
        this.comment = comment;
    }

    /**
     * 
     * @return Restaurant
     */
    public Restaurant getRestaurant(){
        return restaurant;
    }

    /**
     * 
     * @return DeliveryPerson
     */
    public DeliveryPerson getDeliveryPerson(){
        return deliveryPerson;
    }
}
