/* Julia Zhu 
 * PA#3.2
 * COSI 12B Section 1 
 * Description: This program produces a class that creates a humming bird and modifies its behaviors
*/

import java.awt.*;
import java.util.*;

public class Hummingbird extends AbstractBird implements Bird, AviaryConstants{
	
	//constructs a humming bird with its position and change the color to magenta 
	public Hummingbird(int x, int y) {
    	super(x,y);
    	color=Color.MAGENTA;
    }
	
	//modifies how a humming bird flies randomly inside the aviary
	public void fly() {
        Random randx=new Random();
        Random randy=new Random();
        position.x=randx.nextInt(SIZE);
        position.y=randy.nextInt(SIZE);
    }
}
