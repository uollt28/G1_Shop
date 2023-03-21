package entity;

import dao.ProductDAO;

/**
 * Package entity have class Cart, class Cart have attribute of object Cart:
 * Class Cart have attributes:
 *    +  productID   (ID of product in database).
 *    +  cusID       (ID of customer in database).
 *    +  ordID       (ID of order in database).
 *    +  quantity    (quantity of products that customer ordered).
 *    +  size        (size of products that customer ordered).
 *    +  productTile (Title of products in database).
 *    +  productPrice(Price of products in database).
 *  All attributes are encapsulated properties.
 * @author Nguyen Duong Phu Trong -  CE160324
 */
public class Cart {

    private int productID;       // store id of product
    private int cusID;           // store customer id of product
    private int ordID;           // store order id of product
    private int quantity;        // store quantity of product
    private String size;         // store size of product
    private String productTitle; // store productTitle of product
    private int productPrice;    // store productPrice of product
    
    /**
     * Constructor without parameters
     */
    public Cart() {
    }

    /**
     * Constructor with parameters
     * @param productID id of product
     * @param cusID customer id of product
     * @param ordID order id of product
     * @param quantity quantity of product
     * @param size size of product
     * @param productTitle title of product
     * @param productPrice price of product
     */
    public Cart(int productID, int cusID, int ordID, int quantity, String size, String productTitle, int productPrice) {
        this.productID = productID;
        this.cusID = cusID;
        this.ordID = ordID;
        this.quantity = quantity;
        this.size = size;
        this.productTitle = productTitle;
        this.productPrice = productPrice;
    }

    /**
     *  Method getProductID() to get attribute productID 
     * @return id of product
     */
    public int getProductID() {
        return productID;
    }

    /**
     * Method setProductID() have parameter productID to set attribute productID.
     * @param productID id of product is passed
     */
    public void setProductID(int productID) {
        this.productID = productID;
    }

    /**
     * Method getCusID() to get attribute cusID.
     * @return customer id of product
     */
    public int getCusID() {
        return cusID;
    }

    /**
     * Method setCusID() have parameter cusID to set attribute cusID.
     * @param cusID customer id of product is passed
     */
    public void setCusID(int cusID) {
        this.cusID = cusID;
    }

    /**
     * Method getOrdID() to get attribute ordID.
     * @return order id of product
     */
    public int getOrdID() {
        return ordID;
    }

    /**
     * Method setOrdID have parameter ordID to set attribute ordID.
     * @param ordID order id of product is passed
     */
    public void setOrdID(int ordID) {
        this.ordID = ordID;
    }

    /**
     * Method getQuantity() to get attribute quantity.
     * @return quantity of product
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Method setQuantity() have parameter quantity to set attribute quantity.
     * @param quantity quantity of product is passed
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

     /**
     * Method getSize() to get attribute size.
     * @return size size of product
     */
    public String getSize() {
        return size;
    }

     /**
     * Method setSize() have parameter size to set attribute size.
     * @param size passed size of product
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * Method getProductTitle() to get attribute productTitle. 
     * @return productTitle is title of product
     */
    public String getProductTitle() {
        return productTitle;
    }

    /**
     * Method setProductTitle() have parameter productTitle to set attribute productTitle.
     * @param productTitle is passed title of product
     */
    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    /**
     * Method getProductPrice() to get productPrice.
     * This is a price after sale is calculated by formula: 
     * price - (price * sale percent / 100)
     * @return productPrice price of product
     */
    public int getProductPrice() {
        ProductDAO pdao = new ProductDAO();
        Product p = pdao.getProductIByID(String.valueOf(this.getProductID()));
        return ((p.getPrice() - (p.getPrice() * p.getSalePercent() / 100)));
    }

   /**
     * Method setProductPrice() have parameter productPrice to set attribute productPrice.
     * @param productPrice passed price of product
     */
    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

}
