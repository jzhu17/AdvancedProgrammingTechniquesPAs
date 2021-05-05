-Name: Julia Zhu 
-Date: 04/23/17
-HW: PA7
-Description: 
		In Part I of my program, I created a Person class and a Family class. The Person class
	keeps track of mother, father and children of a specific person, and the family class
	keeps track of an ArrayList of Person (family members). I chose to follow the suggested 
	design hints because this way I can access the info of a person very quickly. 
		In my Person class, I created several methods to set the mother, father and kids of 
	the person, and also methods to get the mother, father and kids of this person. Kids is 
	an LinkedList of Strings as Queue so that it's to get each kid in client code. 
		In my Family class, I created an ArrayList of Person to store the members of the family. 
	I have a method for adding members to the family, a method for getting one member from 
	the family with a given name and a method for getting all members from the family. The last 
	method returns a boolean indicating whether the given name is a member of the family. 
		In my client code, i first go through the text file and store each member and his/her 
	info in the readFile method. I ask the user for a given name in the ask4Name method, and then
	call the two recursive methods printDecsendants and printAncestors to print out the relatives
	of this given member. 
	
		In Part II of my program,  I prompt the user for a number of discs and call the recursive 
	method that prints out the solution for the given number of discs. The discs first go from the 
	start tower to the spare tower, and then from the spare tower to the end tower.  