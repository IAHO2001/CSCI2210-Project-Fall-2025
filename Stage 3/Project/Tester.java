
public class Tester {
    public static void main(String[] args) {

        // Create the central system
        FoodDeliverySystem system = new FoodDeliverySystem();

        // USERS 
        User user1 = new User("Jacob", "jacob@gmail.com", "575-1234", "pass123", "123 18th St");
        User user2 = new User("Miranda", "miranda@gmail.com", "575-5678", "cs456", "789 19th Rd");
        User user3 = new User("America" , "America@gmail.com" , "575-9876", "pass987", "987 20th street");

        system.addUser(user1);
        system.addUser(user2);
        system.addUser(user3);

        // RESTAURANT + MENU
        Restaurant rest1 = new Restaurant("Aj Wings", "456 Main Ave" , "575-2468");
        system.addRestaurant(rest1);

        Menu menu = new Menu(rest1);
        MenuItem wings = new MenuItem("Wings", 9.99);
        MenuItem burger = new MenuItem("Burger", 11.49);
        MenuItem fries = new MenuItem("Fries", 4.00);

        menu.addMenuItem(wings);
        menu.addMenuItem(burger);
        menu.addMenuItem(fries);
        rest1.setMenu(menu);

        // DELIVERY PERSON
        DeliveryPerson driver = new DeliveryPerson("Sam Driver", "sam@driver.com", "555-0000", "Car" , "Available");
        system.addDeliveryPerson(driver);

        // USER LOGINS 
        User loginResult = system.getLoginManager().login("jacob@gmail.com", "pass123", system.getUsers());
        System.out.println("Login for Jacob: " + (loginResult != null ? "Success" : "Failed"));

        // CREATE CART & ORDER 
        Cart cart = new Cart(user1);
        cart.addItem(wings);
        cart.addItem(fries);
        cart.calculateTotal();

        user1.setCart(cart);

        Order order = new Order(user1, rest1, cart);
        system.addOrder(order);

        // Assign a delivery person
        DeliveryPerson assigned = system.assignDeliveryPerson(order);
        System.out.println("Assigned delivery driver: " + (assigned != null ? assigned.getName() : "None available"));

        // PAYMENT
        Payment payment = new Payment(order, "Credit Card");
        boolean paymentSuccess = payment.processPayment();
        System.out.println("Payment status: " + payment.getStatus());

        // REVIEWS
        Review restaurantReview = user1.restaurantReview(rest1, 5, "Amazing food!");
        Review driverReview = user1.deliveryReview(driver, 4, "Fast delivery, thanks!");

        //  DISPLAY SUMMARY
        System.out.println("\n===== SYSTEM SUMMARY =====");
        System.out.println("Users: " + system.getUsers().size());
        System.out.println("Restaurants: " + system.getRestaurants().size());
        System.out.println("Orders: " + system.getOrders().size());
        System.out.println("Delivery Personnel: " + system.getDeliveryPersonnel().size());

        System.out.println("\nRestaurant Reviews:");
        for (Review r : rest1.getReviews()) {
            System.out.println("- " + r.getReviewer().getName() + ": " + r.getRating() + " stars");
        }

        System.out.println("\nDriver Reviews:");
        for (Review r : driver.getReviews()) {
            System.out.println("- " + r.getReviewer().getName() + ": " + r.getRating() + " stars");
        }

        //  LOGOUT
        system.getLoginManager().logout(user1);
        System.out.println("\nJacob logged in? " + system.getLoginManager().isUserLoggedIn(user1));

    }
}