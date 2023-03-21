package entity;

/**
 * @author Huynh Huu Nghia - CE160343 
 */
public class Product {

    private int ID;             // Product ID
    private String title;       // Product title
    private int importPrice;    // Import price of product
    private int price;          // Saleprice of product
    private int salePercent;    // Percent sale off
    private String descript;    // Description of product
    private int quantity;       // Total of size S M L XL of product
    private int sizeS;          // Size S
    private int sizeM;          // Size M
    private int sizeL;          // Size L
    private int sizeXL;         // Size XL
    private int categoryID;     // Category ID

    /**
     * Constructor default
     */
    public Product() {
    }

    /**
     * Constructor.This function use to create list product, create a product.
     *
     * @param ID Product ID
     * @param title Product title
     * @param importPrice Import price of product
     * @param price Salep rice of product
     * @param salePercent Percent sale off
     * @param decript Description of product
     * @param quantity Total of size S M L XL of product
     * @param sizeS Size S
     * @param sizeM Size M
     * @param sizeL Size L
     * @param sizeXL Size XL
     * @param categoryID Category ID
     */
    public Product(int ID, String title, int importPrice, int price, int salePercent, String decript, int quantity, int sizeS, int sizeM, int sizeL, int sizeXL, int categoryID) {
        this.ID = ID;
        this.title = title;
        this.importPrice = importPrice;
        this.price = price;
        this.salePercent = salePercent;
        this.descript = decript;
        this.quantity = quantity;
        this.sizeS = sizeS;
        this.sizeM = sizeM;
        this.sizeL = sizeL;
        this.sizeXL = sizeXL;
        this.categoryID = categoryID;
    }

    /**
     * This is a getter which gets the size s of product
     * @return size s of product
     */
    public int getSizeS() {
        return sizeS;
    }

    /**
     * This is a setter which sets the size s of product
     * @param sizeS size s of product
     */
    public void setSizeS(int sizeS) {
        this.sizeS = sizeS;
    }

    /**
     * This is a getter which gets the size m of product
     * @return size m of product
     */
    public int getSizeM() {
        return sizeM;
    }

    /**
     * This is a setter which sets the size m of product
     * @param sizeM size m of product
    */
    public void setSizeM(int sizeM) {
        this.sizeM = sizeM;
    }

    /**
     * This is a getter which gets the size l of product
     * @return size l of product
     */
    public int getSizeL() {
        return sizeL;
    }

    /**
     * This is a setter which sets the size l of product
     * @param sizeL size l of product
     */
    public void setSizeL(int sizeL) {
        this.sizeL = sizeL;
    }

    /**
     * This is a getter which gets the size xl of product
     * @return size xl of product
     */
    public int getSizeXL() {
        return sizeXL;
    }

    /**
     * This is a setter which sets the size xl of product
     * @param sizeXL size xl of product
     */
    public void setSizeXL(int sizeXL) {
        this.sizeXL = sizeXL;
    }

    /**
     * This is a getter which gets the product ID
     * @return product ID
     */
    public int getID() {
        return ID;
    }

    /**
     * This is a setter which sets the product ID
     * @param ID product ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
      * This is a getter which gets the title of product
     * @return title of product
     */
    public String getTitle() {
        return title;
    }

    /**
     * This is a setter which sets the title of product
     * @param title title of product
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This is a getter which gets the import price of product
     * @return import price of products
     */
    public int getImportPrice() {
        return importPrice;
    }

    /**
    * This is a setter which sets the import price of product
     * @param importPrice import price of product
     */
    public void setImportPrice(int importPrice) {
        this.importPrice = importPrice;
    }

    /**
     * This is a getter which gets the sale price of product
     * @return sale price of product
     */
    public int getPrice() {
        return price;
    }

    /**
     * This is a setter which sets the sale price of product
     * @param price sale price of product
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
      * This is a getter which gets the sale percent
     * @return sale percent
     */
    public int getSalePercent() {
        return salePercent;
    }

    /**
      * This is a setter which sets the sale percent 
     * @param salePercent sale percent
     */
    public void setSalePercent(int salePercent) {
        this.salePercent = salePercent;
    }

    /**
     * This is a getter which gets the description
     * @return description
     */
    public String getDecript() {
        return descript;
    }

    /**
     * This is a setter which sets the description
     * @param decript description
     */
    public void setDecript(String decript) {
        this.descript = decript;
    }

    /**
     * This is a getter which gets the quantity
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * This is a setter which sets the quantity
     * @param quality quantity
     */
    public void setQuantity(int quality) {
        this.quantity = quality;
    }

    /**
     * This is a getter which gets the category id
     * @return category id
     */
    public int getCategoryID() {
        return categoryID;
    }

    /**
     * This is a setter which sets the category id
     * @param categoryID category id
     */
    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
}
