/* Julia Zhu 
 * PA#3
 * COSI 12B Section 1 
 * Description: This program produces a class that creates and modifies a regular ticket 
*/

public class RegularTicket {
    private int number; 
    
    //constructs a new regular ticket with a number 
    public RegularTicket(int number) {
    	this.number=number;
    }
    
    //returns the ticket price 
    public double getPrice(){
    	return 40; 
    }
    
    //prints the ticket number and price 
    public String print(){
    	return "Ticket number = "+number+" and price = "+getPrice(); 
    }
}
