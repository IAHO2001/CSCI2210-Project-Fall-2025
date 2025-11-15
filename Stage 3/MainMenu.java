import java.util.Scanner;

public class MainMenu implements MenuInterface {
    //Instance Variables
    private FoodDeliverySystem system;
    private AdminMenu adminMenu;
    private DriverMenu driverMenu;

    /**
     * Constructor Initializes Menus
     * @param system
     */
    public MainMenu(FoodDeliverySystem system) {
        this.system = system;
        this.adminMenu = new AdminMenu(system);
        this.driverMenu = new DriverMenu();
    }

    /**
     * Provides the main menu for the user to see.
     */
    @Override
    public void showMenu() {
        Scanner in = new Scanner(System.in);
        int option = 0;

        do {
            System.out.println("\n=== Food Delivery System ===");
            System.out.println("1. Login as Admin");
            System.out.println("2. Login as Customer");
            System.out.println("3. Login as Delivery Driver");
            System.out.println("4. Create a New Customer");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            if(in.hasNextInt()){
                option = in.nextInt();
                in.nextLine();
            

                switch (option) {
                    case 1:
                        loginAdmin();
                        break;
                    case 2:
                        loginCustomer();
                        break;
                    case 3:
                        loginDriver();
                        break;
                    case 4:
                        createNewCustomer();
                        break;
                    case 5:
                        System.out.println("Exiting. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            } else{
                String invalid = in.nextLine();
                System.out.println("Invalid input. Please enter a Number.");
            }    
        } while (option != 5);
    }

    /**
     * WHen user calls loginAdmin this method is called. The method retrieves information from the user like admin email
     * Then the method will use the login manager to check if the user exists. If they do then they will be sent to the
     * AdminMenu
     */
    private void loginAdmin() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter admin email: ");
        String email = in.nextLine();
        System.out.print("Enter password: ");
        String password = in.nextLine();

        Admin admin = system.getLoginManager().loginAdmin(email, password, system.getAdmins());
        if (admin != null) {
            adminMenu.showMenu(admin);
        } else {
            System.out.println("Invalid Email/Password");
        }
    }

    /**
     * When user calls loginDriver this method is called. The method gets information form the user like their email
     * then the method uses login manager to check if the driver exists. If they do then they will be sent to DriverMenu
     */
    private void loginDriver() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter driver email: ");
        String email = in.nextLine();
        System.out.print("Enter password: ");
        String password = in.nextLine();

        DeliveryPerson driver = system.getLoginManager().loginDriver(email, password, system.getDeliveryPersonnel());
        if (driver != null) {
            driverMenu.showMenu(driver);
        } else {
            System.out.println("Invalid Email/Password");
        }
    }

    /**
     * When user calls lofinCustomer this method is called. The method gets user email and password and uses the login manager to 
     * attempt to login customer. If they do exist then they will be sent to the customerMenu.
     */
    private void loginCustomer() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter email: ");
        String email = in.nextLine();
        System.out.print("Enter password: ");
        String password = in.nextLine();

        User customer = system.getLoginManager().loginUser(email, password, system.getUsers());
        if (customer != null) {
            CustomerMenu customerMenu = new CustomerMenu(system, customer);
            customerMenu.showMenu(customer);
        } else {
            System.out.println("Invalid email/password.");
        }
    }

    /**
     * If the user selects to create a new customer this method gets called which gethers new user information
     * and creates a new user and adds them to the list of Users for the system.
     */
    private void createNewCustomer(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter customer name: ");
        String name = in.nextLine();
        System.out.print("Enter email: ");
        String email = in.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = in.nextLine();
        System.out.print("Enter password: ");
        String password = in.nextLine();
        System.out.print("Enter address: ");
        String address = in.nextLine();

        User newUser = new User(name, email, phoneNumber, password, address);
        system.addUser(newUser);
        System.out.println("Customer accound created.");
    }

}
