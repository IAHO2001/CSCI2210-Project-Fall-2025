import java.util.List;
import java.util.Scanner;

public class CartMenuManager {
    //Instance variables
    private Scanner in;
    private User customer;
    private FoodDeliverySystem system;
    private Restaurant restaurant;
    private Cart cart;

    /**
     * Constructor
     * @param customer
     * @param system
     * @param restaurant
     * @param cart
     */
    public CartMenuManager(User customer, FoodDeliverySystem system, Restaurant restaurant){
        this.customer = customer;
        this.system = system;
        this.restaurant = restaurant;
        this.cart = new Cart(customer);
        this.in = new Scanner(System.in);
    }

    /**
     * This method shows the menu for managing a cart
     */
    public void showMenu(){
        int option = 0;
        do {
            List<MenuItem> items = restaurant.getMenu().getItems();

            System.out.println("\n--- Cart Menu ---");
            for (int i = 0; i < items.size(); i++) {
                System.out.printf("%d. %s - $%.2f%n", i + 1, items.get(i).getName(), items.get(i).getPrice());
            }
            int n = items.size();
            System.out.printf("%d. Remove Item from Cart%n", n + 1);
            System.out.printf("%d. Clear Cart%n", n + 2);
            System.out.printf("%d. Place Order%n", n + 3);
            System.out.printf("%d. Back%n", n + 4);
            System.out.print("Choose an option: ");

            if(in.hasNextInt()){
                option = in.nextInt();
                in.nextLine();
            
                if (option >= 1 && option <= n) {
                    MenuItem selected = items.get(option - 1);
                    cart.addItem(selected);
                    System.out.printf("%s added to cart. Total: $%.2f%n", selected.getName(), cart.getTotalPrice());
                } else if (option == n + 1) {
                    removeItemFromCart();
                } else if (option == n + 2) {
                    cart.deleteCart();
                    System.out.println("Cart cleared.");
                } else if (option == n + 3) {
                    new PaymentProcessor(system).processPayment(customer, restaurant, cart);
                    break; 
                } else if (option == n + 4) {
                    break;
                } else {
                    System.out.println("Invalid option.");
                }
            } else{
                String invalid = in.nextLine();
                System.out.println("\nInvalid input. Please enter a number.");
            }
        } while (true);
    }

    /**
     * This method removes an item from the users cart asking them which item to remove
     */
    private void removeItemFromCart(){
        List<MenuItem> items = restaurant.getMenu().getItems();
        if (cart.getItems().isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        System.out.println("\n--- Remove Item ---");
        System.out.print("Select item to remove (1-" + items.size() + "):");
        int choice = -1;

        if(in.hasNextInt()){
            choice = in.nextInt();
            in.nextLine();
        
            if (choice >= 1 && choice <= items.size()) {
                MenuItem removed = items.get(choice - 1);
                cart.removeItem(removed);
                System.out.printf("%s removed. Cart total: $%.2f%n", removed.getName(), cart.getTotalPrice());
            } else {
                System.out.println("Invalid choice.");
            }
        } else {
            String invalid = in.nextLine();
            System.out.println("\nInvalid input. Please enter a number.");
        }
    }
}
