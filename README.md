# Collections

Task 1

Create the package named by.gsu.epamlab for entities classes of two types (see 
the task inheritance1):  
– superclass, describing a product purchase Purchase, 
– subclass for a purchase with a price discount PricePurchase. 
A file in.csv contains a series of ​correct text lines. Every odd line contains a set of values separated by a semicolon and corresponds to a single object of a superclass or a subclass depending on values number in the line. Every even line contains a weekday of the purchase defined by mprevious odd line. 
Two purchases are equal if they have the same names and prices. 
Define the Runner class in the default package.  
The algorithm of the method main( ): 
1. load the content of the file in.csv into ​the map where a purchase is a key and a weekday of last purchase is a value; 
2. print the map by for–each cycle; 
3. load the content of the file in.csv into ​the map where a purchase is a key and a weekday of first purchase is a value; 
4. print the map by for–each cycle; 
5. find the first and the last weekdays for bread with price 1.55; 
6. find the first weekday for bread with price 1.70​; 
7. remove all entries from the first map where the purchase name is meat; 
8. remove all entries from the second map on FRIDAY​; 
9. print maps by for–each cycle; 
10.load instances of the subclass ​PricePurchase from the file in.csv into the list (List<PricePurchase>); 
11.print the total cost of these purchases; 
12.load the content of the file in.csv into the enumerated map where a weekday is a key and purchases list for this weekday is a value; 
13.print the map by for–each cycle; 
14.print the total cost of all purchases for each weekday; 
15.find all purchases on MONDAY
