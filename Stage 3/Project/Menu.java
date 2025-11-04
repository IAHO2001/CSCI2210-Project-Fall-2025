
import java.util.ArrayList;
import java.util.List;

public class Menu {
    //Instance variables
    private int menuID;
    private Restaurant restaurant;
    private List<MenuItem> items;

    //Constructor
    public Menu(Restaurant restaurant){
        this.restaurant = restaurant;
        this.menuID = IDgenerator.generateMenuID();
        this.items = new ArrayList<>();
    }

    /**
     * 
     */
    public void addMenuItem(MenuItem item){
        if(item != null){
            items.add(item);
        }
    }

    /**
     * 
     */
    public void removeMenuItem(MenuItem item){
        items.remove(item);
    }

    /**
     * 
     */
    public List<MenuItem> getItems(){
        return items;
    }

    /**
     * 
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
     * 
     */
    public int getMenuID(){
        return menuID;
    }

    /**
     * 
     */
    public Restaurant getRestaurant(){
        return restaurant;
    }

}
