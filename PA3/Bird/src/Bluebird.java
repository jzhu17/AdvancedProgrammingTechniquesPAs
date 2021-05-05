/* Julia Zhu 
 * PA#3.2
 * COSI 12B Section 1 
 * Description: This program produces a class that creates a blue bird and modifies its behaviors
*/

import java.awt.*;

public class Bluebird extends AbstractBird implements Bird, AviaryConstants {
	private int rightOrLeft=0; //a variable that determines whether the bird should fly left or right
    private int upOrDown=0; //a variable that determines whether the bird should fly up or down
	
   //constructs a blue bird with its position and change the color to blue
	public Bluebird(int x, int y) {
    	super(x,y);
    	color=Color.blue;
    }
	
	//modifies how a blue bird flies in a zig-zag fashion
	public void fly() {
        
		//the case when the bird reaches the edges 
        if (position.x==0 || position.x==(SIZE-1)) {
       	    rightOrLeft++;
        }
        
        //the bird goes left and right alternatively once it reaches the edges
        if (rightOrLeft%2==0){
       	    position.x++;
        } else {
       	    position.x--;
        }
        
        //the bird goes up and down alternatively every time it moves 
        if (upOrDown%2==0){
            position.y--;
        } else {
            position.y++;
        }
        upOrDown++; 
    }
}
