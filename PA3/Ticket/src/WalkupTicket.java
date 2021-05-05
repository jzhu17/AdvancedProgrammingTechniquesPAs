/* Julia Zhu 
 * PA#3
 * COSI 12B Section 1 
 * Description: This program produces a class that creates and modifies a walk-up ticket  
*/

public class WalkupTicket extends RegularTicket{
	
	//constructs a new walk-up ticket with a number
	public WalkupTicket (int number){
		super(number);
	}
	
	//returns the ticket price 
	public double getPrice(){
    	return super.getPrice()+10; 
    }
	
	//prints the ticket number and price
	public String print(){
    	return "Walk-up "+ super.print(); 
    }
	
}
