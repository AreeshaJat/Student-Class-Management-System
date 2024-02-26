package ajat_a3;

/**
 *
 * @author Areesha Jat
 * Assignment 3
 * 1078815
 */
public class Electronics extends Product{

    /* Characteristic of the electronic which is not in the characteristic of book */
    private String productMaker;

    /**
    * Creating a electronic constructor
    * @param productID
    * @param productDescription
    * @param productYear
    * @param productPrice
    * @param productMaker
    */
    public Electronics(String productID, String productDescription, int productYear, double productPrice, String productMaker) {
        super("electronics",productID, productDescription, productYear, productPrice);
        this.productMaker = productMaker;
    }

    /**
     * getting ProductMaker
     * @return getProductMaker
     */
    public String getproductMaker() {
        return this.productMaker;
    }

    /**
     * Overriding method for electronic
     */
    @Override
    public String toString() {
        return super.toString() + "\nmaker = \"" + this.productMaker + "\"\n";
    }

    /**
     * method used to tell whether it is equal or not
     */
    public void Equals() {

    }
}
