import java.util.Scanner;

public class AdminMenu implements MenuInterface{
    //Instance Variable
    private AdminMenuManager manager ;

    /**
     * Constructor
     * @param system
     */
    public AdminMenu(FoodDeliverySystem system) {
        this.manager = new AdminMenuManager(system);
    }

    /**
     * If adminMenu.showMenu() is called with no admin passed this method is called and states no admin logged in
     */
    @Override
    public void showMenu(){
        System.out.println("No admin logged in.");
    }

    /**
     * If adminMenu.showMenu(admin) is called with object admin then the adminMenu is presented
     * @param admin
     */
    public void showMenu(Admin admin) {
        Scanner in = new Scanner(System.in);
        int option = 0;

        do {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Add Delivery Driver");
            System.out.println("2. Edit Delivery Driver");
            System.out.println("3. Remove Delivery Driver");
            System.out.println("4. View All Drivers");
            System.out.println("5. View All Users");
            System.out.println("6. View All Orders");
            System.out.println("7. Logout");
            System.out.print("Choose an option: ");
            
            if(in.hasNextInt()){
                option = in.nextInt();
                in.nextLine();

                switch (option) {
                    case 1:
                        manager.addDeliveryDriver();
                        break;
                    case 2:
                        manager.editDeliveryDriver();
                        break;
                    case 3: 
                        manager.removeDriver();
                        break;
                    case 4:
                        manager.viewDeliveryDrivers();
                        break;
                    case 5:
                        manager.viewAllUsers();
                        break;
                    case 6:
                        manager.viewAllOrders();
                        break;
                    case 7:
                        System.out.println("Logging out...");
                        break;
                    default:
                        System.out.println("Invalid option.");
                }
            } else{
                String invalid = in.nextLine();
                System.out.println("\nInvalid input. Please enter a Number.");
            }        
        } while (option != 7);
    }
}