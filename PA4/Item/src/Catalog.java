/* Julia Zhu 
 * PA#4 
 * COSI 12B Section 1 
 * Description: This program creates and modifies a Catalog of Items 
*/

import java.util.*; 

public class Catalog {
	private String name; 
	private ArrayList<Item> items; 
	
	//Constructor that takes the name of this catalog as a parameter. 
	public Catalog(String name) {
		this.name=name; 
        this.items = new ArrayList<Item>();
	}
	
	//Adds an Item at the end of this list.
	public void add(Item item) {
		items.add(item); 
	}
	
	//Returns the number of items in this list.
	public int size() {
		return items.size(); 
	}
	
	//Returns the Item with the given index
	public Item get(int index){
		return (items).get(index);
	}
	
	//Returns the name of this catalog 
	public String getName() {
		return name; 
	}
}
