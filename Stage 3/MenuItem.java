

public class MenuItem {
    //Instance variables
    private int itemID;
    private String name;
    private double price;

    /**
     * Constructor
     * @param name
     * @param price
     */
    public MenuItem(String name, double price){
        this.itemID = IDgenerator.generateItemID();
        this.name = name;
        this.price = price;
    }

    /**
     * This method resturns the ID associated wiht the menu item
     * @return int itemID
     */
    public int getItemID(){
        return itemID;
    }

    /**
     * This method returns the name of the menu item
     * @return String name
     */
    public String getName(){
        return name;
    }

    /**
     * This method returns the price of the menuItem
     * @return double price
     */
    public double getPrice(){
        return price;
    }

    /**
     * This method set shte price of the menuItem
     * @param price
     */
    public void setPrice(double price){
        this.price = price;
    }

}
