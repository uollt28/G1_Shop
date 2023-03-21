package dao;

import context.DBContext;
import entity.Cart;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Package dao have CartDAO to access the Cart table in database.
 *      Connection con = null; connect to SQL Server.
 *      PreparedStatement ps = null; move query from NetBeans to SQL.
 *       ResultSet rs = null; save result query.
 * Class CartDAO have methods:
 *      addNewCart().
 *      checkExitCart().
 *      getListCart().
 *      getListCartByCustomerID().
 *      updateCart().
 *      deleteCart().
 *      getQuantity().
 *      deleteCartNoQuantity().
 *      sumOfProductCart().
 *      sliptProductIDByCartID().
 *      sliptSizeByCartID().
 * @author Nguyen Duong Phu Trong -  CE160324
 */
public class CartDAO {

    Connection con = null;               // connect to SQL server
    PreparedStatement ps = null;         // move query from Netbeen to SQl
    ResultSet rs = null;                 // save result query
    List<Cart> list = new ArrayList<>(); // list to store temp cart

    /**
     * Method addNewCart() have parameter (quantity, size, pID, customerID) to add new products.
     * This method allow user add new products to their Cart in the shopping website.
     * Method can check a product is exit or not and update a product if that product is already.
     * If user add a product but it's not already in the Cart, method addNewCart() will be add that product into the Cart.
     * String query in this method is SQL query, this SQL query allow add new product into the database.
     * The code try{} and catch(Exception e) alow the code inside can run and print exception if they have exception. Because the code inside will access to system and it will be have exception unforeseeable. 
     * @param quantity quantity of product is inserted to cart
     * @param size size of product is inserted to cart
     * @param pID product id of product is inserted to cart
     * @param customerID customer id is inserted to cart
     */
    public void addNewCart(int quantity, String size, int pID, int customerID) {
        if (checkExitCart(size, pID, customerID)) {
            updateCart(pID, customerID, quantity, size, getQuantity(pID, customerID, size));
        } else {
            // query to insert to SQL
            String query = "INSERT INTO Cart VALUES(?, ?, null, ?,?);";
            try {
                con = new DBContext().getConnection(); // open connection to SQL
                ps = con.prepareStatement(query);      // move query from Netbeen to SQl
                ps.setInt(1, pID);                     // set product id to ? at location 1
                ps.setInt(2, customerID);              // set product id to ? at location 2
                ps.setString(3, size);                 // set product id to ? at location 3
                ps.setInt(4, quantity);                // set product id to ? at location 4
                ps.executeUpdate();                    // excute query and update info 
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    /**
     * Method checkExitCart() have parameter (size, pID, customerID) to check products in Cart are already or not.
     * By default value check product is false, the code follow: boolean check = false;
     * The SQL query "select size from Cart where product_id = ? AND customer_id = ?;"; use to select product in Cart with condition product id and customer id.
     * The code try{} catch, this code use for catch some exception can't catch. Because the code inside try{} catch is system code.
     * @param size size of product is inserted to cart
     * @param pID product id of product is inserted to cart
     * @param customerID customer id inserted to cart
     * @return status of check is cart exist or not.
     */
    public boolean checkExitCart(String size, int pID, int customerID) {
        boolean check = false;
        // query to insert to SQL
        String query = "select size from Cart where product_id = ? AND customer_id = ?;";
        try {
            con = new DBContext().getConnection();  // open connection to SQL
            ps = con.prepareStatement(query);       // move query from Netbeen to SQl
            ps.setInt(1, pID);                      // set product id to ? at location 1
            ps.setInt(2, customerID);               // set customer id to ? at location 2
            rs = ps.executeQuery();                 // excute the query to update table account.
            while (rs.next()) {                     // the same with click to "excute" btn
                if (rs.getString(1).equals(size)) {
                    check = true;
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return check;
    }

    /**
     * In this method, we will be able to get the list of products in the cart. 
     * Through the SQL statement, we can access the database. Then we can get the list of products that are in the cart.
     * Try-catch will help us catch the exception error. Since the lines of code contained in the try-catch are using the system's code, during operation, an exception may occur.
     * The command lines included in the try-catch will make it possible for us to create a new connection to the database and put the SQL statement into the database and then execute the SQL statement.
     * @return all cart in list of db
     */
    public List<Cart> getListCart() {
        try {
            // query to insert to SQL
            String query = "select C.*, p.product_tittle, P.product_price\n"
                    + "from Cart C\n"
                    + "join Product P on P.product_id = C.product_id\n"
                    + "left join Orders O on O.order_id = C.order_id"; 
            con = new DBContext().getConnection();   // open connection to SQL
            ps = con.prepareStatement(query);        // move query from Netbeen to SQl
            rs = ps.executeQuery();                  // the same with click to "excute" btn
            List<Cart> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new Cart(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(5),
                        rs.getString(4),
                        rs.getString(6),
                        rs.getInt(7)));
            }
            return list;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    /**
     * Method getListCartByCustomerID() with parameter cID allow get the list of products in Cart by customerID.
     * The code String query contain SQL query. This query allow access database to get data in database.
     * The method will return list.
     * @param cID customer id inserted to cart
     * @return list cart of a specified customer
     */
    public List<Cart> getListCartByCustomerID(int cID) {
        List<Cart> list = new ArrayList<>();
        try {
            // query to insert to SQl
            String query = "select C.*, p.product_tittle, P.product_price\n"
                    + "from Cart C\n"
                    + "join Product P on P.product_id = C.product_id\n"
                    + "left join Orders O on O.order_id = C.order_id\n"
                    + "where C.customer_id = ? and C.order_id is NULL"; 
            con = new DBContext().getConnection();   // open connection to SQL
            ps = con.prepareStatement(query);        // move query from Netbeen to SQl
            ps.setInt(1, cID);                       // set customer id to ? at location 1
            rs = ps.executeQuery();                  // the same with click to "excute" btn;
            while (rs.next()) {
                list.add(new Cart(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(5),
                        rs.getString(4),
                        rs.getString(6),
                        rs.getInt(7)));

            }
            return list;
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

     /**
     * Method updateCart() have parameter (productID, custommerID, quantity, size, temp) allow user update Cart.
     * The code String query is contain SQL query to access to the database. 
     * The SQL query with condition to access productID and customerID and size in table Cart in database.
     * The code try{} catch to catch exception the code inside.
     * @param productID product id of product is inserted to cart
     * @param customerID customer id inserted to cart
     * @param quantity quantity of product is inserted to cart
     * @param size size of product is inserted to cart
     * @param temp temp number of quantity of product is inserted to cart
     */
    public void updateCart(int productID, int customerID, int quantity, String size, int temp) {
        // query to insert to SQl
        String query = "update Cart\n"
                + "set quantity = ?\n"
                + "where product_id = ? AND customer_id = ? AND size = ?;";
        try {
            con = new DBContext().getConnection();   // open connection to SQL
            ps = con.prepareStatement(query);        // move query from Netbeen to SQl
            ps.setInt(1, quantity + temp);           // set quantity + temp to ? at location 1
            ps.setInt(2, productID);                 // set product id to ? at location 2
            ps.setInt(3, customerID);                // set customer id to ? at location 3
            ps.setString(4, size);                   // set size to ? at location 4
            rs = ps.executeQuery();                  // the same with click to "excute" btn
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method deleteCart() have parameter (productID, customerID, quantity, size) 
     * to allow user can delete product in Cart.Once deleted, the product has been removed from the Cart and the Cart will be updated.
     * @param productID product id of product is inserted to cart
     * @param customerID customer id is inserted to cart
     * @param quantity quantity of product is inserted to cart
     * @param size size of product is inserted to cart
     */
    public void deleteCart(int productID, int customerID, int quantity, String size) {
        updateCart(productID, customerID, quantity, size, -1);
        deleteCartNoQuantity(productID, customerID, size);
    }
    
    /**
     * In this method, we will be able to get the number of products in the cart. 
     * Through the SQL statement, we can access the database. Then we can get the quantity of the product.
     * Try-catch will help us catch the exception error. Since the lines of code contained in the try-catch are using the system's code, during operation, an exception may occur.
     * The command lines included in the try-catch will make it possible for us to create a new connection to the database and put the SQL statement into the database and then execute the SQL statement.
     * @param productID product id of product is inserted to cart
     * @param customerID customer id is inserted to cart
     * @param size size of product is inserted to cart
     * @return total quantity of a specified product
     */
    public int getQuantity(int productID, int customerID, String size) {
        int sum = 0;
        // query to insert into SQL
        String query = "select C.quantity\n"
                + "from Cart C\n"
                + "join Product P on P.product_id = C.product_id\n"
                + "left join Orders O on O.order_id = C.order_id\n"
                + "where C.customer_id = ? AND C.product_id = ? AND C.size = ?";
        try {
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query);      // move query from Netbeen to SQl
            ps.setInt(1, customerID);              // set customerID to ? at location 1
            ps.setInt(2, productID);               // set productID to ? at location 2
            ps.setString(3, size);                 // set size to ? at location 3
            rs = ps.executeQuery();                // the same with click to "excute" btn         
            while (rs.next()) {
                sum = rs.getInt(1);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return sum;
    }

     /**
     * This method will help us to remove the number of products in the cart. Through the SQL statement, we can access the table in the database to be able to delete the products in the cart.
     * The lines of code contained in the try-catch will help us re-create the connection to the database and can put the SQL statement into the database, then execute the SQL statement.
     * @param productID id of product is inserted to cart
     * @param customerID customer id is inserted to cart
     * @param size size of product is inserted to cart
     */
    public void deleteCartNoQuantity(int productID, int customerID, String size) {
        int sum = getQuantity(productID, customerID, size);
        if (sum == 0) {
            // query on to insert into SQL
            String query = "delete from Cart where customer_id = ? and product_id = ? and size = ?";
            try {
                con = new DBContext().getConnection(); // open connection to SQL
                ps = con.prepareStatement(query);      // move query from Netbeen to SQl
                ps.setInt(1, customerID);              // set customerID to ? at location 1
                ps.setInt(2, productID);               // set productID to ? at location 2
                ps.setString(3, size);                 // set size to ? at location 3
                rs = ps.executeQuery();                // the same with click to "excute" btn         
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    /**
     * In this method, it will help the user to know the total product price of a product in the cart.
     * Through the customer ID, we can get the information of the products in the cart. 
     * After having the product information in the cart, we can calculate the price according to the formula:
     * The total product price will be equal to the number of products in the cart multiplied by the price of the product.
     * @param cID customer id is passed to get list of cart by customer id
     * @return total of product is in current cart.
     */
    public int sumOfProductCart(int cID) {
        int sum = 0;
        CartDAO cdao = new CartDAO();
        List<Cart> list = cdao.getListCartByCustomerID(cID);
        for (Cart c : list) {
            sum += c.getQuantity() * c.getProductPrice();
        }
        return sum;
    }

    /**
     * In this method, we can check productID through cartID.
     * The method will return pID.
     * @param isCheckedTxt array of string for split product id.
     * @return product id is choose to paying
     */
    public int sliptProductIDByCartID(String isCheckedTxt) {
        int pID = 0;
        String carID[] = isCheckedTxt.split(",");
        pID = Integer.parseInt(carID[0]);
        return pID;
    }

    /**
     * In this method, we can check cútomerID through cartID.
     * The method will return pID.
     * @param isCheckedTxt array of string for split product id.
     * @return customer id is choose to paying
     */
    public int sliptCusIDByCartID(String isCheckedTxt) {
        int cID = 0;
        String carID[] = isCheckedTxt.split(",");
        cID = Integer.parseInt(carID[1]);
        return cID;
    }

     /**
     * In this method, we can check size through cartID.
     * The method will return pID.
     * @param isCheckedTxt array of string for split product id.
     * @return size of product is choose to paying
     */
    public String sliptSizeByCartID(String isCheckedTxt) {
        String size = "";
        String carID[] = isCheckedTxt.split(",");
        size = carID[2];
        return size;
    }
}
