package ajat_a3;

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Areesha Jat
 * Assignment 3
 * 1078815
 */



public class productGUIListener {

     /**
      * method used for when user clicks add, that panel is shown
      */
     protected class displayAdding implements ActionListener{
         public void actionPerformed(ActionEvent e){
             System.out.println("Allowing product to be added");
             GUILayout.panelToDisplay("Add Product Panel");
         }
     }

     /**
      * method used for when user chooses electronic the specific
      * field productMaker will be shown and if book is chosen than
      * bookAuthor and bookPublisher will be shown
      */
     protected class specificType implements ActionListener {

         public void actionPerformed(ActionEvent e) {
             JComboBox option = (JComboBox)e.getSource();
             int productChoice = (int)option.getSelectedIndex();

             /* if user clicks the default option(book) than display book labels */
             if (productChoice == 0){
                 GUILayout.Display("Display book menu\n");
                 GUILayout.setProductOption("book");

             /* if user clicks other option(electronic) than display the electronic labels*/
             } else if(productChoice == 1){
                 GUILayout.Display("Display electronic menu\n");
                 GUILayout.setProductOption("electronic");
             }


         }
     }

     /**
      * method used to display search for when the user clicks the search
      */
     protected class displaySearch implements ActionListener{
         public void actionPerformed(ActionEvent e){
             System.out.println("Displaying search page");
             GUILayout.panelToDisplay("Search");

         }
     }

     /**
      * method used to clear all fields a search or add is done
      */
     protected class clearAllFields implements ActionListener{
         public void actionPerformed(ActionEvent e){
             System.out.println("Clearing all fields");
             GUILayout.clearField();

         }
     }

     /**
      * method used for user to click book or electronic after they
      * click the add button
      */
     protected class addingProducts implements ActionListener {

         public void actionPerformed(ActionEvent e) {
             JComboBox option = GUILayout.getspecificType();
             int productChoice = (int) option.getSelectedIndex();

             /* if user clicks the default option(book) than display book labels */
             if (productChoice == 0) {
                 System.out.println("adding book");
                 EStoreSearch.BookComponentAdded(GUILayout.getBookFormat());

             /* if user clicks other option(electronic) than display the electronic labels*/
             } else {
                 System.out.println("adding electronic");
                 EStoreSearch.ElectronicComponentAdded(GUILayout.getElectronicFormat());
             }
         }
     }

     /**
      * method used to print the ArrayList
      */
     protected class printFinal implements ActionListener{
         public void actionPerformed(ActionEvent e)
         {
             EStoreSearch.print();
         }
     }

