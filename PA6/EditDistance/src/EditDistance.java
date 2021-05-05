/* Julia Zhu 
 * PA#6
 * COSI 12B Section 1 
 * Description: This program calculates the edit distance between two words and prints out the path
*/

import java.io.*;
import java.util.*;

public class EditDistance {
    public static String start=""; //the starting word 
    public static String end="";   //the target word 
    public static Map<String, HashSet<String>> wordNeighbors;   //stores all words and their neighbors 
    public static Set<String> discovered;   //stores all discovered words 
    public static Queue<String> undiscovered;   //stores all potential words 
    public static Map<String, String> allMaps;   //stores word and neighbors in map-building process 
    public static Stack<String> path;   //stores the path from start to end 
    
	public static void main(String[] args) throws FileNotFoundException {
		Scanner console=new Scanner(System.in);
		Scanner input=ask4File(console);  
		
		wordNeighbors = new HashMap<String,HashSet<String>>();
		
        findNeighbors(input);  //find each word's neighbors and store them into a map
        ask4Words(console);   //asks the user for two words
	}
    
	//scans the file and return a Scanner
	public static Scanner ask4File(Scanner console) throws FileNotFoundException {
		System.out.print("Enter name of dictionary file: "); 
	    String inputFileName=console.nextLine();
	    File inputFile=new File(inputFileName); 
	    
	    while (!inputFile.exists()) { //prompts users for another name if the file doesn't exist 
	        System.out.print("File not found. Try again: ");
	        inputFileName=console.nextLine();
	        inputFile=new File(inputFileName);
	    }
	    return new Scanner (inputFile); 
	}
	
	//find each word's neighbors and store them into a map
	public static void findNeighbors(Scanner input) {
		
		//as long as there's another word, store the word in the key set  
		while(input.hasNextLine()) {
			String line=input.nextLine(); 
			wordNeighbors.put(line, new HashSet<String>()); 
        }
		
		//a set of all the words in dictionary 
		Set<String> words=wordNeighbors.keySet(); 
		
		//compares each word in a nested loop 
		for(String word1: words) {
	        for (String word2: words) {
	        	int count=0;//counts the different letters 
	        	
	    	    for (int i=0; i<word1.length(); i++){
	    	        if (word1.length()==word2.length() && word1.charAt(i) !=word2.charAt(i)) {
	    	            count++;
	    	        }
	        	}
	    	    //if they only have one letter different and have the same length, they are neighbors  
	        	if (count==1) {
		        	wordNeighbors.get(word1).add(word2);
		        }
	        }
		}	
	}
	
	//asks the user for two words and calls buildMap method 
	public static void ask4Words(Scanner console) {
		
		while (!start.equals("quit")) {
        	System.out.print("Enter two words seperated by a space: ");
            start=console.next();
            end=console.next();
            if (!wordNeighbors.containsKey(start) || !wordNeighbors.containsKey(end)) { //the case where word doesn't exist 
                System.out.println("Word does not exist"); 
            } else {
                buildMap(); //builds the HashMap for tracing the shortest path
            }
		}
	}
	
	//builds the HashMap for tracing the shortest path
	public static void buildMap() {
        discovered= new HashSet<String>();
        undiscovered = new LinkedList<String>();
        allMaps = new HashMap<String, String>();
        
        undiscovered.add(start);//starts with the starting word 
      
        //as long as there's more words to discover 
        while (!undiscovered.isEmpty()) {
        	String word = undiscovered.remove(); //get the first word of the LinkedList  
        	
        	if (!word.equals(end)){ //the word is not the target word 
        		discovered.add(word);
        		
        		for (String word1: wordNeighbors.get(word)) { //get the neighbors of the word 
        			
        			if (!discovered.contains(word1)) { //discovered set doesn't contain this word 
                	    undiscovered.add(word1); //adds the word to undiscovered LinkedList 
                	    discovered.add(word1); //adds the word to discovered set 
                	    allMaps.put(word1, word); //put the word and its neighbor in the HashMap for tracing 
        			}
                }
        	} else { //the target word is found 
        		printResult();
        		return; 
        	}
        }
        System.out.println("No solution.");
	}
	
	//prints the path and distance 
	public static void printResult() {
		path = new Stack<String>(); 
		path.push(end);
		
		String add=end;
        
		//trace back through the map and stores the path words in the stack 
		while (!add.equals(start)) {
			add=allMaps.get(add);
			path.push(add);
		}
		int distance=path.size()-1;
		System.out.print("Path = "+path.pop());
		
		//pops the path words from the stack and print them out 
		while(!path.isEmpty()) {
			System.out.print(", "+path.pop());
		}
		System.out.println("\nEdit distance = "+distance);
	}
}
