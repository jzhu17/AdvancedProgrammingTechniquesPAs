/* Julia Zhu 
 * PA#3
 * COSI 12B Section 1 
 * Description: This program produces a client program that tests the functionality of all the ticket classes. 
*/

public class TestTicket {

	public static void main(String[] args) {
        ticketTest();
	}
	
	public static void ticketTest(){ //serves as the main structure of the program 
		RegularTicket[] ticketSystem = new RegularTicket[15]; //array that stores 15 tickets 
		double totalProfits=0; 
		
		//iterates through the array, prints each ticket, adds all prices to calculates total profits 
		for (int i=0; i<createTicket(ticketSystem); i++){
			System.out.println(ticketSystem[i].print()); 
			totalProfits+=ticketSystem[i].getPrice(); 
		}
		System.out.println("The value of total profits from selling the tickets is "+totalProfits); 
	}

	public static int createTicket(Object[] ticketSystem){ //stores different tickets in the array
		int ticketNum=0; //integer variable representing ticket number
		
		//iterates through the array to store tickets 
		for (int i=0; i<ticketSystem.length; i++){
			ticketNum=i+1;//increases by 1 every time the loop iterates 
			if (i==3||i==4){ //walk-up tickets 
				ticketSystem[i]=new WalkupTicket(ticketNum);
			} else if (i==5){ //advance ticket bought 30 days ago 
				ticketSystem[i]=new AdvanceTicket(ticketNum,30);
			} else if (i==6){ 
				ticketSystem[i]=new AdvanceTicket(ticketNum,15);
			} else if (i==7) {
				ticketSystem[i]=new AdvanceTicket(ticketNum,3);
			} else if (i==8){ //student advance ticket bought 30 days ago 
				ticketSystem[i]=new StudentAdvanceTicket(ticketNum,30);
			} else if (i==9){
				ticketSystem[i]=new StudentAdvanceTicket(ticketNum,15);
			} else if (i==10){
				ticketSystem[i]=new StudentAdvanceTicket(ticketNum,3);
			} else { //regular tickets 
				ticketSystem[i]=new RegularTicket(ticketNum);
			}
		}
		return ticketNum; 
	}
}
