/* Julia Zhu 
 * PA#5
 * COSI 12B Section 1 
 * Description: This program creates and modifies a person
*/
import java.util.*;

public class Person {
    private String name; //represents name of the person
    private ArrayList<Integer> ogPreference; //represents original preference of the person
    private ArrayList<Integer> preference; //represents a constantly updated preference list
    private int partner; //represents the person's partner
    
    //constructs a new person with name as input
    public Person (String name) {
    	this.name=name;
    	this.ogPreference= new ArrayList<Integer>();
    	this.preference= new ArrayList<Integer>();
    	this.partner=-1; 
    }
    
    //returns the name of the person 
    public String getName(){
    	return name; 
    }
    
    //returns the partner of the person 
    public int getPartner(){
    	return partner; 
    }
    
    //sets the partner of the person
    public void setPartner(int partner) {
    	this.partner=partner;
    }
    
    //returns the current preference of the person
    public ArrayList<Integer> getPreference() {
    	return preference; 
    }
    
    //returns true if the person has a partner, false otherwise 
    public boolean hasPartner() {
    	return !(partner==-1); 
    }
    
    //adds a person to this person's both preference lists
    public void addChoice(int person) {
    	preference.add(person);
    	ogPreference.add(person); 
    }
    
    //returns the rank of the person's partner on his/her original list 
    public int getPartnerRank() {
    	return ogPreference.indexOf(partner)+1;
    }
    
    //resets the current preference list to original and makes the person single
    public void reset(){
    	this.preference=new ArrayList<Integer> (ogPreference); 
    	this.partner=-1;
    }
    
    //returns a string representation of the person and his list
    public String toString() {
    	return name+preference; 
    }
    
}
