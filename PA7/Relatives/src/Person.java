/* Julia Zhu 
 * PA#7 Part I
 * COSI 12B Section 1 
 * Description: This program creates a Person class with info about name, mother, father and kids 
*/

import java.util.*;

public class Person {
    public String name;  
    public String mother; 
    public String father; 
    public Queue<String> kids; 
    
    public Person(String name) { //constructs a person with given name 
    	this.name=name; 
    	this.mother=null;
    	this.father=null;
    	this.kids=new LinkedList<String>();
    }
    
    public void setMother (String mother) { //sets the mother with given mother's name 
    	this.mother=mother;
    }
    
    public void setFather (String father) { //sets the father with given father's name 
    	this.father=father;
    }
    
    public void setKids (String kid) { //sets kids with the given kid's name 
    	this.kids.add(kid);
    }
    
    public String getName() { //returns the name of the person 
    	return name;
    }
    
    public String getMother() { //returns the name of the mother 
    	return  mother;
    }
    
    public String getFather() { //returns the name of the father 
    	return father;
    }
    
    public Queue<String> getKids() { //returns the LinkedList of kids
    	return kids;
    }
}
