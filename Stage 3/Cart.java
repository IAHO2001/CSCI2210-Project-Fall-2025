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

    /**
     * Constructor
     * @param customer
     */
    public Cart(User customer){
        this.cartID = IDgenerator.generateCartID();
        this.customer = customer;
        this.items = new ArrayList<>();
        this.totalPrice = 0.0;
    }

    /**
     * This method receives an object MenueItem and adds the item to the list of items and recalculates the total cart price
     * @param item
     */
    public void addItem(MenuItem item){
        items.add(item);
        calculateTotal();
    }

    /**
     * This method receives an object MenuItem and removes the item from the list of items and recalculates the total cart price
     * @param item
     */
    public void removeItem(MenuItem item){
        items.remove(item);
        calculateTotal();
    }

    /**
     * This method returns the total price of the of the cart by traversing through the list of items and adding the price of items.
     * @return double totalPrice
     */
    public double calculateTotal(){
        totalPrice = 0.0;
        for(MenuItem item : items){
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    /**
     * This method deletes the cart by clearing the list of itmes and setting the totalPrice to zero
     */
    public void deleteCart(){
        items.clear();
        totalPrice = 0.0;
    }

    /**
     * This method returns the list of menu items in the car
     * @return List<MenuItem> items
     */
    public List<MenuItem> getItems(){
        return items;
    }

    /**
     * This method returs the customer associated wiht the cart
     * @return User customers
     */
    public User getCustomer(){
        return customer;
    }

    /**
     * this method returns the ID for the cart
     * @return int cartID
     */
    public int getCartID(){
        return cartID;
    }

    /**
     * This method reutrns the total price of the cart
     * @return double totalPrice
     */
    public double getTotalPrice(){
        return totalPrice;
    }

}
