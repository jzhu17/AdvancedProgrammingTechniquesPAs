/* Julia Zhu 
 * PA#2
 * COSI 12B Section 1 
 * Description: This program asks for users' birthday and prints relevant information about the birthday
*/

import java.io.*;
import java.util.*;

public class Birthday {
	public static void main(String[] args) {
		PrintStream out1=System.out; 
	    Scanner console=new Scanner(System.in);
		birthday(console, out1); 
	}
    
	//serves as the main structure of the program 
	public static void birthday(Scanner console, PrintStream out1) {
		out1.print("What month, day, and year were you born?");
		int month=console.nextInt();
		int day=console.nextInt();
		int year=console.nextInt(); 
		
		TeacherDate date = new TeacherDate(year, month, day); //a Date representing user's birthday
		TeacherDate today = new TeacherDate(); //a Date representing today 
		
		out1.println("You were born on "+date.toString()+", which was a "+date.getDayOfWeek()+".");
		
		if (date.isLeapYear()){ //the date falls in a leap year 
			out1.println(year+" was a leap year.");
		}
		
		if (day==today.getDay()&& month==today.getMonth()) { //today is user's birthday 
			out1.println("Happy birthday! You are now age "+(today.getYear()-year)+".");
		} else { //today is not user's birthday 
			out1.println("It will be your birthday in "+daysTill(date, today)+" days.");
		}
		
		today= new TeacherDate(); //resets value of today to be today's date 
		out1.println("Your are "+dayBetween(date, today)+" days old.");
	}
    
	//calculates days till next birthday
	public static int daysTill(TeacherDate date, TeacherDate today){ 
		TeacherDate nextBday; //Date representing user's next birthday 
		
		//user's birthday is in next year 
	    if (date.getMonth()<today.getMonth() || (date.getMonth()==today.getMonth() && date.getDay()<today.getDay())) {
	        nextBday=new TeacherDate(today.getYear()+1, date.getMonth(), date.getDay()); 
	    } else { //user's birthday is in this year 
	    	nextBday=new TeacherDate(today.getYear(), date.getMonth(), date.getDay()); 
	    }
	    
	    return dayBetween(today,nextBday); //method that returns days between today and nextBday
	}
	
	//calculates days between two certain dates 
	public static int dayBetween(TeacherDate start, TeacherDate end) {
		int daysBetween=0;  //stores number of days between the dates 
		
		while (!start.equals(end)){ //the start date is not the same as the end date
			daysBetween++; 
			start.nextDay(); //moves start date to the next day 
		}
		
		return daysBetween; 
	}
}
