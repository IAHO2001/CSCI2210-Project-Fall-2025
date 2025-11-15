

public class IDgenerator {
    //Instance Variables
    private static int reviewID = 1;
    private static int orderID = 1;
    private static int userID = 1;
    private static int adminID = 1;
    private static int deliveryPersonID = 1;
    private static int cartID = 1;
    private static int menuID = 1;
    private static int itemID = 1;
    private static int paymentID = 1;
    private static int restaurantID = 1;

    /**
     * This method generates a new review ID by increasing reviewID by one and returning it
     * @return int
     */
    public static int generateReviewID(){
        return reviewID++;
    }

    /**
     * This method generates the order ID by increasing the orderID by one and returning it
     * @return int
     */
    public static int generateOrderID(){
        return orderID++;
    }

    /**
     * this method generates the User iD by increasing the userID by one and returning it
     * @return int
     */
    public static int generateUserID(){
        return userID++;
    }

    /**
     * THis method generates the admin ID by icnreasing the adminID by one and returning it
     * @return int
     */
    public static int generateAdminID(){
        return adminID++;
    }

    /**
     * THis method generates the delivery person ID by icnreasing the deliveryPersonID by one and returning it
     * @return int
     */
    public static int generateDeliveryPersonID(){
        return deliveryPersonID++;
    }

    /**
     * THis method generates the car ID by icnreasing the cartID by one and returning it
     * @return int
     */
    public static int generateCartID(){
        return cartID++;
    }

    /**
     * THis method generates the menu ID by icnreasing the menuID by one and returning it
     * @return int
     */
    public static int generateMenuID(){
        return menuID++;
    }


    /**
     * THis method generates the item ID by icnreasing the itemID by one and returning it
     * @return int
     */
    public static int generateItemID(){
        return itemID++;
    }

    /**
     * THis method generates the payment ID by icnreasing the paymentID by one and returning it
     * @return int
     */
    public static int generatePaymentID(){
        return paymentID++;
    }

    /**
     * THis method generates the restaurant ID by icnreasing the restaurantID by one and returning it
     * @return int
     */
    public static int generateRestaurantID(){
        return restaurantID++;
    }
}
