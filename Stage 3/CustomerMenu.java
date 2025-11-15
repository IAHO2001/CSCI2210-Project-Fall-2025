import java.util.Scanner;

public class CustomerMenu implements MenuInterface{
    //Instance Variables
    private CustomerMenuManager manager;

    /**
     * Constructor
     * @param system
     * @param Customer
     */
    public CustomerMenu(FoodDeliverySystem system, User Customer) {
        this.manager = new CustomerMenuManager(system, Customer);
    }

    /**
     * If showMenu receives no object then states no customer logged in
     */
    @Override
    public void showMenu(){
        System.out.println("No customer logged in.");
    }

    /**
     * If showMenu receives object user then the customer menu is presented.
     * @param customer
     */
    public void showMenu(User customer) {
        Scanner in = new Scanner(System.in);
        int option = -1;

        do {
            System.out.println("\n--- Customer Menu ---");
            System.out.println("1. Browse Restaurants");
            System.out.println("2. View Order History");
            System.out.println("3. Leave a Review");
            System.out.println("4. Logout");
            System.out.print("Choose an option: ");

            if(in.hasNextInt()){
                option = in.nextInt();
                in.nextLine();
            
                switch (option) {
                    case 1:
                        manager.browseRestaurants();
                        break;
                    case 2:
                        manager.viewOrderHistory();
                        break;
                    case 3:
                        manager.leaveReview(customer);
                        break;
                    case 4: 
                        System.out.println("Logging out...");
                        break;
                    default:
                        System.out.println("Invalid option.");
                }
            } else{
                String invalid = in.nextLine();
                System.out.println("\nInvalid input. Please enter a Number.");
            }
        } while (option != 4);
    }
}