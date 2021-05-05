/* Julia Zhu 
 * PA#7 Part I 
 * COSI 12B Section 1 
 * Description: This program produces solution for moving discs from Tower of Hanoi A to C. 
*/

import java.util.*;

public class Tower {
	public static void main(String[] args) {
	   System.out.println("This program produces solution for moving discs from Tower of Hanoi A to C.");
	   System.out.print("Enter number of discs: "); //prompts the user for number of discs
	   Scanner console = new Scanner(System.in);
	   int num = console.nextInt(); 
	   solveTower(num, "A", "B", "C");//calls the recursive method that prints solution 
	}
	
	public static void solveTower(int n, String start, String spare, String end) {
		   if (n == 1) { //the base case where the last step is reached: move the last disk to target tower 
		       System.out.println("Move disk from "+ start +" to "+ end);
		   } else {
		       solveTower(n - 1, start, end, spare);//moving from start to spare 
		       System.out.println("Move disk from "+ start +" to "+ end);
		       solveTower(n - 1, spare, start, end); //moving from spare to end 
		   }
	}
}
