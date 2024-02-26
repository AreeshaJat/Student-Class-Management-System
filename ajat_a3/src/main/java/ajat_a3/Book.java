package ajat_a3;

/**
 *
 * @author Areesha Jat
 * Assignment 3
 * 1078815
 */
public class Book extends Product {

    /* Characteristic of the book which is not in the characteristic of electronic */
    private String bookAuthor;
    private String bookPublisher;

    /**
    * Creating a book constructor
    * @param productID
    * @param productDescription
    * @param productYear
    * @param productPrice
    * @param bookAuthor
    * @param bookPublisher
    */
    public Book(String productID, String productDescription, int productYear, double productPrice, String bookAuthor, String bookPublisher) {
        super("book",productID, productDescription, productYear, productPrice);
        this.bookAuthor = bookAuthor;
        this.bookPublisher = bookPublisher;
    }

    /**
     * getting bookAuthor
     * @return bookAuthor
     */
    public String getbookAuthor() {
        return this.bookAuthor;
    }

    /**
     * getting bookPublisher
     * @return bookPublisher
     */
    public String getbookPublisher() {
        return this.bookPublisher;
    }

    /**
     * Overriding method for book
     */
    @Override
    public String toString() {
        return super.toString()+ "\nauthor = \"" + this.bookAuthor + "\"\npublisher = \"" + this.bookPublisher + "\"\n";
    }

    /**
     * method used to tell whether it is equal or not
     */
    public void Equals() {

    }

}
