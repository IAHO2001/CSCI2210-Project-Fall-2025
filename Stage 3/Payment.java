

public class Payment {
    //Instance variables
    private int paymentID;
    private Order order;
    private double totalAmount;
    private double amountPaid;
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
        this.totalAmount = order.getTotalPrice();
        this.amountPaid = 0.0;
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
        return totalAmount;
    }

    /**
     * This method receives double amount and sets it as the payments amount.
     * @return double amount
     */
    public void setAmount(double amount){
        this.totalAmount = amount;
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
    public boolean processPayment(double amount){
        amountPaid += amount;

        if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
            return false;
        }

        if (amountPaid < totalAmount) {
            double remaining = totalAmount - amountPaid;
            System.out.println("Partial payment received: $" + String.format("%.2f", amount));
            System.out.println("Remaining amount to pay: $" + String.format("%.2f", remaining));
            status = "Pending";
            return false; // still owes money
        } else if (amountPaid == totalAmount) {
            System.out.println("Payment complete. Total amount paid: $" + String.format("%.2f", totalAmount));
            status = "Completed";
            return true;
        } else {
            double change = amountPaid - totalAmount;
            System.out.println("Payment complete. Total amount paid: $" + String.format("%.2f", totalAmount));
            System.out.println("Your change: $" + String.format("%.2f", change));
            status = "Completed";
            return true;
        }
    }

    /**
     * This method returns the remaining amount the user owes
     * @return double
     */
    public double getRemainingAmount(){
        return Math.max(0, totalAmount - amountPaid);
    }
}
