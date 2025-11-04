

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

    public static int generateReviewID(){
        return reviewID++;
    }

    public static int generateOrderID(){
        return orderID++;
    }

    public static int generateUserID(){
        return userID++;
    }

    public static int generateAdminID(){
        return adminID++;
    }

    public static int generateDeliveryPersonID(){
        return deliveryPersonID++;
    }

    public static int generateCartID(){
        return cartID++;
    }

    public static int generateMenuID(){
        return menuID++;
    }

    public static int generateItemID(){
        return itemID++;
    }

    public static int generatePaymentID(){
        return paymentID++;
    }
}
