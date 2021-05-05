/* Julia Zhu 
 * PA#4 
 * COSI 12B Section 1 
 * Description: This program creates and modifies an ItemOrder of Items 
*/

public class ItemOrder implements Comparable<ItemOrder> {
	private Item item; 
	private int quantity; 
	
	//Constructs an item order for the given Item and given quantity
	public ItemOrder (Item item, int quantity){
		this.item=item; 
		this.quantity=quantity; 
	}
	
	//Returns the cost for this item order.
	public double getPrice() {
		return item.priceFor(quantity); 
	}
	
	//Returns a reference to the item in this order.
	public Item getItem() {
		return item; 
	}
	
	//Returns a string presentation of the item order 
	public String toString() {
		return "("+item+", "+quantity+")";
	}
	
	//Returns an integer indicating the order of each ItemOrder 
	public int compareTo(ItemOrder a) {
		return this.quantity-a.quantity; 
	}

}
