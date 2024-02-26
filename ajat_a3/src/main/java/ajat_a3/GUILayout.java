package ajat_a3;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author Areesha Jat
 * Assignment 3
 * 1078815
 */

 public class GUILayout extends JFrame{
     productGUIListener listen = new productGUIListener();

     /* declaring variables for the GUI Panels */
     private static JPanel layoutPanel, mainPanel, addingProductPanel, differentButtonsPanel, lowerPart, searchingPanel, searchingHalfPanel, inputingHalfPanel;
     private static JTextArea displayScreen;
     private static JComboBox chooseType;

     /* declaring variables for book and electronic */
     private static JLabel bookAuthorLabel, bookPublisherLabel, makerLabel;
     private static JTextField productIDField, productNameField, productYearField, productPriceField, bookAuthorField, bookPublisherField, makerField, searchProductIDField, searchProductNameField, searchLowerProductYearField,searchHigherProductYearField;

     /**
      * Constructor for GUILayout
      */
     public GUILayout()
     {
         super();
         this.setTitle("EStoreSearch");
         this.setSize(700, 1200);
         this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
         this.setLayout(new GridLayout(2,1));

         displayScreen();
         upperHalfOfGUI();
         mainWindow();
     }

     /**
      * method for making the panels and display
      */
     private void displayScreen(){
         layoutPanel = new JPanel();
         displayScreen = new JTextArea(20,50);
         displayScreen.setEditable(false);

         JScrollPane textScrolling = new JScrollPane(displayScreen);
         textScrolling.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
         textScrolling.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

         /* text scrolling area in the layout panel*/
         layoutPanel.add(textScrolling);
     }

     /**
      * method for displaying the upperHalfOfGUI with panels for adding and searching
      */
     private void upperHalfOfGUI(){

         /* greeting, search and add in this Panel */
         mainPanel = new JPanel();
         mainPanel.setBackground(Color.blue);
         mainPanel.setLayout(new CardLayout());

         /* different button layouts in this Panel */
         differentButtonsPanel = new JPanel();
         differentButtonsPanel.setLayout(new CardLayout());

         GridBagConstraints items = new GridBagConstraints();

         JMenu menuOfBranch = new JMenu("Command");

         /* allwoing the add panel to come up */
         JMenuItem addingProduct = new JMenuItem("Add Product");
         addingProduct.addActionListener(listen.new displayAdding());
         menuOfBranch.add(addingProduct);

         /* allowing the search panel to come up */
         JMenuItem searchProduct = new JMenuItem("Search Product");
         searchProduct.addActionListener(listen.new displaySearch());
         menuOfBranch.add(searchProduct);

         /* allowing user to end program when they click this */
         JMenuItem quitProduct = new JMenuItem("Quit Program");
         quitProduct.addActionListener(listen.new completeProgram());
         menuOfBranch.add(quitProduct);

         JMenuBar bar = new JMenuBar();
         bar.add(menuOfBranch);
         setJMenuBar(bar);

         JPanel greetingPanel = new JPanel();
         greetingPanel.setLayout(new GridBagLayout());

         JLabel greeting = new JLabel("Welcome to eStoreSearch");
         greeting.setBorder(new EmptyBorder(0,0,25,0));
         items.gridx = 0;
         items.gridy = 0;
         greetingPanel.add(greeting,items);
         items.gridx = 0;
         items.gridy = 1;

         JLabel greeting2 = new JLabel("Choose a command from the \"commands\" menu above for");
         greetingPanel.add(greeting2,items);
         mainPanel.add(greetingPanel);

         JLabel greeting3 = new JLabel("adding a product, searching products, quitting the program ");

         items.gridx = 0;
         items.gridy = 2;
         greetingPanel.add(greeting3,items);
         addingProductPanel = new JPanel();
         addingProductPanel.setLayout(new GridBagLayout());

         /* adding the labels with these attributes */
         JLabel categoryLabel = new JLabel("Type: ");
         items.anchor = GridBagConstraints.CENTER;
         items.gridx = 0;
         items.gridy = 0;
         addingProductPanel.add(categoryLabel,items);

         /* labels for Book or Electronic */
         String[] itemTypes = {"Book","Electronic"};
         chooseType = new JComboBox(itemTypes);
         chooseType.setSelectedIndex(0);
         chooseType.addActionListener(listen.new specificType());
         items.gridx = 1;
         items.gridy = 0;
         addingProductPanel.add(chooseType,items);

         JButton allowBook= new JButton("Book");
         allowBook.addActionListener(listen.new displaySearch());
         chooseType.add(allowBook);

         JLabel productIDLabel = new JLabel("ID:",JLabel.LEADING);
         productIDLabel.setBorder(new EmptyBorder(5,5,5,5));
         productIDField = new JTextField(10);
         items.gridx = 0;
         items.gridy = 1;
         addingProductPanel.add(productIDLabel,items);
         productIDLabel.setLabelFor(productIDField);
         items.gridx = 1;
         items.gridy = 1;
         addingProductPanel.add(productIDField,items);

         JLabel productNameLabel = new JLabel("Description:", JLabel.LEADING);
         productNameLabel.setBorder(new EmptyBorder(5,5,5,5));
         productNameField = new JTextField(10);
         items.gridx = 0;
         items.gridy = 2;
         addingProductPanel.add(productNameLabel,items);
         productNameLabel.setLabelFor(productNameField);

         items.gridx = 1;
         items.gridy = 2;
         addingProductPanel.add(productNameField,items);

         JLabel productYearLabel = new JLabel("year:", JLabel.LEADING);
         productYearLabel.setBorder(new EmptyBorder(5,5,5,5));
         productYearField = new JTextField(10);

         items.gridx = 0;
         items.gridy = 3;
         addingProductPanel.add(productYearLabel,items);
         productYearLabel.setLabelFor(productYearField);

         items.gridx = 1;
         items.gridy = 3;
         addingProductPanel.add(productYearField,items);

         JLabel productPriceLabel = new JLabel("price:", JLabel.LEADING);
         productPriceLabel.setBorder(new EmptyBorder(5,5,5,5));
         productPriceField= new JTextField(10);

         items.gridx = 0;
         items.gridy = 4;
         addingProductPanel.add(productPriceLabel,items);
         productPriceLabel.setLabelFor(productPriceField);

         items.gridx = 1;
         items.gridy = 4;
         addingProductPanel.add(productPriceField,items);

         bookAuthorLabel = new JLabel("author:");
         bookAuthorLabel.setBorder(new EmptyBorder(5,5,5,5));
         bookAuthorField = new JTextField(10);

         items.gridx = 0;
         items.gridy = 5;
         addingProductPanel.add(bookAuthorLabel,items);
         bookAuthorLabel.setLabelFor(bookAuthorField);

         items.gridx = 1;
         items.gridy = 5;
         addingProductPanel.add(bookAuthorField,items);

         bookPublisherLabel = new JLabel("publisher:");
         bookPublisherLabel.setBorder(new EmptyBorder(5,5,5,5));
         bookPublisherField = new JTextField(10);

         items.gridx = 0;
         items.gridy = 6;
         addingProductPanel.add(bookPublisherLabel,items);
         bookPublisherLabel.setLabelFor((bookPublisherField));

         items.gridx = 1;
         items.gridy = 6;
         addingProductPanel.add(bookPublisherField,items);

         makerLabel = new JLabel("maker:");
         makerLabel.setBorder(new EmptyBorder(5,5,5,5));
         makerField = new JTextField(10);

         items.gridx = 0;
         items.gridy = 7;
         addingProductPanel.add(makerLabel,items);
         makerLabel.setLabelFor(makerField);

         items.gridx = 1;
         items.gridy = 7;
         addingProductPanel.add(makerField,items);
         makerLabel.setVisible(false);
         makerField.setVisible(false);

         lowerPart = new JPanel();
         lowerPart.setLayout(new GridBagLayout());

         JButton productButton = new JButton("add");
         productButton.addActionListener(listen.new addingProducts());
         items.gridwidth = 1;
         items.gridx = 0;
         items.gridy = 0;
         lowerPart.add(productButton,items);

         JButton printout = new JButton("print all information");
         printout.addActionListener(listen.new printFinal());
         items.gridx = 0;
         items.gridy = 1;
         lowerPart.add(printout,items);

         JButton addResettingButton = new JButton("reset");
         addResettingButton.addActionListener(listen.new clearAllFields());
         items.gridx = 0;
         items.gridy = 2;
         lowerPart.add(addResettingButton,items);

         /* addingbutton to half of the acreen */
         differentButtonsPanel.add(lowerPart, "addHalf");
         differentButtonsPanel.setVisible(false);
         mainPanel.add(addingProductPanel, "Add Product Panel");
         searchingPanel = new JPanel();
         searchingPanel.setLayout(new GridBagLayout());

         JLabel searchProductIDLabel = new JLabel("ID:");
         searchProductIDLabel.setBorder(new EmptyBorder(5,5,5,5));
         searchProductIDField = new JTextField(6);
         items.gridx = 0;
         items.gridy = 0;
         searchingPanel.add(searchProductIDLabel,items);
         searchProductIDLabel.setLabelFor(searchProductIDField);
         items.gridx = 1;
         items.gridy = 0;
         searchingPanel.add(searchProductIDField,items);

         JLabel searchProductNameLabel = new JLabel("Description:");
         searchProductNameLabel.setBorder(new EmptyBorder(5,5,5,5));
         searchProductNameField = new JTextField(10);
         items.gridx = 0;
         items.gridy = 1;
         searchingPanel.add(searchProductNameLabel,items);
         searchProductNameLabel.setLabelFor(searchProductNameField);
         items.gridx = 1;
         items.gridy = 1;
         searchingPanel.add(searchProductNameField,items);

         JLabel searchLowerProductYearLabel = new JLabel("Start Year:");
         searchLowerProductYearLabel.setBorder(new EmptyBorder(5,5,5,5));
         searchLowerProductYearField = new JTextField(10);
         items.gridx = 0;
         items.gridy = 2;
         searchingPanel.add(searchLowerProductYearLabel,items);
         searchLowerProductYearLabel.setLabelFor(searchLowerProductYearField);
         items.gridx = 1;
         items.gridy = 2;
         searchingPanel.add(searchLowerProductYearField,items);

         JLabel searchHigherProductYearLabel = new JLabel("End Year:");
         searchHigherProductYearLabel.setBorder(new EmptyBorder(5,5,5,5));
         searchHigherProductYearField = new JTextField(10);
         items.gridx = 0;
         items.gridy = 3;
         searchingPanel.add(searchHigherProductYearLabel,items);
         items.gridx = 1;
         items.gridy = 3;
         searchingPanel.add(searchHigherProductYearField,items);

         /* Search button panels */
         searchingHalfPanel = new JPanel();
         searchingHalfPanel.setLayout(new GridBagLayout());
         JButton searchButton = new JButton("Search");
         searchButton.addActionListener(listen.new searchUnits());
         items.gridx = 0;
         items.gridy = 0;
         searchingHalfPanel.add(searchButton,items);

         JButton searchResettingButton = new JButton("Reset");
         searchResettingButton.addActionListener(listen.new clearAllFields());
         items.gridx = 0;
         items.gridy = 1;

         searchingHalfPanel.add(searchResettingButton,items);
         differentButtonsPanel.add(searchingHalfPanel, "searchHalf");

         mainPanel.add(searchingPanel,"Search");
     }

     /**
      * method for making the mainWindow and bringing everything together
      */
     private void mainWindow(){

         GridBagConstraints items = new GridBagConstraints();

         /* for the upper part */
         inputingHalfPanel = new JPanel();
         inputingHalfPanel.setLayout(new GridBagLayout());
         items.gridwidth = 3;

         items.gridx = 0;
         items.gridy = 0;

         inputingHalfPanel.add(mainPanel);

         items.gridwidth = 1;
         items.gridx = 3;
         items.gridy = 0;

         inputingHalfPanel.add(differentButtonsPanel);

         this.add(inputingHalfPanel);

         /* message panel */
         this.add(layoutPanel);
     }

     /**
      * method to check which specific product is chosen (electronic or book)
      * @return chooseType
      */
     protected static JComboBox getspecificType() {

         return chooseType;

     }

     /**
      * method to check if the correct format is used for electronic
      * @return null
      */
     protected static Electronics getElectronicFormat() {

         Display("searching for electronic\n");
         System.out.println("getting electronic");

         try {

             Electronics ownerElectronic = EStoreSearch.ElectronicProductComponents(productIDField.getText(), productNameField.getText(), productYearField.getText(), productPriceField.getText(), makerField.getText());
             return ownerElectronic;

         } catch(Exception e){

             System.out.println(e.getMessage());
             Display(e.getMessage());

         }

         return null;
     }

     /**
      * method to check if the correct format is used for book
      * @return null
      */
     protected static Book getBookFormat() {

         try{

             Book ownerBook = EStoreSearch.BookProductComponents(productIDField.getText(), productNameField.getText(), productYearField.getText(), productPriceField.getText(), bookAuthorField.getText(), bookPublisherField.getText());
             return ownerBook;
         } catch(Exception e){

             System.out.println(e.getMessage());
             Display(e.getMessage());
         }

         return null;
     }

     /**
      * method used to call the searchProductIFField method when searching
      * @return searchProductIDField.getText()
      */
     protected static String getSearchProductIDField() {

         return searchProductIDField.getText();

     }

     /**
      * method used to call the searchLowerProductYearField method when searching
      * @return searchLowerProductYearField.getText()
      */
     protected static String getSearchLowerProductYearField() {

         return searchLowerProductYearField.getText();

     }

     /**
      * method used to call the searchHigherProductYearField method when searching
      * @return searchHigherProductYearField.getText()
      */
     protected static String getSearchHigherProductYearField() {

         return searchHigherProductYearField.getText();

     }

     /**
      * method used to display search or add depending on what user clicks
      * @param showThisCard
      */
     protected static void panelToDisplay(String showThisCard) {

         /* panel layout for card */
         CardLayout cardLayoutPanel = (CardLayout) (mainPanel.getLayout());

         /* panel layout for button */
         CardLayout buttonLayoutPanel = (CardLayout) (differentButtonsPanel.getLayout());

         /* showing search panel if user clicks search */
         if (showThisCard.equalsIgnoreCase("Search")) {

             GUILayout.Display("Please enter search criteria");
             cardLayoutPanel.show(mainPanel, showThisCard);
             buttonLayoutPanel.show(differentButtonsPanel, "searchingHalf");

         /* showing add panel otherwise */
         } else {

             cardLayoutPanel.show(mainPanel, showThisCard);
             buttonLayoutPanel.show(differentButtonsPanel, "addingHalf");
         }


         cardLayoutPanel.show(mainPanel, showThisCard);
         differentButtonsPanel.setVisible(true);
     }

     /**
      * method used to display the specific attributes
      * for when user clicks electronic or book
      * @param showThisCard
      */
     protected static void setProductOption(String productToShow){
         if (productToShow.equals("book")) {
             bookAuthorLabel.setVisible(true);
             bookAuthorField.setVisible(true);

             bookPublisherLabel.setVisible(true);
             bookPublisherField.setVisible(true);

             makerLabel.setVisible(false);
             makerField.setVisible(false);
         }
         else if (productToShow.equalsIgnoreCase("electronic")) {

             makerLabel.setVisible(true);
             makerField.setVisible(true);

             bookAuthorLabel.setVisible(false);
             bookAuthorField.setVisible(false);

             bookPublisherLabel.setVisible(false);
             bookPublisherField.setVisible(false);
         }
     }

     /**
      * method used to clear the fields
      */
     protected static void clearField() {

         productIDField.setText("");
         productNameField.setText("");
         productYearField.setText("");
         productPriceField.setText("");

         bookAuthorField.setText("");
         bookPublisherField.setText("");

         makerField.setText("");

         searchProductIDField.setText("");
         searchProductNameField.setText("");
         searchLowerProductYearField.setText("");
         searchHigherProductYearField.setText("");

     }

     /**
      * method used to call the searchProductNameField to get
      * productDescription
      */
     protected static String getKeywordNameField() {

         return searchProductNameField.getText();

     }

     /**
      * method used to display the Text area
      * @printFinalResult
      */
     protected static void Display(String printFinalResult) {

         displayScreen.append(printFinalResult);

     }

 }
