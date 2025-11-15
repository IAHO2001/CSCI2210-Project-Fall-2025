import java.util.Scanner;

public class DriverMenu implements MenuInterface {
    //Instance variables
    private DriverMenuManager manager;

    /**
     * Constructor
     */
    public DriverMenu() {
        this.manager = new DriverMenuManager();
    }

    /**
     * This method shows the Driver menu for the driver
     * @param driver
     */
    public void showMenu(DeliveryPerson driver) {
        Scanner in = new Scanner(System.in);
        int option = -1;

        do {
            System.out.println("\n--- Delivery Driver Menu ---");
            System.out.println("1. View Assigned Orders");
            System.out.println("2. Mark Order as Completed");
            System.out.println("3. View My Reviews");
            System.out.println("4. Logout");
            System.out.print("Choose an option: ");
            
            if(in.hasNextInt()){
                option = in.nextInt();
                in.nextLine();
            
                switch (option) {
                    case 1:
                        manager.viewAssignedOrders(driver);
                        break;
                    case 2:
                        manager.completeOrder(driver);
                        break;
                    case 3:
                        manager.viewDriverReviews(driver);
                        break;
                    case 4: 
                        System.out.println("Logging out...");
                        break;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            } else{
                String invalid = in.nextLine();
                System.out.println(("\nInvalid input. Please enter a number."));
            }
        } while (option != 4);
    }

    /**
     * If no driver is passed to the showMenu then no driver logged in.
     */
    @Override
    public void showMenu() {
        System.out.println("No driver logged in.");
    }
}