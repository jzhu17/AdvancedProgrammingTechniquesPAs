/* Julia Zhu 
 * PA#7 Part I 
 * COSI 12B Section 1 
 * Description: This program prints out the family tree of a person
*/

import java.io.*;
import java.util.*;

public class Relatives {
    public static Family aFamily; //a family of all members 
    public static Person member; //a member of the family 
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner console=new Scanner(System.in);
        Scanner input=ask4File(console);
        readFile(input);
        ask4Name(console);
	}
    
	//asks the user for the input file 
	public static Scanner ask4File(Scanner console) throws FileNotFoundException {
		System.out.print("What is the input file? "); 
	    String inputFileName=console.nextLine();
	    File inputFile=new File(inputFileName); 
	    
	    while (!inputFile.exists()) { //prompts users for another name if the file doesn't exist 
	        System.out.print("File not found. Try again: ");
	        inputFileName=console.nextLine();
	        inputFile=new File(inputFileName);
	    }
	    return new Scanner (inputFile); 
	}
    
	//reads the given file and stores each member and their relatives into the family 
	public static void readFile(Scanner input) {
		aFamily=new Family();
		String line = input.nextLine(); 
		
		while (!line.equals("END")) { //stores the names in the first part into the family 
			member=new Person(line);
			aFamily.setMembers(member); 
			line=input.nextLine();
		}
		
		line=input.nextLine();
		while (!line.equals("END")) { //connects each member with his/her relatives  
			String kid=line; 
			String mother=input.nextLine();
			String father=input.nextLine();
			
			member=aFamily.getOneMember(kid); //gets the person from the family 
			
			if (!mother.equals("unknown")) { //the case where the person's mother is known 
				member.setMother(mother); //sets the mother 
				member=aFamily.getOneMember(mother); //gets the mother from the family 
				member.setKids(kid); //the mother sets the kid also 
			}
			
			if (!father.equals("unknown")) { //same case as above, except this time for father and kid 
				member=aFamily.getOneMember(kid);
				member.setFather(father);
				member=aFamily.getOneMember(father);
				member.setKids(kid);
			}
			
			line=input.nextLine(); //gets the next kid; or quit if it's "END" 
		}
	}
	
	//asks the user for name of a person in the family 
	public static void ask4Name(Scanner console) {
		String name="";
		String indent="    ";
		System.out.print("Person's name ('quit' to end)?"); 
	    name = console.nextLine();
	    
		while (!name.equals("quit")) { //as long as user doesn't quit 
			
			if (!aFamily.isAMember(name)) { //the person doesn't exist: prints a message and quits 
				System.out.println("This person doesn't exist in the family.");
				return;
			}
			
	        System.out.println("Ancestors: ");
	        printAncestors(name, indent);//calls the recursive method that prints out ancestors 
	        indent="    ";
	        System.out.println("Descendants: ");
	        printDescendants(name, indent); //calls recursive method that prints descendants 
	        System.out.print("Person's name ('quit' to end)?"); 
		    name = console.nextLine(); 
		}
	}
	
	//recursive method that prints the ancestors 
	public static void printAncestors(String name, String indent) {
		Person member=aFamily.getOneMember(name);
		System.out.println(indent+name); //prints the name of the person 
		indent+="    ";
		if (member.getFather()!=null|| member.getMother()!=null) {
			if (member.getMother()!=null) { //the person has a mother 
				printAncestors(member.getMother(), indent);
			}
			if (member.getFather() !=null) { //the person has a father 
			    printAncestors(member.getFather(), indent);
			} 
		}
	}
	
	//recursive method that prints the descendants 
	private static void printDescendants(String name, String indent) {
		member=aFamily.getOneMember(name);
		System.out.println(indent+name); //prints the name of the person 
		indent+="    ";
		if (member.getKids() !=null) { //the person has kids 
			for (String kid: member.getKids()) { //goes through the kids and prints their kids 
				printDescendants(kid, indent);
			}
		}
	}
}
