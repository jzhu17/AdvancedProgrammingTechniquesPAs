/* Julia Zhu 
 * PA#4 
 * COSI 12B Section 1 
 * Description: This program creates and modifies an Item 
*/

import java.text.*;

public class Item {
	private String name; 
	private double price; 
	private int bulkQuantity; 
	private double bulkPrice; 
	private NumberFormat nf = NumberFormat.getCurrencyInstance();

	//Constructs an Item with its name and price 
	public Item (String name, double price) {
		
		if (price<0){
			throw new IllegalArgumentException();
		}
		this.name=name;
		this.price=price; 
	}
	
	//Constructs an Item with its name, price, bulk quantity and bulk price 
	public Item (String name, double price, int bulkQuantity, double bulkPrice) {
		
		//the case where the entered price is negative 
		if (price<0){
			throw new IllegalArgumentException();
		}
		this.name=name;
		this.price=price; 
		this.bulkQuantity=bulkQuantity;
		this.bulkPrice=bulkPrice;  
	}
	
	//Returns the price for a given quantity of the item (including bulk price, if applicable). 
	public double priceFor (int quantity) {
		
		//the case where the entered quantity is negative 
		if (quantity<0){
			throw new IllegalArgumentException();
		}
		
		//the case where there is a bulk quantity and price and the ItemOrder qualifies for a bulk price
		if (this.bulkQuantity>0 && quantity>=bulkQuantity) {
			return ((quantity/bulkQuantity)*bulkPrice+(quantity%bulkQuantity)*price); 
		} else { //doesn't qualify for bulk price 
			return quantity*price; 
		}
	}
	
	//Returns a String representation of the item 
	public String toString() {
		
		//the case where bulk quantity and price is applicable 
		if (this.bulkQuantity>0) {
			return name+", "+nf.format(price)+" ("+bulkQuantity+" for "+nf.format(bulkPrice)+")"; 
		} else {
			return name+", "+nf.format(price); 
		}
	}
	
	//returns the name of the item 
	public String getName() {
		return name; 
	}
}
