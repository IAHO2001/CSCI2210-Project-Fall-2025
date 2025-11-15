import java.util.List;
import java.util.Scanner;

public class AdminMenuManager {
    //Instance Variables
    private FoodDeliverySystem system;
    private Scanner in;

    /**
     * Constructor
     * @param system
     */
    public AdminMenuManager(FoodDeliverySystem system) {
        this.system = system;
        this.in = new Scanner(System.in);
    }

    /**
     * When this method is called from adminMenu this method gathers information from admin 
     * to create a new driver and adds them to the list of delivery drivers.
     */
    public void addDeliveryDriver() {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter driver name: ");
        String name = in.nextLine();

        System.out.print("Enter driver email: ");
        String email = in.nextLine();

        System.out.print("Enter phone number: ");
        String phoneNumber = in.nextLine();

        System.out.print("Enter password: ");
        String password = in.nextLine();

        System.out.print("Enter vehicle type: ");
        String vehicleType = in.nextLine();

        System.out.print("Enter availability: ");
        String availability = in.nextLine();

        DeliveryPerson d = new DeliveryPerson(name, email, phoneNumber, password, vehicleType, availability, system);
        system.addDeliveryPerson(d);
        System.out.println("Driver added.");

        if(!system.getPendingOrders().isEmpty()){
            Order nextOrder = system.getPendingOrders().poll();
            system.assignDeliveryPerson(nextOrder);
            System.out.println(d.getName() + " has been assigned to a pending order. Order ID: " + nextOrder.getOrderID());
        }
    }

    /**
     * This method removes driver from the list of drivers by providing the admin the list of drivers and lets them choose
     * who to remove. If a driver is current on a delivery they are unable to remove them.
     */
    public void removeDriver(){
        Scanner in = new Scanner(System.in);
        List<DeliveryPerson> drivers = system.getDeliveryPersonnel();

        if (drivers.isEmpty()) {
            System.out.println("No drivers available to remove.");
            return;
        }

        System.out.println("--- Delivery Drivers ---");
        for (int i = 0; i < drivers.size(); i++) {
            DeliveryPerson d = drivers.get(i);
            System.out.printf("%d. %s | Email: %s | Vehicle: %s | Availability: %s%n",
                    i + 1, d.getName(), d.getEmail(), d.getVehicleType(), d.getAvailability());
        }

        System.out.print("Select a driver to remove: ");

        if (!in.hasNextInt()) {
            System.out.println("\nInvalid input. Please enter a number.");
            in.nextLine(); 
            return;
        }

        int choice = in.nextInt();
        in.nextLine(); 

        if (choice < 1 || choice > drivers.size()) {
            System.out.println("Invalid selection.");
            return;
        }

        DeliveryPerson toRemove = drivers.get(choice - 1);

        //Check is driver is on delivery
        if (!toRemove.getAssignedOrders().isEmpty()) {
            System.out.println("Cannot remove this driver. They currently have active deliveries.");
            return;
        }

        // Remove driver
        drivers.remove(toRemove);
        System.out.println("Driver " + toRemove.getName() + " has been removed successfully.");
    }

    /**
     * This method is used to view the list of drivers. The method traverses through the list of delivery drivers
     * and prints a string drivers name, phone, availability and avg rating.
     */
    public void viewDeliveryDrivers() {
        if(system.getDeliveryPersonnel().isEmpty()) {
            System.out.println("No registered drivers.");
            return;
        }

        for(DeliveryPerson d : system.getDeliveryPersonnel()) {
            System.out.println(d.getName() + " | " + d.getPhoneNumber() + " | " + d.getAvailability() + " | " + d.getAverageRating());
        }
    }

    /**
     * This method is used to editDelivery drivers. It prompts the user toto select a driver from the list then has them
     * get the informaiton and updates the drivers info.
     */
    public void editDeliveryDriver() {
        Scanner in = new Scanner(System.in);
        List<DeliveryPerson> drivers = system.getDeliveryPersonnel();

        if (drivers.isEmpty()) {
            System.out.println("No drivers available.");
            return;
        }

        System.out.println("--- Delivery Drivers ---");
        for (int i = 0; i < drivers.size(); i++) {
            DeliveryPerson d = drivers.get(i);
            System.out.printf("%d. %s | Email: %s | Vehicle: %s | Availability: %s%n",
                    i + 1, d.getName(), d.getEmail(), d.getVehicleType(), d.getAvailability());
        }

        int choice = -1;
        while (true) {
            System.out.print("Select driver to edit by number: ");

            if (in.hasNextInt()) {
                choice = in.nextInt();
                in.nextLine(); 

                if (choice >= 1 && choice <= drivers.size()) {
                    break; 
                } else {
                    System.out.println("\nInvalid selection. Please enter a number between 1 and " + drivers.size() + ".");
                }
            }  else {
                String invalid = in.nextLine();
                System.out.println("\nInvalid input. Please enter a valid number.");
            }
        }

        DeliveryPerson driver = drivers.get(choice - 1);

        System.out.print("Enter new name (leave blank to keep current): ");
        String name = in.nextLine();
        if (!name.isBlank()) driver.setName(name);

        System.out.print("Enter new vehicle type (leave blank to keep current): ");
        String vehicle = in.nextLine();
        if (!vehicle.isBlank()) driver.setVehicleType(vehicle);

        System.out.print("Enter new availability (leave blank to keep current): ");
        String availability = in.nextLine();
        if (!availability.isBlank()) driver.setAvailability(availability);

        System.out.println("Driver updated successfully!");
    }

    /**
     * This method is to view all the users. the method traverses through the list of users and prints user information
     */
    public void viewAllUsers() {
        if(system == null){
            System.out.println("System not initialized");
            return;
        }

        if(system.getUsers().isEmpty()){
            System.out.println("There are no users in this system.");
            return;
        }

        System.out.println("--- All Users ---");
        for (User u : system.getUsers()) {
            System.out.printf("Name: %s | Email: %s%n", u.getName(), u.getEmail());
        }
    }

    /**
     * THis method views all orders. This method traverses through the list of orders and prints order information
     */
    public void viewAllOrders() {
        List<Order> orders = system.getOrders();

        System.out.println("--- All Orders ---");
        if(orders.isEmpty()){
            System.out.println("No orders found.");
            return;
        }
        for (Order order : orders) {
            String customerName = (order.getCustomer() != null) ? order.getCustomer().getName() : "Unknown Customer";
            System.out.printf("Order ID: %d | Customer: %s | Total: $%.2f | Status: %s%n",
                    order.getOrderID(), customerName, order.getTotalPrice(), order.getStatus());
        }
    }
}
