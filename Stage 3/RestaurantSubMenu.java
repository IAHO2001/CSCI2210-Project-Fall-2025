import java.util.Scanner;

public class RestaurantSubMenu {
    //instance variable
    private RestaurantSubMenuManager manager;

    /**
     * Constructo
     * @param customer
     * @param system
     * @param restaurant
     */
    public RestaurantSubMenu(User customer, FoodDeliverySystem system, Restaurant restaurant){
        this.manager = new RestaurantSubMenuManager(customer, system, restaurant);
    }

    /**
     * This method recieves the selected restaurant and presents the restaurant submenu with the below options
     * @param restaurant
     */
    public void showMenu(Restaurant restaurant){
        Scanner in = new Scanner(System.in);
        int option = 0;

        do {
            System.out.println("\n--- " + restaurant.getName() + " Menu ---");
            System.out.println("1. View Menu Items");
            System.out.println("2. Create / Manage Cart");
            System.out.println("3. View Restaurant Reviews");
            System.out.println("4. Back to Restaurant Browsing.");
            System.out.print("Choose an option: ");

            if(in.hasNextInt()){
                option = in.nextInt();
                in.nextLine();
            
                switch (option) {
                    case 1:
                        manager.viewMenuItems();
                        break;
                    case 2:
                        manager.manageCart();
                        break;
                    case 3:
                        manager.viewRestaurantReviews();
                        break;
                    case 4:
                        System.out.println("Returning to restaurant list...");
                        break;
                    default:
                        System.out.println("Invalid option.");
                }
            } else{
                String invalid = in.nextLine();
                System.out.println("\nInvalid input. Please enter a number.");
            }
        } while (option != 4);
    }

}