     /**
      * method used for when the user clicks search
      * we have to figure out what information is given
      * and what isn't
      */
     protected class searchUnits implements ActionListener{
         public void actionPerformed(ActionEvent e)
         {

             if (GUILayout.getSearchProductIDField().length() !=0 && (GUILayout.getSearchLowerProductYearField().length()== 0 && GUILayout.getSearchHigherProductYearField().length() == 0)&&GUILayout.getKeywordNameField().length()==0)
             {
                 System.out.println("Search only with productID, which is "+ GUILayout.getSearchProductIDField());
                 try {

                      /* getting productID and checking if it follows the correct format than assigning */
                     String productID = EStoreSearch.productIDSearch(GUILayout.getSearchProductIDField());
                     EStoreSearch.searchProductID(productID);
                 } catch(Exception error){
                     System.out.println(error.getMessage());
                     GUILayout.Display(error.getMessage() + "\n");
                 }
             }

             /* if only year label is filled */
             else if (GUILayout.getSearchProductIDField().length() == 0 && (GUILayout.getSearchLowerProductYearField().length()!= 0 || GUILayout.getSearchHigherProductYearField().length() != 0)&&GUILayout.getKeywordNameField().length()==0)
             {
                 System.out.println("Search only with the product year, which is " + GUILayout.getSearchLowerProductYearField() + " "+GUILayout.getSearchHigherProductYearField());

                 try{
                     int productYearLower;
                     int productYearHigher;
                     String productYearLowerString = "";
                     String productYearHigherString = "";

                     if(GUILayout.getSearchLowerProductYearField().length()== 0)
                        productYearLower = 1000;
                     else
                     {
                        productYearLowerString = EStoreSearch.productYearSearch(GUILayout.getSearchLowerProductYearField());

                        /* lower year */
                        productYearLower = Integer.parseInt(productYearLowerString);
                     }
                     if(GUILayout.getSearchHigherProductYearField().length() == 0)
                         productYearHigher = 9999;
                     else {
                         productYearHigherString = EStoreSearch.productYearSearch(GUILayout.getSearchHigherProductYearField());

                         /* higher year */
                         productYearHigher = Integer.parseInt(productYearHigherString);
                     }

                     System.out.println("year lower " + productYearLower);

                     System.out.println("year higher" + productYearHigher);

                     EStoreSearch.searchProductYear(productYearLower, productYearHigher);
                 } catch(Exception error){
                     System.out.println(error.getMessage());
                     GUILayout.Display(error.getMessage() + "\n");
                 }

             }

             /* year range and keys */
             else if (GUILayout.getSearchProductIDField().length() == 0 && (GUILayout.getSearchLowerProductYearField().length() == 0 && GUILayout.getSearchHigherProductYearField().length() == 0) && GUILayout.getKeywordNameField().length() != 0)
             {
                 System.out.println("Search only with terms searched, which are "+ GUILayout.getKeywordNameField());
                 try{
                     EStoreSearch.HashKeySearch(GUILayout.getKeywordNameField());
                 } catch(Exception error){
                     System.out.println(error.getMessage());
                     GUILayout.Display(error.getMessage() + "\n");
                 }
             }

             else if (GUILayout.getSearchProductIDField().length() != 0 && (GUILayout.getSearchLowerProductYearField().length() != 0 || GUILayout.getSearchHigherProductYearField().length() != 0) && GUILayout.getKeywordNameField().length() == 0)
             {
                 System.out.println("Search only with productID and product year range, which is " + GUILayout.getSearchProductIDField() + " "+GUILayout.getSearchLowerProductYearField() + " -  " + GUILayout.getSearchHigherProductYearField());

                 try{
                     String productID = EStoreSearch.productIDSearch(GUILayout.getSearchProductIDField());
                     int productYearLower;
                     int productYearHigher;
                     String productYearLowerString = "";
                     String productYearHigherString = "";

                     if (GUILayout.getSearchLowerProductYearField().length() == 0) {
                         productYearLower = 1000;
                     } else {
                         productYearLowerString = EStoreSearch.productYearSearch(GUILayout.getSearchLowerProductYearField());

                         /* lower year */
                         productYearLower = Integer.parseInt(productYearLowerString);
                     }
                     if (GUILayout.getSearchHigherProductYearField().length() == 0) {
                         productYearHigher = 9999;
                     } else {
                         productYearHigherString = EStoreSearch.productYearSearch(GUILayout.getSearchHigherProductYearField());

                         /* higher year */
                         productYearHigher = Integer.parseInt(productYearHigherString);
                     }

                     EStoreSearch.searchProductYear(productID, productYearLower, productYearHigher);
                 }catch (Exception error){
                     System.out.println(error.getMessage());
                     GUILayout.Display(error.getMessage() + "\n");
                 }

             }

             else if (GUILayout.getSearchProductIDField().length() != 0 && (GUILayout.getSearchLowerProductYearField().length() == 0 && GUILayout.getSearchHigherProductYearField().length() == 0) && GUILayout.getKeywordNameField().length() != 0)
             {
                 System.out.println("search with ID and search terms and which are " + GUILayout.getSearchProductIDField() + " " + GUILayout.getKeywordNameField());
                 GUILayout.Display("search with ID and search terms and which are " + GUILayout.getSearchProductIDField() + " " + GUILayout.getKeywordNameField() + "\n");

                 try{
                     String productID = EStoreSearch.productIDSearch(GUILayout.getSearchProductIDField());
                     EStoreSearch.HashIDKeySearch(GUILayout.getKeywordNameField(), productID);

                 }catch(Exception error){
                     System.out.println(error.getMessage());
                     GUILayout.Display(error.getMessage() + "\n");
                 }

             }

             else if (GUILayout.getSearchProductIDField().length() == 0 && (GUILayout.getSearchLowerProductYearField().length() != 0 || GUILayout.getSearchHigherProductYearField().length() != 0) && GUILayout.getKeywordNameField().length() != 0)
             {
                 System.out.println("Search with product year range and key-terms " + GUILayout.getSearchLowerProductYearField()+ " "+ GUILayout.getSearchHigherProductYearField()+ " " + GUILayout.getKeywordNameField());

                 try{
                     int productYearLower;
                     int productYearHigher;
                     String productYearLowerString = "";
                     String productYearHigherString = "";

                     if (GUILayout.getSearchLowerProductYearField().length() == 0) {

                         /* lewer Year */
                         productYearLower = 1000;
                     } else {
                         productYearLowerString = EStoreSearch.productYearSearch(GUILayout.getSearchLowerProductYearField());
                         productYearLower = Integer.parseInt(productYearLowerString);
                     }
                     if (GUILayout.getSearchHigherProductYearField().length() == 0) {

                         /* higher Year */
                         productYearHigher = 9999;
                     } else {
                         productYearHigherString = EStoreSearch.productYearSearch(GUILayout.getSearchHigherProductYearField());
                         productYearHigher = Integer.parseInt(productYearHigherString);
                     }

                     EStoreSearch.HashYearKeySearch(GUILayout.getKeywordNameField(), productYearLower, productYearHigher);
                 } catch (Exception error){
                     System.out.println(error.getMessage());
                     GUILayout.Display(error.getMessage() + "\n");
                 }
             }

             else if (GUILayout.getSearchProductIDField().length() != 0 && (GUILayout.getSearchLowerProductYearField().length() != 0 || GUILayout.getSearchHigherProductYearField().length() != 0) && GUILayout.getKeywordNameField().length() != 0)
             {
                 System.out.println("searching");
                 try{
                     String productID = EStoreSearch.productIDSearch(GUILayout.getSearchProductIDField());
                     int productYearLower;
                     int productYearHigher;
                     String productYearLowerString = "";
                     String productYearHigherString = "";

                     if (GUILayout.getSearchLowerProductYearField().length() == 0) {

                         /* lewer Year */
                         productYearLower = 1000;
                     } else {
                         productYearLowerString = EStoreSearch.productYearSearch(GUILayout.getSearchLowerProductYearField());
                         productYearLower = Integer.parseInt(productYearLowerString);
                     }
                     if (GUILayout.getSearchHigherProductYearField().length() == 0) {

                         /* higher Year */
                         productYearHigher = 9999;
                     } else {
                         productYearHigherString = EStoreSearch.productYearSearch(GUILayout.getSearchHigherProductYearField());
                         productYearHigher = Integer.parseInt(productYearHigherString);
                     }
                     EStoreSearch.HashIDYearKeySearch(GUILayout.getKeywordNameField(), productID, productYearLower, productYearHigher);
                 } catch(Exception error){
                     System.out.println(error.getMessage());
                     GUILayout.Display(error.getMessage() + "\n");
                 }
             }
             else if (GUILayout.getSearchProductIDField().length() == 0 && (GUILayout.getSearchLowerProductYearField().length() == 0 || GUILayout.getSearchHigherProductYearField().length() == 0) && GUILayout.getKeywordNameField().length() == 0)
             {
                 EStoreSearch.print();
             }

             System.out.println("You have chosen to do a search");

         }
     }

     /**
      * method used to clear all fields a search or add is done
      */
     protected class completeProgram implements ActionListener{
         public void actionPerformed(ActionEvent e) {
             System.exit(0);
         }
     }

     /**
      * method used for when user clicks the x button
      * the information is written to a file
      */
     protected class securlyCompleteProgram implements WindowListener {
         public void windowOpened(WindowEvent e) {

         }
         public void windowClosing(WindowEvent e)
         {
             System.exit(0);
         }
         public void windowClosed(WindowEvent e) {

         }
         public void windowIconified(WindowEvent e) {

         }
         public void windowDeiconified(WindowEvent e) {

         }
         public void windowActivated(WindowEvent e) {

         }
         public void windowDeactivated(WindowEvent e) {

         }
     }

 }
