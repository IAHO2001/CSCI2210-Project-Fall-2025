public class Main {
    public static void main(String[] args){
        FoodDeliverySystem system = new FoodDeliverySystem();

        LoadSystem.loadSystem(system);
        
        MainMenu mainMenu = new MainMenu(system);
        mainMenu.showMenu();

    }

}
