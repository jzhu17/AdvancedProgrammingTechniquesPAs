/* Julia Zhu 
 * PA#2
 * COSI 12B Section 1 
 * Description: This program produces a Date class that creates and modifies a certain date in time 
*/

public class Date { 
	
	private int year;
	private int month;
	private int day;
	//array that stores every day of a week 
	private String[] dayOfWeek={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
	
	//constructs a new Date representing the given year, month, and day 
	public Date(int year, int month, int day){ 
		this.year=year;
		this.month=month;
		this.day=day; 
	}
	
	//constructs a new Date representing the date at which the program is run (today)
	public Date() {
		int todaySinceEpoch = TeacherDate.getDaysSinceEpoch();
		
		//sets the initial date of today to be 1970/1/1
		year=1970;
		month=1;
		day=1;
		
		while (todaySinceEpoch !=0){ //the date is still not today
			nextDay(); //moves the date to the next day
			todaySinceEpoch--; //decrease by 1 so the loop iterates todaySinceEpoch times
		}
	}
    
	//returns the Date's day of the month
	public int getDay() {
        return day; 
	}
	
	//returns the Date's month of the year
	public int getMonth() {
		return month; 
	}
	
	//returns the Date's year 
	public int getYear() {
		return year; 
	}
	
	//returns a String representing what day of the week the Date falls on
	public String getDayOfWeek() {
		Date startDate= new Date(1753,1,1); 
		int days=0; //represents days between 1753/1/1 and the Date
		
		//moves startDate to its next day if it's not the same as the Date 
		while (!equals(startDate)){
			days++; //increases days between 1753/1/1 and the Date by 1
			startDate.nextDay();   
		}  
		return dayOfWeek[days%7]; //if days%7=0, the string would be "Monday", etc. 
	}
    
	//returns whether the Date's year is a leap year
	public boolean isLeapYear() {
		return (year%4==0 && year%100!=0) || year%400==0; 
	}
	
	//advances the Date to the next day after its current day
	public void nextDay() {
		//stores number of days in each month
		int[] daysInMonth={0,31,28,31,30,31,30,31,31,30,31,30,31}; 
		
		if (isLeapYear()) { 
			daysInMonth[2]=29;  
	    } 
		
	    if (day==daysInMonth[month]){ //day is at the maximum value 
	    	day=1; 
	    	
	    	if (month==12){ //it's the last day of the year 
	    		month=1; 
	    		year++; 
	    	} else { //it's still the same year 
	    		month++;  
	    	} 	
	    } else { //day in month is not the max 
	    	day++; 
	    }
	}
    
	//returns a String representation of the Date
	public String toString() {
		return year+"/"+month+"/"+day; 
	}
	
	//returns whether the given object is a Date that refers to the same year/month/day as the Date
	public boolean equals(Object o) {
		if (o instanceof Date) {
			Date other= (Date) o; //casts the object into a Date 
			return day==other.day && month==other.month && year==other.year; //compares both Dates 
		} else {
		    return false; 
		}
	}
}
