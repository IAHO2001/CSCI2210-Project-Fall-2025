// Miranda 
// Lopez


   
  
     //Represents single food item that can be added to a restaurant's menu.
 
public class MenuItem {
    private int itemID;
    private String name;
    private double price;

    
     //Constructor to create menu item.
     //@param itemID unique identifier for the menu item
     //@param name name of the menu item
     //@param price cost of the menu item
     
    public MenuItem(int itemID, String name, double price) {
        this.itemID = itemID;
        this.name = name;
        this.price = price;
    }

    //Getters and Setters
    public int getItemID() { return itemID; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    
     //Updates the price of the menu item.
     //@param price new price
     
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}
