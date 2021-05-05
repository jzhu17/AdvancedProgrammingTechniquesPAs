/* Julia Zhu 
 * PA#3.2
 * COSI 12B Section 1 
 * Description: This program creates a Bird interface that connects the bird classes 
*/

import java.awt.*;

public interface Bird {
    public Color getColor(); //returns the color of the bird 
    public Point getPosition(); //returns the position of the bird 
    public void fly(); //modifies how a certain bird fly 
}