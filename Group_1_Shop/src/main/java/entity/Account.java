package entity;

/**
 * @author Lê Khanh Băng - CE160155
 */
public class Account {

    private int ID;             // id of account
    private String phone;       // phone link with account
    private String password;    // password of account
    private int roleID;         // role of account

    /**
     * Default constructor
     */
    public Account() {
    }

    /**
     * Constructor object
     * @param ID id of account
     * @param phone phone link with account
     * @param password password of account
     * @param roleID role of account
     */
    public Account(int ID, String phone, String password, int roleID) {
        this.ID = ID;
        this.phone = phone;
        this.password = password;
        this.roleID = roleID;
    }

    /**
     * Function gets value
     * @return id of account
     */
    public int getID() {
        return ID;
    }

    /**
     * function set value
     * @param ID set id of account
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Function gets value
     * @return phone link with account
     */
    public String getPhone() {
        return phone;
    }

    /**
     * function set value
     * @param phone set phone link with account
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Function gets value
     * @return password of account
     */
    public String getPassword() {
        return password;
    }

    /**
     * function set value
     * @param password set password of account
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Function gets value
     * @return role of account
     */
    public int getRoleID() {
        return roleID;
    }

    /**
     * function set value
     * @param roleID set role of account
     */
    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    /**
     * To string to show object info.
     * @return object info.
     */
    @Override
    public String toString() {
        return "Account{" + "ID=" + ID + ", phone=" + phone + ", password=" + password + ", roleID=" + roleID + '}';
    }
}
