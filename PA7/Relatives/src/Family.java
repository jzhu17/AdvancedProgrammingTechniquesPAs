/* Julia Zhu 
 * PA#7 Part I
 * COSI 12B Section 1 
 * Description: This program creates a Family class with info of members  
*/

import java.util.*;

public class Family {

	public ArrayList<Person> members; //Members are stores in an ArrayList  
	
	public Family() { //constructs a new family 
		members=new ArrayList<Person>(); 
	}
	
	public void setMembers(Person member) { //adds member to the family with the person's name 
		members.add(member);
	}
	
	public ArrayList<Person> getMembers() { //returns members in the family 
		return members;
	}
	
	public Person getOneMember(String name) { //returns the member as a Person given the member's name 
		Person aMember=null;
		for (Person member: members) {
			if (member.getName().equals(name)) {
				aMember = member;
			}
		}
		return aMember;
	}
	
	public boolean isAMember(String name) { //checks if the given name is a member of the family 
		for (Person member: members) {
			if (member.getName().equals(name)) { 
				return true;
			}
		}
		return false;
	}
}
