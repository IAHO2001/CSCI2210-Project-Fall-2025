

public class Payment {
    //Instance variables
    private int paymentID;
    private Order order;
    private double amount;
    private String paymentMethod;
    private String status;

    /**
     * Constructor
     * @param order
     * @param paymentMethod
     */
    public Payment(Order order, String paymentMethod){
        this.paymentID = IDgenerator.generatePaymentID();
        this.order = order;
        this.amount = order.getTotalPrice();
        this.paymentMethod = paymentMethod;
        this.status = "Pending";
    }

    /**
     * This method returns the ID for the payment
     * @return int paymentID
     */
    public int getPaymentID(){
        return paymentID;
    }

    /**
     * This method returns the object Order associated with the Payment
     * @return Order
     */
    public Order getOrder(){
        return order;
    }

    /**
     * This method returns the ammount due for the payments
     * @return double
     */
    public double getAmount(){
        return amount;
    }

    /**
     * This method receives double amount and sets it as the payments amount.
     * @return double amount
     */
    public void setAmount(double amount){
        this.amount = amount;
    }

    /**
     * This method returns the payment mehtod for the payments
     * @return String paymentMethod
     */
    public String getPaymentMethod(){
        return paymentMethod;
    }

    /**
     * This method returns the status of the payments
     * @return String status
     */
    public String getStatus(){
        return status;
    }

    /**
     * This method receives string status and sets it as the payments status
     * @param status
     */
    public void setStatus(String status){
        this.status = status;
    }

    /**
     * This method returns true or falsse if the paymetn is completed or failes
     * @return boolean
     */
    public boolean processPayment(){
        if(amount > 0){
            status = "Completed";
            return true;
        } else{
            status = "Failed";
            return false;
        }
    }

}
