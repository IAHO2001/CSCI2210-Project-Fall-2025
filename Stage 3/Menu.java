// Miranda 
// Lopez


   
  import java.util.ArrayList;
import java.util.List;


     //Represents restaurant menu, which contains a list of menu items.
 
public class Menu {
    private int menuID;
    private Restaurant restaurant;
    private List<MenuItem> items;

    
     //Constructs Menu object linked to a specific restaurant.
     //@param menuID unique menu identifier
     //@param restaurant the restaurant this menu belongs to
     
    public Menu(int menuID, Restaurant restaurant) {
        this.menuID = menuID;
        this.restaurant = restaurant;
        this.items = new ArrayList<>();
    }

    
    //Adds new item to the menu.
     
    public void addMenuItem(MenuItem item) {
        items.add(item);
    }

    
    //Removes an item from the menu.
     
    public void removeMenuItem(MenuItem item) {
        items.remove(item);
    }

    
    //Retrieves all items in the menu.
     
    public List<MenuItem> getItems() {
        return items;
    }

     //Searches for menu item by name.
     //@param name name of the item
     //@return MenuItem if found, null otherwise
     
    public MenuItem searchItem(String name) {
        for (MenuItem item : items) {
            if (item.getName().equalsIgnoreCase(name)) return item;
        }
        return null;
    }

    public int getMenuID() { return menuID; }
    public Restaurant getRestaurant() { return restaurant; }

    @Override
    public String toString() {
        return "Menu ID: " + menuID + " for " + restaurant.getName() + "\nItems: " + items;
    }
}
