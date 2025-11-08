

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
    public Review(User reviewer, Restaurant restaurant, int rating, String comment){
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
    public Review(User reviewer, DeliveryPerson deliveryPerson, int rating, String comment){
        this.reviewID = IDgenerator.generateReviewID();
        this.reviewer = reviewer;
        this.deliveryPerson = deliveryPerson;
        this.rating = rating;
        this.comment = comment;
        this.restaurant = null;
    }

    /**
     * This method returns the ID of the review
     * @return int(reviewID)
     */
    public int getReviewid(){
        return reviewID;
    }

    /**
     * This method returns the reviewer associated with the review
     * @return User(reviewer)
     */
    public User getReviewer(){
        return reviewer;
    }

    /**
     * This method returns the rating of the review
     * @return int rating
     */
    public int getRating(){
        return rating;
    }

    /**
     * This method receives the int rating and sets it as the reviews rating
     * @param rating
     */
    public void setRating(int rating){
        this.rating = rating;
    }

    /**
     * This returns the comment assoicated with the review
     * @return String Comment
     */
    public String getComment(){
        return comment;
    }

    /**
     * This method receives the String comment and sets it as the reviews comments
     * @param comment
     */
    public void setComment(String comment){
        this.comment = comment;
    }

    /**
     * This method returns the restaurant associated with the review
     * @return Restaurant
     */
    public Restaurant getRestaurant(){
        return restaurant;
    }

    /**
     * This method returns the delivery person associated with the review
     * @return DeliveryPerson
     */
    public DeliveryPerson getDeliveryPerson(){
        return deliveryPerson;
    }
}

