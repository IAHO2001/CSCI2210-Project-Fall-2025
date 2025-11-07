// Miranda 
// Lopez


   
    //Represents a payment made by a customer for an order.
 
public class Payment {
    private int paymentID;
    private Order order;
    private double amount;
    private String paymentMethod;
    private String status;

    
     //Constructs new Payment.
     //@param paymentID unique payment identifier
     //@param order the order associated with the payment
     //@param amount total amount to be paid
     //@param paymentMethod payment type (e.g., Credit Card, Cash)
     
    public Payment(int paymentID, Order order, double amount, String paymentMethod) {
        this.paymentID = paymentID;
        this.order = order;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.status = "Pending"; // Default status
    }

    //Getters and Setters
    public int getPaymentID() { return paymentID; }
    public Order getOrder() { return order; }
    public double getAmount() { return amount; }
    public String getPaymentMethod() { return paymentMethod; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    
     // Processes the payment (simplified for testing).
     // @return true if successful
     
    public boolean processPayment() {
        this.status = "Completed";
        return true;
    }

    @Override
    public String toString() {
        return "Payment #" + paymentID + " [" + paymentMethod + "] - " + status;
    }
}
