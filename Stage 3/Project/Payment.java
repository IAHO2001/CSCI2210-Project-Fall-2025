

public class Payment {
    //Instance variables
    private int paymentID;
    private Order order;
    private double amount;
    private String paymentMethod;
    private String status;

    //Constructor
    public Payment(Order order, String paymentMethod){
        this.paymentID = IDgenerator.generatePaymentID();
        this.order = order;
        this.amount = order.getTotalPrice();
        this.paymentMethod = paymentMethod;
        this.status = "Pening";
    }

    /**
     * 
     */
    public int getPaymentID(){
        return paymentID;
    }

    /**
     * 
     */
    public Order getOrder(){
        return order;
    }

    /**
     * 
     */
    public double getAmount(){
        return amount;
    }

    /**
     * 
     */
    public String getPaymentMethod(){
        return paymentMethod;
    }

    /**
     * 
     */
    public String getStatus(){
        return status;
    }

    /**
     * 
     */
    public void setStatus(String status){
        this.status = status;
    }

    /**
     * 
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
