package entity;

import dao.AccountDAO;

/**
 *
 * @author Lê Khanh Băng - CE160155
 */
public class Customer {
    
   private int ID;          //id of customer
    private String name;    //name of customer
    private String email;   //email of customer
    private String address; //address of customer
    private int accountID;  //id account of customer
    private String phone;   //phone of customer

    /**
     * Default constructor 
     */
    public Customer() {
    }

    /**
     * Constructor object
     * @param ID id of customer
     * @param name name of customer
     * @param email email of customer
     * @param address address of customer
     * @param accountID id account of customer
     */
    public Customer(int ID, String name, String email, String address, int accountID) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.address = address;
        this.accountID = accountID;
    }

    /**
     * Function gets value
     * @return id of customer
     */
    public int getID() {
        return ID;
    }

   /**
     * function set value
     * @param ID set id of customer
     */
    public void setID(int ID) {
        this.ID = ID;
    }

     /**
     * Function gets value
     * @return name of customer
     */
    public String getName() {
        return name;
    }

     /**
     * function set value
     * @param name set name of customer
     */
    public void setName(String name) {
        this.name = name;
    }

     /**
     * Function gets value
     * @return email of customer
     */
    public String getEmail() {
        return email;
    }

    /**
     * function set value
     * @param email set email of customer
     */
    public void setEmail(String email) {
        this.email = email;
    }
/**
     * Function gets value
     * @return address of customer
     */
    public String getAddress() {
        return address;
    }

    /**
     * function set value
     * @param address set address of customer
     */
    public void setAddress(String address) {
        this.address = address;
    }

     /**
     * Function gets value
     * @return id account of customer
     */
    public int getAccountID() {
        return accountID;
    }

   /**
     * function set value
     * @param accountID set id account of customer
     */
    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    /**
     * Function gets value
     * @return phone of customer
     */
    public String getPhone() {
        AccountDAO adao = new AccountDAO();
        Account c = adao.getAccountByAccountID(String.valueOf(this.getAccountID()));
        return c.getPhone();
    }

     /**
     * function set value
     * @param phone set phone of customer
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
