/* Julia Zhu 
 * PA#5
 * COSI 12B Section 1 
 * Description: This program gives the stable-marriage solution between two groups of people
*/
import java.io.*;
import java.util.*;

public class StableMarriage {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner console= new Scanner (System.in); //'console' will scan users' input 
		mainStruc(console); 
	}
    
	//serves as the main structure of the whole program 
	public static void mainStruc(Scanner console) throws FileNotFoundException{
		Scanner input=ask4File(console); //creates a scanner 'input' that scans the file 
		
		//creates two ArrayLists of Person: a group of men and a group of women
		ArrayList<Person> men = new ArrayList<Person> (); 
		ArrayList<Person> women = new ArrayList<Person> ();   
		
		//scans the file and stores values into both ArrayLists
		scanFile(input, men);
		scanFile(input, women); 
		
		//Marries the couples favoring men and prints results 
		System.out.println("       When Men Are Favored");
		pairUp(men, women); 
		
		//reset the two ArrayLists of Person to original 
		reset(men, women); 
        
		//Marries the couples favoring women and prints results
		System.out.println("       When Women Are Favored");
		pairUp(women, men);
	}
	
	//asks for input file name from the user 
    public static Scanner ask4File(Scanner console) throws FileNotFoundException { 
		System.out.print("Input file name: "); 
		String inputFileName=console.nextLine();
		File inputFile=new File(inputFileName); 
		    
		//prompts users for another name if the file doesn't exist 
		while (!inputFile.exists()) { 
		    System.out.print("File not found. Try again: ");
		    inputFileName=console.nextLine();
		    inputFile=new File(inputFileName);
		}
		return new Scanner (inputFile); //returns a Scanner that scans the file 
    } 
		
	//scans the input file and stores values into ArrayLists
	public static void scanFile (Scanner input, ArrayList<Person> group) {
		
		while(input.hasNextLine()) { 
			String line=input.nextLine();
			
			//when the end of a group is reached, exits the method 
			if (line.equals("END") ) {
				break; 
			}
		    Scanner lineScan=new Scanner(line);//scans each line 
		    
		    //stores the name into a string called name
		    String name="";
			while (lineScan.hasNext() && !name.endsWith(":") ) {
			    String token=lineScan.next(); 
			    name+=" "+token;
			} 
			//gets rid of the colon 
			name=name.substring(0,name.length()-1);
			//creates a new person with the name
			Person aPerson = new Person(name);
			
			//stores the numbers in the person's preference list as integers
			while (lineScan.hasNext()) {
				String token=lineScan.next();
				int token1 = Integer.parseInt(token); 
				aPerson.addChoice(token1); 
			}
			//adds the person to the list of people 
	        group.add(aPerson);
		}
	}
	
	//pairs each man and woman up and calls printResult method
	public static void pairUp(ArrayList<Person> firstGroup, ArrayList<Person> secondGroup){
		
		//iterates through the list for 10 times to ensure marriages are stable 
		for (int k=0; k<10; k++) {
			
			//iterates through every person of the first group
			for (Person man: firstGroup){
				
				//person 'man' dosn't have a partner and still have preferences on his/her list
				while (!man.hasPartner() && man.getPreference().size() !=0) {
					//gets the first person 'woman' on his/her list 
					int firstChoice=man.getPreference().get(0);
					Person woman=secondGroup.get(firstChoice); 
					
					//divorce 'woman' and his/her partner if 'woman' has a partner
					if (woman.hasPartner()) {
						int thePartner=woman.getPartner();
						firstGroup.get(thePartner).setPartner(-1);
					}
				    //marry 'man' and 'woman' instead 
					man.setPartner(firstChoice);		
					woman.setPartner(firstGroup.indexOf(man));
				    
					//iterates through everyone behind 'man' on 'woman's preference list
					for (int i=(woman.getPreference().size())-1; i>=0; i--) {
						
						if(i>(woman.getPreference().indexOf(firstGroup.indexOf(man)))) {
							
							//deletes woman from everyone's list
							Person deleMan1=firstGroup.get(woman.getPreference().get(i));
							deleMan1.getPreference().remove(deleMan1.getPreference().indexOf(firstChoice));
							
							//deletes everyone from 'woman''s list 
							woman.getPreference().remove(i);
						}
					}
				}
			}
		}
		//prints results of both groups
		printResult(firstGroup, secondGroup); 
		printResult(secondGroup, firstGroup);
	}
	
	//prints the partners of both groups and calculate mean choices 
	public static void printResult(ArrayList<Person> group1, ArrayList<Person> group2) {
		System.out.println("Name          Choice          Partner");
        System.out.println("-------------------------------------");
        int sum=0; //keeps track of sum of rankings
        int counter=0; //keeps track of number of married person in the group
        
        for (Person man: group1) {
        	System.out.printf("%-10s",man.getName());
        	
        	//the case where the person has a partner
        	if (man.hasPartner()){
        		int rank=man.getPartnerRank(); 
        		sum+=rank; 
        		counter++; 
        		System.out.printf("%8d %18s\n",man.getPartnerRank(), group2.get(man.getPartner()).getName());
        	} else { //the case where the person doesn't have a partner 
        		System.out.println("      --             nobody");
        	}
        }
        System.out.println(); 
        System.out.println("Mean choice = "+(double)sum/counter);
        System.out.println(); 
	}	
	
	//resets the preference list of very single man and woman 
	public static void reset(ArrayList<Person>men, ArrayList<Person>women) {
		
		for (int i=0; i< men.size(); i++){
			men.get(i).reset(); 
		}
		
		for (int i=0; i< women.size(); i++){
			women.get(i).reset(); 
		}
	}
}
