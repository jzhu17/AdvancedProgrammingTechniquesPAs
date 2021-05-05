/* Julia Zhu 
 * PA#3.2
 * COSI 12B Section 1 
 * Description: This program produces a class that creates a vulture and modifies its behaviors
*/

import java.awt.*;

public class Vulture extends AbstractBird implements Bird, AviaryConstants {
	private int clock=0; //a variable that determines the direction of the bird 
	
	//constructs a vulture with its position and change the color to black
	public Vulture(int x, int y) {
    	super(x,y);
    	color=Color.black;
    }
	
	//modifies how a vulture flies counter-clockwise 
	public void fly() {
		
		//bird goes in different direction when the remainder is different 
        if (clock%4==0){
        	position.y--;
        } else if (clock%4==1){
        	position.x--;
        } else if (clock%4==2){
        	position.y++;
        } else {
        	position.x++; 
        }
        clock++; 
    }
}
