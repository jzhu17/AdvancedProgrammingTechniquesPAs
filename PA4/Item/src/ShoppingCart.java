/* Julia Zhu 
 * PA#4 
 * COSI 12B Section 1 
 * Description: This program creates and modifies a ShoppingCart of ItemOrders 
*/

import java.util.*;

public class ShoppingCart {
	private ArrayList<ItemOrder> cart; 
	private boolean discount; 
	private double totalCost; 
	private String itemOrders; 
	
	//Constructs an empty list of item orders.
	public ShoppingCart() {
		this.cart = new ArrayList<ItemOrder>();
	}
	
	//Adds an item order to the list, replacing any previous order for this item with the new order
	public void add(ItemOrder newItemOrder) {
		
		//iterates through the cart to check if a previous order of such item was made 
		for (int i=0; i<cart.size(); i++) {
			
			//the case where the name of the new order is the same as that of a previous order
			if (((cart.get(i).getItem()).getName()).equals((newItemOrder.getItem()).getName())){
				cart.set(i,newItemOrder); 
				return; 
			} 
		}
		cart.add(newItemOrder); 
	}
	
	//Sets a boolean value that represents whether this order gets a discount 
	public void setDiscount(boolean value) {
		discount=value; 
	}
	
	//Returns the total cost of the shopping cart
	public double getTotal() {
		totalCost=0; 
		
		//iterates through the cart and adds up each ItemOrder's cost 
		for (ItemOrder i: cart) {
			totalCost+=i.getPrice(); 
		}
		
		if (discount){ //the case where the discount box is selected 
			totalCost=0.9*totalCost;
		} 
		return totalCost; 
	}
	 
	////Calls the sort method in the Collections class and sorts the list of ItemOrders 
	public void sortCart() {
		Collections.sort(cart); 
	}
	
	//Returns a String representation of the item order list.
	public String toString() {
		itemOrders=""; 
		
		//iterates through the loop and puts each item into the string 
		for (ItemOrder i: cart) {
			itemOrders+=i; 
		}
		return itemOrders; 
	}
}
