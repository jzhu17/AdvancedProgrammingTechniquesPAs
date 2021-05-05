-Name: Julia Zhu 
-Date: 03/16/17
-HW: PA4 #2
-Description: 
	The program of part 2 is designed to create an Item class, a Catalog class, an ItemOrder class
and a ShoppingCart class that interact with the ShoppingFrame and the ShoppingMain files provided 
by the professor. 
	In the Item class, an Item object could be created and modified. It can be constructed with a 
name and a price (and bulk price and bulk quantity if applicable). There's also a priceFor method
that returns the price of an Item, a toString method and a getName method that returns the name 
of the Item. 
	In the Catalog class, an ArrayList of Items could be created and modified using the Catalog 
constructor. There's an add method that adds items at the end of the list, a size method that
returns number of items in the Catalog, a get method that returns an Item with a given index 
and a getName method that returns the name of the catalog. 
	The ItemOrder class implements the Comparable interface and a compareTo method so that the 
ItemOrders in the ShoppingCart can be sorted using the sort method in the Collections class. 
An ItemOrder is constructed with an Item and a quantity and can be modified with a getPrice 
method that returns the cost for the item order, a getItem method that returns the Item and a
toString method. 
	The ShoppingCart class creates and modifies an ArrayList of ItemOrders. A ShoppingCart 
could be modified with an add method that adds an item to the list, a setDiscount method 
that sets a boolean that represents whether the order get a 90% discount, a getTotal method 
that returns the total cost, a sortCart method that sorts the ItemOrders in the cart, and 
a toString method. 
	What the program actually does has met the purpose of the design. When the program is run, 
a Catalog of items will be displayed and the user can decide the amount of each item to buy. 
The selected items will be sorted and printed on the console window, and a 10% off% discount 
will be applied if the user clicked the qualify for discount button. 
