/* Julia Zhu 
 * PA#3.2
 * COSI 12B Section 1 
 * Description: This program crates an abstract class for all the bird classes 
*/

import java.awt.*;
import java.util.*;

public abstract class AbstractBird {
    protected Color color; 
    protected Point position; 
    
    //constructs a bird with its initial position 
    public AbstractBird(int x, int y) {
    	this.position=new Point(x,y); 
    }
    
    //returns the color of the bird 
    public Color getColor() {
    	return color; 
    }
    
    //returns the position of the bird 
    public Point getPosition() {
    	return position;
    }
    
    //modifies how a bird flies in a certain path
    public abstract void fly(); 
}
