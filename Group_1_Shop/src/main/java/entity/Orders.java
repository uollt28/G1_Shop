package entity;

import dao.ProductDAO;

/**
 * @author Trần Đăng Khoa - CE160367
 */

public class Orders {
    private String id;          // store ID of orders
    private String customer_id; // store customer_id of orders
    private String product_id;  // store product_id of orders
    private String size;        // store size of ordered product
    private int quantity;       // store quantity of ordered product
    private String title;       // store title of ordered product
    private int price;          // store price of ordered product
    private String status;      // store status of ordered product
    private String date;        // store date of ordered product
    private String note;        // store note of ordered product
    private int numberProduct;  // to get number of ordered products in an orders
    private int totalPrice;     // to get total price of ordered products in an orders
    
    /**
     * Default constructor(no parameter).
     */
    public Orders() {
    }

    /**
     * Constructor with some of parameters for initialize object Orders.
     * @param customer_id passed customer_id when user order.
     * @param product_id passed product_id when user order.
     * @param size passed size when user order.
     * @param quantity  passed quantity when user order.
     */
    public Orders(String customer_id, String product_id, String size, int quantity) {
        this.customer_id = customer_id;
        this.product_id = product_id;
        this.size = size;
        this.quantity = quantity;
    }

    /**
     * Constructor with full parameter for initialize full object in paying.
     * @param id id of an orders is get automatically from a function to store id of an orders(primary key).
     * @param customer_id passed customer_id when user order.
     * @param product_id passed product_id when user order.
     * @param size passed size when user order.
     * @param quantity passed quantity when user order.
     * @param status passed status when user order.
     * @param date passed date when user order.
     * @param note passed note when user order.
     */
    public Orders(String id, String customer_id, String product_id, String size, int quantity, String status, String date, String note) {
        this.id = id;
        this.customer_id = customer_id;
        this.product_id = product_id;
        this.size = size;
        this.quantity = quantity;
        this.status = status;
        this.date = date;
        this.note = note;
    }

    /**
     * Constructor with full parameter for initialize full object in paying.
     * @param id id of an orders is get automatically from a function to store id of an orders(primary key).
     * @param customer_id passed customer_id when user order.
     * @param product_id passed product_id when user order.
     * @param size passed size when user order.
     * @param quantity passed quantity when user order.
     * @param price passed price of a product when user order.
     * @param status passed status when user order.
     * @param date passed date when user order.
     * @param note passed note when user order.
     */
    public Orders(String id, String customer_id, String product_id, String size, int quantity, int price, String status, String date, String note) {
        this.id = id;
        this.customer_id = customer_id;
        this.product_id = product_id;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
        this.date = date;
        this.note = note;
    }
    
    /**
     * to get the id of an orders.
     * @return id of an orders - String.
     */
    public String getId() {
        return id;
    }

    /**
     * to set a new id of an orders.
     * @param id passed id to set new id.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * to get the getCustomer_id of an orders.
     * @return customer_id of an orders - String.
     */
    public String getCustomer_id() {
        return customer_id;
    }

    /**
     * to set a new getCustomer_id of an orders.
     * @param customer_id passed customer_id to set new customer_id.
     */
    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    /**
     * to get the product_id of an orders.
     * @return product_id of an orders - String.
     */
    public String getProduct_id() {
        return product_id;
    }

    /**
     * to set a new product_id of an orders.
     * @param product_id passed product_id to set new product_id.
     */
    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    /**
     * to get the size of a product in an orders.
     * @return size of a product in an orders.
     */
    public String getSize() {
        return size;
    }

    /**
     * to set new size of a product in an orders.
     * @param size passed size to set new size.
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * to get the quantity of a product in an orders.
     * @return quantity of a product in an orders.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * to set a new quantity of a product in an orders.
     * @param quantity passed quantity of a product in an orders.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * to get the status of an orders.
     * @return status to an orders.
     */
    public String getStatus() {
        return status;
    }

    /**
     * to set a new status of an orders.
     * @param status passed status to set new status.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * to get the ordered date of an orders.
     * @return ordered date of an orders.
     */
    public String getDate() {
        return date;
    }

    /**
     * to set new ordered date of an orders.
     * @param date passed ordered date of an orders to.
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * to get the note of an orders.
     * @return note of an orders.
     */
    public String getNote() {
        return note;
    }

    /**
     * to set a new note of an orders.
     * @param note passed note to set a new note.
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * to get price (original - sale or not sale) of a product in an orders.
     * @return price (original - sale or not sale) of a product in an orders.
     */
    public int getPrice() {
        ProductDAO pdao = new ProductDAO();
        Product p = pdao.getProductIByID(this.getProduct_id());
        return ((p.getPrice() - (p.getPrice()*p.getSalePercent()/100)));
    }

    /**
     * to set a new price (original - sale or not sale) of a product in an orders.
     * @param price passed price (original - sale or not sale) of a product in an orders.
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * to get the title of a product in an orders.
     * @return title of a product in an orders.
     */
    public String getTitle() {
        ProductDAO pdao = new ProductDAO();
        Product p = pdao.getProductIByID(this.getProduct_id());
        return p.getTitle();
    }

    /**
     * to set new title of a product in an orders.
     * @param title passed title of a product in an orders.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * to get the numberProduct of a product in an orders.
     * @return numberProduct of a product in an orders.
     */
    public int getNumberProduct() {
        return numberProduct;
    }

    /**
     * to set new numberProduct of a product in an orders.
     * @param numberProduct passed numberProduct of a product in an orders.
     */
    public void setNumberProduct(int numberProduct) {
        this.numberProduct = numberProduct;
    }

    /**
     * to get total price of an orders.
     * @return total price of an orders.
     */
    public int getTotalPrice() {
        return totalPrice;
    }

    /**
     * to set new total price of an orders.
     * @param totalPrice passed total price of an orders.
     */
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
    
}
