/* Julia Zhu 
 * PA#3.2
 * COSI 12B Section 1 
 * Description: This program produces a class that creates a cardinal and modifies its behaviors
*/

import java.awt.*;

public class Cardinal extends AbstractBird implements Bird, AviaryConstants {
	private int upOrDown=0;  //a variable that determines whether the bird should fly up or down
	
	//constructs a cardinal with its position and change the color to red 
	public Cardinal(int x, int y) {
    	super(x,y);
    	color=Color.red;
    }
	
	//modifies how a cardinal flies vertically 
    public void fly() {
    	
    	 //the case when the bird reaches the edges 
         if (position.y==0 || position.y==(SIZE-1)) {
        	 upOrDown++;
         }
         
         //the bird goes up and down alternatively once it reaches the edges
         if (upOrDown%2==0){
        	 position.y--;
         } else {
        	 position.y++;
         } 
    }
}
