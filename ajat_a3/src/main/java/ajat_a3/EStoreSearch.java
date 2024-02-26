package ajat_a3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Areesha Jat
 * Assignment 3
 * 1078815
 */

 public class EStoreSearch {

   /**
    *  Creating an array list (product) which stores info for book and electronic
    */
     private static ArrayList<Product> products = new ArrayList<>();
     private static Product ownerProduct;

     /**
      *  Creating an HashMap for description
      */
     private static HashMap<String, ArrayList<Integer>> productMap = new HashMap<>();

     /**
      * method for electronic adding format
      * @param electronicIDField
      * @param electronicNameField
      * @param electronicYearField
      * @param electronicPriceField
      * @param electronicAuthorField
      * @param electronicPublisherField
      * @return ownerElectronic
      */
     protected static Electronics ElectronicProductComponents(String electronicIDField, String electronicNameField, String electronicYearField, String electronicPriceField, String electronicMakerField) throws Exception {

         /* declaring variables */
         Electronics ownerElectronic;
         String [] electronicID;
         String [] priceString;
         String electronicInfo;
         double electronicPrice;
         int electronicYear;

         try {
             electronicID = electronicIDField.split("\\s+");

             /* error checking for productID being 1 word */
             if (electronicID.length > 1 || electronicID[0].equals("")) {
                 throw new Exception("The ProductID must be entered\n");
             }

             /* error checking for productID being 6 digits */
             if (electronicID[0].length() != 6) {
                 throw new Exception("The ProductID must be 6 digits\n");
             }

             /* error checking for productID being only numbers */
             if (!(electronicID[0].matches("[0-9]+"))) {
                 throw new Exception("The ProductID must only contain numbers");
             }
             electronicInfo = electronicNameField;

             /* error checking to make sure user enters a product description */
             if (electronicInfo.equals("")) {
                 throw new Exception("Description of product must be entered\n");
             }

             /* error checking to make sure user enters a product Year */
             if (electronicYearField.equals("") || electronicYearField.length() != 4) {
                 throw new Exception("Year of product must be entered\n");
             } else {
                 electronicYear = Integer.parseInt(electronicYearField);

                 /* error checking to see if year is in the range for the product Year */
                 if (electronicYear > 9999 || electronicYear < 1000) {
                     throw new Exception("Year must be between 1000 and 9999 years");
                 }
             }

             priceString = electronicPriceField.split("\\s+");
             if (priceString.length > 1 || priceString[0].equals("")) {
                 electronicPrice = 0;
             } else {
                 electronicPrice = Double.parseDouble(priceString[0]);
             }

             ownerElectronic = new Electronics(electronicID[0], electronicInfo, electronicYear, electronicPrice, electronicMakerField);
             GUILayout.Display("electronic areas are good\n");
             return ownerElectronic;
         } catch (Exception e) {
             throw new Exception(e.getMessage());
         }

     }

     /**
      * method for book adding format
      * @param bookIDField
      * @param bookNameField
      * @param bookYearField
      * @param bookPriceField
      * @param bookAuthorField
      * @param bookPublisherField
      * @return ownerBook
      */
     protected static Book BookProductComponents(String bookIDField, String bookNameField, String bookYearField, String bookPriceField, String bookAuthorField, String bookPublisherField) throws Exception{
         Book ownerBook;
         String [] bookID;
         String [] priceString;
         String bookInfo;
         double bookPrice;
         int bookYear;

         try{
             bookID = bookIDField.split("\\s+");

             /* error checking for productID being 1 word */
             if (bookID.length > 1 || bookID[0].equals("")) {
                 throw new Exception ("The ProductID must be entered\n");
             }

             /* error checking for productID being 6 digits */
             if (bookID[0].length() !=6)
                 throw new Exception ("The ProductID must be 6 digits\n");

             /* error checking for productID being only numbers */
             if (!(bookID[0].matches("[0-9]+")))
                 throw new Exception ("The ProductID must only contain numbers");
             bookInfo = bookNameField;

             /* error checking to make sure user enters a product description */
             if (bookInfo.equals(""))
                 throw new Exception ("Description of product must be entered\n");

             /* error checking to make sure user enters a product Year */
             if (bookYearField.equals("") || bookYearField.length() != 4) {
                 throw new Exception ("The ProductYear must be 4 numbers\n");
             } else {
                 bookYear = Integer.parseInt(bookYearField);

                 /* error checking to see if year is in the range for the product Year */
                 if (bookYear > 9999 || bookYear < 1000) {
                     throw new Exception ("Year must be in the range 1000 and 9999 years");
                 }
             }

             priceString = bookPriceField.split("\\s+");
             if (priceString.length > 1 || priceString[0].equals(""))
                 bookPrice = 0;
             else
                 bookPrice = Double.parseDouble(priceString[0]);

             ownerBook = new Book(bookID[0],bookInfo,bookYear,bookPrice,bookAuthorField,bookPublisherField);
             GUILayout.Display("Book areas are good\n");
             return ownerBook;
         } catch (Exception e) {
             throw new Exception (e.getMessage());
         }
     }

     /**
      * method for correct ID format
      * @param IDScan
      * @return productID[0]
      */
     protected static String productIDSearch(String IDScan) throws Exception {
         String[] productID;
         try {
             productID = IDScan.split("\\s+");

             /* error checking for productID being 1 word */
             if (productID.length > 1 ) {
                 throw new Exception("The ProductID must be entered\n");
             }

             /* error checking for productID being 6 digits */
             if (!(productID[0].equals("")) && productID[0].length() != 6) {
                 throw new Exception("The ProductID must be 6 digits\n");
             }

             /* error checking for productID being only numbers */
             if (!(productID[0].matches("[0-9]+"))) {
                 throw new Exception("The ProductID must only contain numbers");
             }
             return productID[0];
         } catch (Exception e){
             throw new Exception(e.getMessage());
         }
     }

     /**
      * method for correct Year format
      * @param YearScan
      * @return searchYear[0]
      */
     protected static String productYearSearch(String YearScan) throws Exception {
         String[] searchYear;
         try{
             searchYear = YearScan.split("\\s+");

             /* error checking to make sure year is only 1 word */
             if (searchYear.length > 1) {
                 throw new Exception("The Year must be 1 word only\n");
             }

             /* error checking to make sure user enters a product Year */
             if (!(searchYear[0].equals("")) && searchYear[0].length() !=4){
                 throw new Exception("Year entered but it is not 4 digits");
             }

              /* error checking for product Year being only numbers */
             if (!(searchYear[0].matches("[0-9]+"))) {
                 throw new Exception("Year must only contain numbers");
             }
             return searchYear[0];
         } catch (Exception e){
             throw new Exception(e.getMessage());
         }
     }

     /**
      * method for adding Electronic
      * @param AddingOn
      * @return
      */
     protected static void ElectronicComponentAdded(Electronics AddingOn) {

         /* error checking to see if product information is in correct format */
         if (AddingOn == null) {
             GUILayout.Display("Electronic was not able to be added\n");
         } else {
             try {
                 if (!(AddingOn.isAccessible(AddingOn.getproductID(), products))) {
                     GUILayout.Display("This product already exists\n");
                     return;
                 } else {
                     GUILayout.Display("New electronic Product\n");
                 }

                 ownerProduct = new Electronics(AddingOn.getproductID(), AddingOn.getproductDescription(), AddingOn.getproductYear(), AddingOn.getdoublePrice(), AddingOn.getproductMaker());
                 products.add(ownerProduct);

                 HashMapAdded(AddingOn.getproductDescription());
                 System.out.println("electronic added to everything");
                 GUILayout.clearField();
              } catch (Exception e) {
                 GUILayout.Display(e.getMessage());
             }
         }
     }

     /**
      * method for adding Book
      * @param AddingOn
      * @return
      */
     protected static void BookComponentAdded(Book AddingOn) {

         /* error checking to see if product information is in correct format */
         if (AddingOn == null)
             GUILayout.Display("Book was not able to be added\n");
         else {
             try {
                 if (!(AddingOn.isAccessible(AddingOn.getproductID(), products))) {
                     GUILayout.Display("This product already exists\n");
                     return;
                 } else
                     GUILayout.Display("New book Product\n");

                 ownerProduct = new Book(AddingOn.getproductID(), AddingOn.getproductDescription(), AddingOn.getproductYear(), AddingOn.getdoublePrice(), AddingOn.getbookAuthor(), AddingOn.getbookPublisher());
                 products.add(ownerProduct);

                 HashMapAdded(AddingOn.getproductDescription());
                 System.out.println("book added to everything");
                 GUILayout.clearField();
             } catch (Exception e){
                 GUILayout.Display(e.getMessage()+"error\n");
             }
         }
     }

     /**
      * method for adding product to HashMap
      * @param mapName
      */
     public static void HashMapAdded(String mapName) {

         mapName = mapName.toLowerCase();

         /* string splitting */
         String[] splitItup = new String[mapName.split("[ ]+").length];
         splitItup = mapName.split("[ ]+");

         for(String words : splitItup) {
             if (productMap.get(words) == null) {
                 productMap.putIfAbsent(words, new ArrayList<Integer>());
             }

             /* adding the index to array */
             productMap.get(words).add(products.size()-1);
         }
     }

     /**
      * method for specifically seaching by using only ProductID
      * @param productID
      */
     protected static void searchProductID(String productID)
     {
         for (Product component : products) {
             if (component.sameProductID(productID)) {
                 System.out.println("");
                 GUILayout.Display("\n");
                 System.out.println(component);
                 GUILayout.Display(component.toString());
             }
         }
     }

     /**
      * method for specifically searching by using only productYear
      * @param productYearLower
      * @param productYearHigher
      */
     protected static void searchProductYear(int productYearLower, int productYearHigher) {
         for (Product component : products) {
             System.out.println("productYearLower: " + productYearLower);
             System.out.println("productYearHigher: " + productYearHigher);
             if (component.sameProductYear(productYearLower, productYearHigher)) {
                 System.out.println("");
                 GUILayout.Display("\n");
                 System.out.println(component);
                 GUILayout.Display(component.toString());
             }
         }
     }

     /**
      * method for specifically searching by using only productDescription
      * @param keyForHash
      */
     protected static void HashKeySearch(String keyForHash) {

         String[] divideWords = new String[keyForHash.split("[ ]+").length];
         divideWords = keyForHash.split("[ ]+");
         System.out.println(divideWords[0]);
         for (String mainWord : divideWords) {
             mainWord = mainWord.toLowerCase();
             if (productMap.get(mainWord) != null) {
                 ArrayList<Integer> allKeyWord = (ArrayList<Integer>) productMap.get(mainWord);
                 {
                     for (int i = 0; i < allKeyWord.size(); i++) {
                         System.out.println(products.get(allKeyWord.get(i)));
                         GUILayout.Display(products.get(allKeyWord.get(i)).toString() + "\n");
                     }
                 }
             }
             if (productMap.get(mainWord) == null) {
                 System.out.println("null");
             }
         }
     }

     /**
      * method for searching using productID and productYear
      * @param productID
      * @param productYearLower
      * @param productYearHigher
      */
     protected static void searchProductYear(String productID, int productYearLower, int productYearHigher) {
         System.out.println("productYearLower: " + productYearLower);
         System.out.println("productYearHigher: " + productYearHigher);
         for (Product component : products) {
             if (component.sameProductID(productID) && component.sameProductYear(productYearLower, productYearHigher)) {
                 System.out.println(" ");
                 GUILayout.Display("\n");
                 System.out.println(component);
                 GUILayout.Display(component.toString() + "\n");
             }
         }
     }

     /**
      * method for searching using HashKey and productID
      * @keyForHash
      * @ownerProductID
      */
     protected static void HashIDKeySearch(String keyForHash, String ownerProductID) {
         String[] divideWords = new String[keyForHash.split("[ ]+").length];
         divideWords = keyForHash.split("[ ]+");
         System.out.println(divideWords[0]);
         for (String specificWord : divideWords) {
             specificWord = specificWord.toLowerCase();
             if (productMap.get(specificWord) != null) {
                 ArrayList<Integer> allKeyWord = (ArrayList<Integer>) productMap.get(specificWord);
                 {
                     for (int i = 0; i < allKeyWord.size(); i++) {
                         Product e = products.get(allKeyWord.get(i));
                         if (e.sameProductID(ownerProductID)) {
                             System.out.println(products.get(allKeyWord.get(i)));
                             GUILayout.Display(e.toString() + "\n");
                         }
                     }
                 }
             }
             if (productMap.get(specificWord) == null) {
                 System.out.println("The product searched was not found");
             }
         }
     }

     /**
      * method for searching using HashKey and productYear
      * @param keyForHash
      * @param productYearLower
      * @param productYearHigher
      */
     protected static void HashYearKeySearch(String keyForHash, int productYearLower, int productYearHigher) {
         System.out.println("Searching with search terms and year using hash");
         System.out.println("productYearLower: " + productYearLower);
         System.out.println("productYearHigher: " + productYearHigher);
         String[] divideWords = new String[keyForHash.split("[ ]+").length];
         divideWords = keyForHash.split("[ ]+");
         System.out.println(divideWords[0]);
         for (String specificWord : divideWords) {
             specificWord = specificWord.toLowerCase();
             if (productMap.get(specificWord) != null) {
                 ArrayList<Integer> allKeyWord = (ArrayList<Integer>) productMap.get(specificWord);
                 {
                     for (int i = 0; i < allKeyWord.size(); i++) {
                         Product e = products.get(allKeyWord.get(i));

                         /* if there is a product within the range and they key than print it */
                         if (e.sameProductYear(productYearLower, productYearHigher)) {
                             System.out.println(products.get(allKeyWord.get(i)));
                             GUILayout.Display(e.toString() + "\n");
                         }
                         else
                             System.out.println("Not in the year "+ keyForHash + " "+productYearLower+ " "+ productYearHigher);
                     }
                 }
             }
             if (productMap.get(specificWord) == null) {
                 System.out.println("The product searched was not found");
             }
         }
     }

     /**
      * method for seaching using HashKey, productID and productYear using different ranges for productYear
      * @keyForHash
      * @ownerProductID
      * @productYearLower
      * @productYearHigher
      */
     protected static void HashIDYearKeySearch(String keyForHash, String ownerProductID, int productYearLower, int productYearHigher) {
         System.out.println("Searching for key, productID and year using hash");
         System.out.println("productYearLower: " + productYearLower);
         System.out.println("productYearHigher: " + productYearHigher);
         String[] divideWords = new String[keyForHash.split("[ ]+").length];
         divideWords = keyForHash.split("[ ]+");
         System.out.println(divideWords[0]);
         for (String specificWord : divideWords) {
             specificWord = specificWord.toLowerCase();
             if (productMap.get(specificWord) != null) {
                 ArrayList<Integer> allKeyWord = (ArrayList<Integer>) productMap.get(specificWord);
                 {
                     for (int i = 0; i < allKeyWord.size(); i++) {
                         Product e = products.get(allKeyWord.get(i));

                         /* if there is a product within the range, key and productId than print it*/
                         if (e.sameProductID(ownerProductID) && e.sameProductYear(productYearLower, productYearHigher)) {
                             System.out.println("Printing keys, productID, and year");
                             GUILayout.Display("\n");
                             System.out.println(products.get(allKeyWord.get(i)));
                             GUILayout.Display((e.toString() + "\n"));
                         }
                     }
                 }
             }
             if (productMap.get(specificWord) == null) {
                 System.out.println("The product searched was not found");
             }
         }
     }

     /**
      * method for reading from a File
      * @param nameOfFile
      */
     public static void readingFile(String nameOfFile) {

         String categoryOfProduct, productID, productDescription, productPrice, productYear, bookAuthor, bookPublisher, productMaker;

         Scanner inputStream = null;
         try {
             inputStream = new Scanner(new FileInputStream(nameOfFile));
         } catch (FileNotFoundException e) {
             System.out.println("File not found");
         }
         String nLine = null;
         while (inputStream.hasNextLine()) {
             nLine = inputStream.nextLine();


             if (nLine.contains("type") && nLine.length() != 0) {

                 /* using substring to cut the word and get what we need */
                 categoryOfProduct = nLine.substring(8, nLine.length() - 1);

                 /* parsing productID */
                 nLine = inputStream.nextLine();
                 productID = nLine.substring(13, nLine.length() - 1);

                 /* parsing productDescription */
                 nLine = inputStream.nextLine();
                 productDescription = nLine.substring(8, nLine.length() - 1);

                 /* parsing productPrice */
                 nLine = inputStream.nextLine();
                 productPrice = nLine.substring(9, nLine.length() - 1);

                 Double productPriceDouble = 0.0;
                 try {
                     productPriceDouble = Double.parseDouble(productPrice);
                 } catch (NumberFormatException e) {
                     System.out.println("Price format is incorrect");
                 }

                 nLine = inputStream.nextLine();
                 productYear = nLine.substring(8, nLine.length() - 1);

                 int productYearInt = 0;
                 try {
                     productYearInt = Integer.parseInt(productYear);
                 } catch (NumberFormatException e) {
                     System.out.println("Price format is incorrect");
                 }

                 if (categoryOfProduct.equalsIgnoreCase("book")) {

                     nLine = inputStream.nextLine();
                     bookAuthor = nLine.substring(11, nLine.length() - 1);

                     nLine = inputStream.nextLine();
                     bookPublisher = nLine.substring(13, nLine.length() - 1);

                     try {
                         Product addProduct = new Book(productID, productDescription, productYearInt, productPriceDouble, bookAuthor, bookPublisher);

                         products.add(addProduct);

                         productDescription = productDescription.toLowerCase();

                         HashMapAdded(productDescription);

                     } catch (Exception error){
                         System.out.println(error.getMessage());
                         GUILayout.Display(error.getMessage() + "\n");
                     }


                 } else if (categoryOfProduct.equalsIgnoreCase("electronics")) {

                     nLine = inputStream.nextLine();
                     productMaker = nLine.substring(9, nLine.length() - 1);


                     try {
                         Product addProduct = new Electronics(productID, productDescription, productYearInt, productPriceDouble, productMaker);
                         products.add(addProduct);
                         productDescription = productDescription.toLowerCase();
                         HashMapAdded(productDescription);
                     } catch(Exception error) {
                         System.out.println(error.getMessage());
                         GUILayout.Display(error.getMessage() + "\n");
                     }

                 }

             }

         }
         System.out.println("Reading File: Successful");
     }

     /**
      * Method for outputting to a file when user enters informatin to a file
      * @outputFile
      */
     protected static void outputtingToFile(String outputFile) {
         System.out.println("...Outputting to file...");
         PrintWriter writerFile = null;
         try {
             writerFile = new PrintWriter(new FileOutputStream(outputFile));
         } catch (FileNotFoundException e) {
             System.out.println("File failed to open.");
             System.exit(0);
         }
         for (Product component : products) {
             writerFile.println(component);
         }
         writerFile.close();
     }

     /**
      * Method for printing the arrayList
      */
     public static void print() {
         GUILayout.Display("\n");
         for(Product component: products) {
             GUILayout.Display("\n");
             System.out.println(component);
             GUILayout.Display(component.toString());
        }
    }
}
