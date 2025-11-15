public class LoadSystem{
    public static void loadSystem(FoodDeliverySystem system) {
        // Admins
        Admin jacob = new Admin("Jacob", "jacob@gmail.com", "Jacob123", "505-123-4567", "Super Admin");
        Admin miranda = new Admin("Miranda", "miranda@gmail.com", "Miranda123" ,"575-123-4567", "Restaurant Admin");
        Admin iris = new Admin("Iris", "iris@gmail.com", "Iris123", "575-321-7654", "Operations Admin");

        system.addAdmin(jacob);
        system.addAdmin(miranda);
        system.addAdmin(iris);

        // Aj's Wings
        Restaurant rest1 = new Restaurant("Aj's Wings", "456 Main Ave", "575-2468");
        system.addRestaurant(rest1);

        // Aj's Wings menu
        Menu menu1 = new Menu(rest1);
        MenuItem wings = new MenuItem("Wings", 9.99);
        MenuItem burger = new MenuItem("Burger", 11.49);
        MenuItem fries = new MenuItem("Fries", 4.00);

        menu1.addMenuItem(wings);
        menu1.addMenuItem(burger);
        menu1.addMenuItem(fries);
        rest1.setMenu(menu1);

        // Tacob Bell
        Restaurant rest2 = new Restaurant("Taco Bell", "123 Main Ave", "575-123-456");
        system.addRestaurant(rest2);

        //Taco Bell menu
        Menu menu2 = new Menu(rest2);
        MenuItem Taco = new MenuItem("Taco", 2.50);
        MenuItem burrito = new MenuItem("Burrito", 4.25);
        MenuItem combo = new MenuItem("Combo(Taco, Burrito, Drink)", 9.50);

        menu2.addMenuItem(Taco);
        menu2.addMenuItem(burrito);
        menu2.addMenuItem(combo);
        rest2.setMenu(menu2);

        //Deliver Drivers
        DeliveryPerson driver1 = new DeliveryPerson("Greyhound", "greyhound@gmail.com", "555-0000", "Greyhounds123","Scooter", "Available", system);
        DeliveryPerson driver2 = new DeliveryPerson("Eduardo", "Eduardo@gmail.com", "555-2222", "Eduardo123", "Car", "Available", system);

        system.addDeliveryPerson(driver1);
        system.addDeliveryPerson(driver2);
    }
}
