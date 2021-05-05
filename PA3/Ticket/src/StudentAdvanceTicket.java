/* Julia Zhu 
 * PA#3
 * COSI 12B Section 1 
 * Description: This program produces a class that creates and modifies a student advance ticket  
*/

public class StudentAdvanceTicket extends AdvanceTicket {
	
	//constructs a new student advance ticket with a number and days it was bought in advance 
	public StudentAdvanceTicket (int number, int daysAdvance){
		super(number, daysAdvance);
	}
	
	//returns half of the ticket price of an advance ticket
	public double getPrice(){
    	return super.getPrice()/2; 
    }
	
	//prints the ticket number, price, days bought in advance and requirement for ID 
	public String print(){
    	return "Student "+super.print()+" A student ID is required.";
    }
}
