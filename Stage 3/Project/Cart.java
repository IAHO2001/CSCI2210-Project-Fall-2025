/**
 * This class creates a Cart with attributes like cartID customer items and totalPrice. The class has associated
 * methods that manage the cart
 * Contains 4 instance variables
 * @author Jacob Chavez
 * @date Nov 3, 2025
 */

import java.util.ArrayList;
import java.util.List;

public class Cart {
    //Instance Variables
    private int cartID;
    private User customer;
    private ArrayList<MenuItem> items;
    private double totalPrice;

    //Constructor
    public Cart(User customer){
        this.cartID = IDgenerator.generateCartID();
        this.customer = customer;
        this.items = new ArrayList<>();
        this.totalPrice = 0.0;
    }

    /**
     * This method adds an object item from menuItem to the array list of items then recalculates the total
     */
    public void addItem(MenuItem item){
        items.add(item);
        calculateTotal();
    }

    /**
     * this method removes an object item from menuItem from the arry list of items then recalculates the total
     */
    public void removeItem(MenuItem item){
        items.remove(item);
        calculateTotal();
    }

    /**
     * This method calculates the total by traversing thorugh the list adding up the price using getPrice
     * mehtod then returns the total as a double
     */
    public double calculateTotal(){
        totalPrice = 0.0;
        for(MenuItem item : items){
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    /**
     * This method deletes a cart by clearing the items in the arrayList then reseting the total price to 0.0
     */
    public void deleteCart(){
        items.clear();
        totalPrice = 0.0;
    }

    /**
     * This method returns the list of menuItems 
     */
    public List<MenuItem> getItems(){
        return items;
    }

    /**
     * This method returns the customer associated to the cart
     */
    public User getCustomer(){
        return customer;
    }

    /**
     * This method returns t cart ID for the cart. 
     */
    public int getCartID(){
        return cartID;
    }

    /**
     * This method returns the total price of the cart as a double
     */
    public double getTotalPrice(){
        return totalPrice;
    }

}
