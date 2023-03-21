package entity;

/**
 * @author Huynh Huu Nghia - CE160343 
 */

public class Category {
    private int ID;       // store id of category
    private String name;  // store name (title) of category

    /**
     * Default constructor
     */
    public Category() {
    }

    /**
     * Create constructor with two parameter
     * @param ID id of category is passed
     * @param name name of category is passed
     */
    public Category(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    /**
     * Get id of category
     * @return id of category
     */
    public int getID() {
        return ID;
    }

    /**
     * Set id of category
     * @param ID passed id of category
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Get name of category
     * @return name of category
     */
    public String getName() {
        return name;
    }

    /**
     * Set name of category
     * @param name passed name of category
     */
    public void setName(String name) {
        this.name = name;
    }
}
