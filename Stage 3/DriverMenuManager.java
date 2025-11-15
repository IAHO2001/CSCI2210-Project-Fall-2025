import java.util.List;
import java.util.Scanner;

public class DriverMenuManager {
    //Initate Scanner
    private Scanner in = new Scanner(System.in);

    /**
     * This method receives the object driver then this method views the drivers assigned orders. This is only orders that are pending. 
     * @param driver
     */
    public void viewAssignedOrders(DeliveryPerson driver) {
        List<Order> orders = driver.getAssignedOrders();

        System.out.println("\n--- Assigned Orders ---");
        if (orders == null || orders.isEmpty()) {
            System.out.println("You have no assigned orders.");
            return;
        }

        for (Order order : orders) {
            System.out.printf("Order ID: %d | Restaurant: %s | Total: $%.2f | Status: %s%n",
                    order.getOrderID(),
                    order.getRestaurant().getName(),
                    order.getTotalPrice(),
                    order.getStatus());
        }
    }

    /**
     * This method receives the object driver then uses it to complete the order. The method provides the list of 
     * orders assigned to the driver to which they select which order to complete. The method then sets the status as completed 
     * and removes the order from the list of drivers assignedOrders.
     * @param driver
     */
    public void completeOrder(DeliveryPerson driver) {
        List<Order> orders = driver.getAssignedOrders();

        if (orders == null || orders.isEmpty()) {
            System.out.println("No active orders to complete.");
            return;
        }

        System.out.println("\n--- Complete Order ---");
        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            System.out.printf("%d. Order ID: %d | Restaurant: %s | Status: %s%n",
                    i + 1,
                    order.getOrderID(),
                    order.getRestaurant().getName(),
                    order.getStatus());
        }

        System.out.print("Select an order to mark as completed: ");
        int choice = -1;

        if(in.hasNextInt()){
            choice = in.nextInt();
        
            //If Selction within range complete the order
            if (choice >= 1 && choice <= orders.size()) {
                Order selectedOrder = orders.get(choice - 1);
                selectedOrder.setStatus("Completed");

                System.out.println("Order ID " + selectedOrder.getOrderID() + " has been marked as completed.");

                driver.getAssignedOrders().remove(selectedOrder);
                driver.setAvailability("Available");

                //Check if any orders are queued
                if(!driver.getSystem().getPendingOrders().isEmpty()){
                    Order nextOrder = driver.getSystem().getPendingOrders().poll();

                    driver.getSystem().assignDeliveryPerson(nextOrder);
                    driver.setAvailability("On Delivery");

                    System.out.println("A queued order (ID " + nextOrder.getOrderID() + ") has been assigned to you.");
                } else{
                    driver.setAvailability("Available");
                    System.out.println("There are no queued orders. You are available.");
                }
            } else {
                System.out.println("Invalid choice.");
            }
        } else{
            String invalid = in.nextLine();
            System.out.println("\nInvalid input. Please enter a number");
        }
    }

    /**
     * This method receives the object driver and prints the list of the drivers reviews.
     * @param driver
     */
    public void viewDriverReviews(DeliveryPerson driver) {
        List<Review> reviews = driver.getReviews();

        System.out.println("\n--- My Reviews ---");
        if (reviews == null || reviews.isEmpty()) {
            System.out.println("You have no reviews yet.");
            return;
        }

        System.out.println("Average Rating: " + driver.getAverageRating());

        for (Review review : reviews) {
            System.out.printf("Review ID: %d | Rating: %d | Comment: %s | Reviewer: %s%n",
                    review.getReviewid(),
                    review.getRating(),
                    review.getComment(),
                    review.getReviewer().getName());
        }
    }
}

