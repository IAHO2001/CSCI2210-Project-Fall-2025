
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
     * 
     * @return int itemID
     */
    public int getItemID(){
        return itemID;
    }

    /**
     * 
     * @return String name
     */
    public String getName(){
        return name;
    }

    /**
     * 
     * @return double price
     */
    public double getPrice(){
        return price;
    }

    /**
     * 
     * @param price
     */
    public void setPrice(double price){
        this.price = price;
    }

}

