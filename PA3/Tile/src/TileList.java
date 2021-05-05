/* Julia Zhu 
 * PA#4 
 * COSI 12B Section 1 
 * Description: This program crates and modifies a tile list
*/

import java.util.*;

public class TileList {
	private ArrayList<Tile> tList; 
	
	// constructs an empty tile list
	public TileList() {
		this.tList = new ArrayList<Tile>();
	}
	
	//returns a tile if the tile is inside (x,y) and moves the tile to the back of the list 
	public Tile moveToBack (int x, int y) {
		
		//iterates through the list and add the found Tile to the end 
		for (int i=0; i<tList.size();i++) {
			
		    if (tList.get(i).inside(x,y)) {
		    	this.tList.add(tList.get(i)); 
		    	return tList.get(i) ; //returns the Tile 
		    } 
		}
		return null; 
	}
	
	// inserts t at the back of the list of tiles 
	public void insertBack(Tile t) {
		this.tList.add(t);
	}
	
	//returns the number of tiles in this list 
	public int size() {
		return this.tList.size(); 
	}
	
	//returns the Tile at the given index 
	public Tile get(int index) {
		return this.tList.get(index);
	}

}
