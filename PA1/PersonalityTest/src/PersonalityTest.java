/* Julia Zhu 
 * PA#1
 * COSI 12B Section 1 
 * Description: This program produces the personality type of a person based on 
 his/her answers to the personality test. 
*/

import java.io.*;
import java.util.*;

public class PersonalityTest {
	public static void main(String[] args) throws FileNotFoundException {
		PrintStream out1=System.out;  //'out1' will print strings to show users
		Scanner console= new Scanner (System.in); //'console' will scan users' input 
		file(out1, console); 
	}
	
	public static void file(PrintStream out1, Scanner console) throws FileNotFoundException { //takes input file name and creates output file
		out1.print("Input file name: "); 
	    String inputFileName=console.nextLine();
	    File inputFile=new File(inputFileName); 
	    while (!inputFile.exists()) { //prompts users for another name if the file doesn't exist 
	      out1.print("File not found. Try again: ");
	      inputFileName=console.nextLine();
	      inputFile=new File(inputFileName);
	    }
	    Scanner input=new Scanner (inputFile); //creates a scanner 'input' that scans the file 
	    
	    out1.print("Output file name: ");   
	    String outputFileName=console.nextLine();
	    PrintStream out=new PrintStream(new File(outputFileName)); //creates a Printstream 'out' that prints onto the output file
	    pTest(out1, input, out); 
	    out1.println("Your output file has been created!"); 
	} 
	
	public static void pTest(PrintStream out1, Scanner input, PrintStream out) { //scans input file and decides between names and answers 
		int aCount[] = new int[4]; //keeps tract of all a's
	    int bCount[] = new int[4]; //keeps tract of all b's
		while(input.hasNextLine()) {
			String line=input.nextLine(); 
			Scanner lineScan=new Scanner(line); //'lineScan' scans a line in input file 
			String token=lineScan.next(); //stores the first token of each line
			if (token.length()<70) { //the case where the line is the person's name 
				out.println(line+":"); 
			} else { //the case where the line the answers 
				countAns(line, aCount, bCount);  //method that goes through 70 answers and counts a's and b's
				num2Type(aCount, bCount, out); //method that translates numbers to letters that represent the person's type
				out.println(); 
				aCount= new int[4]; //resets values to 0 
				bCount = new int[4]; //resets values to 0 
			}
        }
	}
	
	public static void countAns(String line,int[] aCount,int[] bCount) { //goes through 70 answers and counts a's and b's
	    for (int i=0; i<=69; i++) {
	        if ((line.toLowerCase()).charAt(i)=='a') { //the case where the answer is a 
	        	typeCount(aCount, i); //adds up numbers for each of the four a-type letters 
	    	}
	    	if ((line.toLowerCase()).charAt(i)=='b') {//the case where the answer is b 
	    		typeCount(bCount, i); //adds up numbers for each of the four b-type letters 
	    	}
	    }   
	}
	
	public static void typeCount(int[] aOrB, int i) { //adds up numbers for each different letter 
        if (i%7==0){ //questions that determine between I and E 
	   	    aOrB[0]++;
    	} else if (i%7==1||i%7==2) { //questions that determine between N and S 
    		aOrB[1]++;    
    	} else if (i%7==3||i%7==4) { //questions that determine between F and T
    		aOrB[2]++;    
    	} else {  //questions that determine between P and J 
    		aOrB[3]++; 
    	}
	}
	
	public static void num2Type(int[] aCount, int[] bCount, PrintStream out)  { //translates numbers to letters that represent the person's type
		out.println(aCount[0]+"A-"+bCount[0]+"B "+aCount[1]+"A-"+bCount[1]+"B "+aCount[2]+"A-"+bCount[2]+"B "+aCount[3]+"A-"+bCount[3]+"B ");
		int bPercent[] = new int[4]; //stores percentages of b's 
		String type="";   //sets the base as an empty string 
		String twoType ="ESTJINFP"; //stores all the possible letters 
		for (int i=0; i<=3; i++) { //goes over each of the four letters of the person's type 
			bPercent[i]=(int) ((bCount[i]/(double)(aCount[i]+bCount[i]))*100); //calculates percentages of b's
			if (bPercent[i]>50) { //the case that b is more dominant  
				type+=twoType.charAt(i+4); 
			} else if (bPercent[i]<50) { //the case that a is more dominant 
				type+=twoType.charAt(i);
			} else { //a and b are equally dominant 
				type+="X";
			}	
		}
		out.println("["+bPercent[0]+"%, "+bPercent[1]+"%, "+bPercent[2]+"%, "+bPercent[3]+"%] = "+type);
	}
}
