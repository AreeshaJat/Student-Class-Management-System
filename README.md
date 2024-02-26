# Student-Class-Management-System
/**
* @author Areesha Jat
* @version December 1, 2020
* Student Number: 1078815
* Assignment 3
*/

# General Problem
The purpose of this assignment was to create a GUI EStoreSearch program. This program has 3 different panels which are "Add Product", "Search Product" and "Quit" for
products book and electronics. When the user clicks the add panel, the default product will be book and the user will adjust the product according to their liking.
After they do that, they will labels according to the product. Than they will input information for the product. If the user continued to enter a new product, the
product will be added to the array list for product. After the user inputs the add information, they have the option to search for a product. In search they will
be able to enter information for productID, product description, product start year or product end year. Based on the information the user enters, if there is a match
than the program outputs the match and if there is no match than the program prints it to the user. The last option the user has is quit. This allows the user to exit
out of the gui and end the program.

# Assumptions
An assumption which was made for this assignment was the file had to be in a certain format for the products book and electronics. This format was:
type = “book”
productID = “000025”
description= “Absolute Java”
price = “199.95”
year = “2015”
authors = “Walter Savitch, Kenrich Mock”
publisher= “Pearson”
type = “electronics”
productID = “000107"
description= “MacBook Air 11” Intel Dual-Core i5 1.6GHz”
price = “1099.99”
year = “2013”
maker= “Apple Inc.”

Another assumption was that the user can only enter the characteristics that I have made and they cannot add their own characteristics.

# Limitations
There was only 1 limitations for the program that I made. This was that when the user wanted to add information about a product they had to enter 3 pieces of information which was
productID, product description and product year. So the user must know these 3 pieces of information if they wanted to add a product.

# Test Plan
I tested my program in multiple ways to make sure that I don't get any type of error when running the program. The list consists of
-Putting in a string for the year instead of numbers which caused me to get an exception in the main and I fixed that by adding a try-catch method.
-when I was getting logic errors, I put printf statements to test my code and see what values were actually being passed.
-Added a try-catch method for unique productID which did not allow the user enter duplicate productID's.

# How to test the program
In order to run the program the user must be in the correct directory. After that they need to type the command "gradle build" and than enter "gradle run". Then the program will start
running and the user will enter input accordingly. If the user enters the wrong inputs an error will appear and they will have to re-enter an input. To test with the files we do
"grade build" and then "grade run --args='outFile.txt'"
