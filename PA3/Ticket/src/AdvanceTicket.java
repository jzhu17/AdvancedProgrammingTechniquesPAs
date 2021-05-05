/* Julia Zhu 
 * PA#3
 * COSI 12B Section 1 
 * Description: This program produces a class that creates and modifies a advance ticket  
*/

public class AdvanceTicket extends RegularTicket{
	private int days; 
	
	//constructs a new advance ticket with a number and days it was bought in advance 
	public AdvanceTicket (int number, int days){
		super(number);
		this.days=days; 
	}
	
	//returns the ticket price based on days bought in advance 
	public double getPrice(){
    	if (days>=20){ //bought 20 or more days ago 
    		return 15; 
    	}else if (days<20 && days>10){ //bought between 10 to 20 days ago
    		return 20; 
    	} else { //bought 10 or fewer days ago 
    		return super.getPrice(); 
    	}
    }
	
	//prints the ticket number, price and days bought in advance 
	public String print(){
    	return "Advance "+ super.print()+ ". It was bought "+days+" days in advance.";
    }
}
