public class Tester {
    public static void main(String[] args) {

        FoodDeliverySystem system = new FoodDeliverySystem();

        // ======== USERS ========
        User user1 = new User("Jacob", "jacob@gmail.com", "575-1234", "pass123", "123 18th St");
        User user2 = new User("Miranda", "miranda@gmail.com", "575-5678", "cs456", "789 19th Rd");
        User user3 = new User("America", "America@gmail.com", "575-9876", "pass987", "987 20th Street");

        system.addUser(user1);
        system.addUser(user2);
        system.addUser(user3);

        // ======== RESTAURANTS ========
        Restaurant rest1 = new Restaurant("Aj Wings", "456 Main Ave", "575-2468");
        system.addRestaurant(rest1);

        Menu menu = new Menu(rest1);
        MenuItem wings = new MenuItem("Wings", 9.99);
        MenuItem burger = new MenuItem("Burger", 11.49);
        MenuItem fries = new MenuItem("Fries", 4.00);

        menu.addMenuItem(wings);
        menu.addMenuItem(burger);
        menu.addMenuItem(fries);
        rest1.setMenu(menu);
        menu.getItems();

        // ======== DELIVERY PEOPLE ========
        DeliveryPerson driver1 = new DeliveryPerson("Sam Driver", "sam@driver.com", "555-0000", "Car", "Available");
        DeliveryPerson driver2 = new DeliveryPerson("Tina Fast", "tina@fast.com", "555-2222", "Scooter", "Available");

        system.addDeliveryPerson(driver1);
        system.addDeliveryPerson(driver2);

        // ======== LOGIN TESTS ========
        System.out.println("Attempt login with WRONG password for Jacob:");
        User badLogin = system.getLoginManager().login("jacob@gmail.com", "wrongpass", system.getUsers());
        System.out.println(badLogin == null ? "Login failed ✅" : "ERROR");

        System.out.println("\nCorrect Login:");
        User loginResult = system.getLoginManager().login("jacob@gmail.com", "pass123", system.getUsers());
        System.out.println("Login for Jacob: " + (loginResult != null ? "Success ✅" : "Failed ❌"));


        // ======== ORDER #1 ========
        Cart cart1 = new Cart(user1);
        cart1.addItem(wings);
        cart1.addItem(fries);
        cart1.calculateTotal();
        user1.setCart(cart1);

        Order order1 = new Order(user1, rest1, cart1);
        system.addOrder(order1);

        DeliveryPerson assigned1 = system.assignDeliveryPerson(order1);
        System.out.println("\nOrder #1 assigned driver: " + assigned1.getName());

        Payment pay1 = new Payment(order1, "Credit Card");
        pay1.processPayment();
        System.out.println("Payment #1 status: " + pay1.getStatus());


        // ======== ORDER #2 (Miranda) ========
        Cart cart2 = new Cart(user2);
        cart2.addItem(burger);
        cart2.addItem(fries);
        cart2.calculateTotal();
        user2.setCart(cart2);

        Order order2 = new Order(user2, rest1, cart2);
        system.addOrder(order2);

        DeliveryPerson assigned2 = system.assignDeliveryPerson(order2);
        System.out.println("\nOrder #2 assigned driver: " + assigned2.getName());

        Payment pay2 = new Payment(order2, "Cash");
        pay2.processPayment();
        System.out.println("Payment #2 status: " + pay2.getStatus());


        // ======== ORDER #3 (America) — Tests scenario when NO driver available ========
        Cart cart3 = new Cart(user3);
        cart3.addItem(burger);
        cart3.calculateTotal();
        user3.setCart(cart3);

        Order order3 = new Order(user3, rest1, cart3);
        system.addOrder(order3);

        DeliveryPerson assigned3 = system.assignDeliveryPerson(order3);
        System.out.println("\nOrder #3 assigned driver: " + (assigned3 != null ? assigned3.getName() : "None available "));

        // Payment, force failure for demonstration
        Payment pay3 = new Payment(order3, "Credit Card");
        pay3.setAmount(0); // forces failure
        boolean result = pay3.processPayment();
        System.out.println("Payment #3 forced failure -> Status: " + pay3.getStatus());


        // ======== REVIEWS ========
        System.out.println("\n--- Adding Reviews ---");
        Review review1 = user1.restaurantReview(rest1, 5, "Amazing food!");
        Review review2 = user2.restaurantReview(rest1, 4, "Good but a little pricey.");
        Review review3 = user1.deliveryReview(driver1, 4, "Fast delivery!");
        Review review4 = user2.deliveryReview(driver2, 5, "Super friendly and quick!");

        //rest1.addReview(review1);
        //rest1.addReview(review2);
        //driver1.addReview(review3);
        //driver2.addReview(review4);


        // ======== SUMMARY ========
        System.out.println("\n===== SYSTEM SUMMARY =====");
        System.out.println("Users: " + system.getUsers().size());
        System.out.println("Restaurants: " + system.getRestaurants().size());
        System.out.println("Orders: " + system.getOrders().size());
        System.out.println("Delivery Personnel: " + system.getDeliveryPersonnel().size());

        System.out.println("\nRestaurant Reviews for Aj Wings:");
        for (Review r : rest1.getReviews()) {
            System.out.println("- " + r.getReviewer().getName() + ": " + r.getRating() + " stars | " + r.getComment());
        }

        System.out.println("\nDriver Reviews:");
        System.out.println(driver1.getName() + " reviews:");
        for (Review r : driver1.getReviews()) {
            System.out.println("- " + r.getReviewer().getName() + ": " + r.getRating() + " stars | " + r.getComment());
        }

        System.out.println(driver2.getName() + " reviews:");
        for (Review r : driver2.getReviews()) {
            System.out.println("- " + r.getReviewer().getName() + ": " + r.getRating() + " stars | " + r.getComment());
        }

        // ======== LOGOUT ========
        system.getLoginManager().logout(user1);
        System.out.println("\nJacob logged in? " + system.getLoginManager().isUserLoggedIn(user1));

        System.out.println("\n===== TEST COMPLETE =====");
    }
}
