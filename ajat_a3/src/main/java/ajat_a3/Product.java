package ajat_a3;

import java.util.ArrayList;

/**
 *
 * @author Areesha Jat
 * Assignment 3
 * 1078815
 */

 /**
  * Superclass product
  */
  public abstract class Product {

    private String category;
    private String productId;
    private String productDescription;
    private int productYear;
    private String stringPrice;
    private double doublePrice;

    /**
     * Constructor for Product
     * @param category
     * @param productID
     * @param productDescription
     * @param productYear
     * @param doublePrice
     */
    public Product(String category, String productID, String productDescription, int productYear, double doublePrice) {
        this.category = category;
        this.productId = productID;
        this.productDescription = productDescription;
        this.productYear = productYear;
        this.doublePrice = doublePrice;
    }

    /**
     * setting doublePrice
     */
    public void setdoublePrice() {
        this.doublePrice = 0;
    }

    /**
     * setting doublePrice
     * @param doublePrice
     */
    public void setdoublePrice(double doublePrice) {
        this.doublePrice = doublePrice;
    }

    /**
     * checking if product exists
     * @ownerProductID
     * @param checking
     * @return true
     */
    public boolean isAccessible(String ownerProductID, ArrayList<Product> checking) {
        for (Product component : checking) {
            if (ownerProductID.equals(component.productId)) {
                return false;
            }
        }
        return true;
    }

    /**
     * toString method to print
     * @return
     */
     @Override
     public String toString() {
        return "type = \"" + this.category + "\"\nproductID = \"" + this.productId + "\"\nname = \"" + this.productDescription + "\"\nprice = \"" + this.doublePrice + "\"\nyear = \"" + this.productYear + "\"";
     }

     /**
      * method for productDescription
      * @param productDescription
      */
    public String ownerName() {
        return this.productDescription;
    }

    /**
     * method for checking unique productID
     * @param productID
     * @return false
     */
    public boolean sameProductID(String productID) {
        if (productID.equals(this.productId)) {

            return true;

        } else

            return false;
    }

    /**
     * method used for searching if a product is in the given range by user
     * @param LowerProductYear
     * @param UpperProductYear
     * @return false
     */
    public boolean sameProductYear(int LowerProductYear, int UpperProductYear) {
        if (this.productYear >= LowerProductYear && this.productYear <= UpperProductYear) {

            return true;

        } else {

            return false;
        }
    }

    /**
     * getting ProductID
     * @return productID
     */
    public String getproductID() {
        return this.productId;
    }

    /**
     * getting productDescription
     * @return productDescription
     */
    public String getproductDescription() {
        return this.productDescription;
    }

    /**
     * getting ProductYear
     * @return ProductYear
     */
    public int getproductYear() {
        return this.productYear;
    }
    /**
     * getting doublePrice
     * @return doublePrice
     */
    public double getdoublePrice() {
        return this.doublePrice;
    }

}
