import java.util.Scanner;

public class PaymentProcessor {
    //Instance Variables
    private Scanner in;
    private FoodDeliverySystem system;

    /**
     * Constructor
     * @param system
     */
    public PaymentProcessor(FoodDeliverySystem system){
        this.system = system;
        this.in = new Scanner(System.in);
    }

    /**
     * This method recieves the customer, restaurant, and cart to process the order by reveiving payment.
     * The method handles if the user pays insufficiently or over pays. If insufficient funds then the user
     * is asked if they would like to pay the rest. If yes they are reprompted to pay the remainder. 
     * If they say no then the order is cancled.
     * @param customer
     * @param restaurant
     * @param cart
     */
    public void processPayment(User customer, Restaurant restaurant, Cart cart){
        if (cart.getItems().isEmpty()) {
            System.out.println("Cart is empty. Cannot place order.");
            return;
        }

        System.out.print("Enter payment method (Cash/Card): ");
        String method = in.nextLine();

        Payment payment = new Payment(new Order(customer, restaurant, cart), method);

        boolean paid = false;
        while (!paid) {
            double remaining = payment.getRemainingAmount();
            System.out.println("Cart total: $" + String.format("%.2f", remaining));
            System.out.print("Enter amount to pay: ");
            double amount = in.nextDouble();
            in.nextLine(); 

            paid = payment.processPayment(amount);

            if (!paid) {
                System.out.print("Do you want to pay the remaining amount? (yes/no): ");
                String choice = in.nextLine().trim();

                if (!choice.equalsIgnoreCase("yes")) {
                    System.out.println("Order cancelled.");
                    cart.deleteCart();
                    return;
                }
            }
        }

        
        Order order = payment.getOrder();
        system.addOrder(order);
        DeliveryPerson driver = system.assignDeliveryPerson(order);
        System.out.println("Order placed successfully!");
        if(driver == null){
            System.out.println("All drivers are busy. You order is waiting in the queue.");
        } else{
            System.out.println("Driver: " + driver.getName());
        }
        System.out.println("Total paid: $" + String.format("%.2f", payment.getAmount()));
    }
}
