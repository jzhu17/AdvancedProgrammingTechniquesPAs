
import java.io.*;
import java.util.*;

public class BirthdayTest {
	public static void main(String[] args) {
		PrintStream out1=System.out; 
	    Scanner console=new Scanner(System.in);
		birthday(console, out1); 
	}

	public static void birthday(Scanner console, PrintStream out1){
		out1.print("What month, day, and year were you born?");
		int month=console.nextInt();
		int day=console.nextInt();
		int year=console.nextInt(); 
		
		Date date = new Date(year, month, day); 
		Date today = new Date();
		
		out1.println("You were born on "+date.toString()+", which was a "+date.getDayOfWeek()+".");
		if (date.isLeapYear()){
			out1.println(year+" was a leap year.");
		}
		if (day==today.getDay()&& month==today.getMonth()) {
			out1.println("Happy birthday! You are now age "+(today.getYear()-year)+".");
		} else {
			out1.println("It will be your birthday in "+daysTill(date, today)+" days.");
		}
		today= new Date(); 
		out1.println("Your are "+dayOld(date, today)+" days old.");
	}
    
	public static int daysTill(Date date, Date today){
		Date nextBday; 
	    if (date.getMonth()<today.getMonth() || (date.getMonth()==today.getMonth() && date.getDay()<today.getDay())) {
	        nextBday=new Date(today.getYear()+1, date.getMonth(), date.getDay()); 
	    } else {
	    	nextBday=new Date(today.getYear(), date.getMonth(), date.getDay()); 
	    }
	    return dayOld(today,nextBday); 
	}
	
	public static int dayOld(Date start, Date end) {
		int daysOld=0;  
		while (!start.equals(end)){
			daysOld++; 
			start.nextDay(); 
		}
		return daysOld; 
	}
}

