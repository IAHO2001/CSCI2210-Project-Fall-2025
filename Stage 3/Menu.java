
import java.util.ArrayList;
import java.util.List;

public class Menu {
    //Instance variables
    private int menuID;
    private Restaurant restaurant;
    private List<MenuItem> items;

    /**
     * Constructor
     * @param restaurant
     */
    public Menu(Restaurant restaurant){
        this.restaurant = restaurant;
        this.menuID = IDgenerator.generateMenuID();
        this.items = new ArrayList<>();
    }

    /**
     * This method receives obejct MenuItem and adds the item to the menu list
     * @param item
     */
    public void addMenuItem(MenuItem item){
        if(item != null){
            items.add(item);
        }
    }

    /**
     * This method receives object MenuItem and removes the item from the menu list
     * @param item
     */
    public void removeMenuItem(MenuItem item){
        items.remove(item);
    }

    /**
     * This method retursn the list of object MenuItem that are on the menu
     * @return List<MenuItem> items
     */
    public List<MenuItem> getItems(){
        return items;
    }

    /**
     * This method receives a string with e name of a menu item and searches thorugh the list of MenuItems on the menu
     * and returns the MenuItme if it exists in the list or null if it doesn't exist in the list.
     * @param name
     * @return MenuItem
     */
    public MenuItem searchItem(String name){
        for(MenuItem item : items){
            if(item.getName().equalsIgnoreCase(name)){
                return item;
            }
        }
        return null;
    }

    /**
     * This method returns the menuID associated wiht the menu
     * @return int menuID
     */
    public int getMenuID(){
        return menuID;
    }

    /**
     * This method returns the object Restaurant and is associate wiht the menu
     * @return Restaurant
     */
    public Restaurant getRestaurant(){
        return restaurant;
    }

}
