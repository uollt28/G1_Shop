package dao;

import context.DBContext;
import entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Huynh Huu Nghia - CE160343 
 */
public class ProductDAO {

    Connection con = null;          // connect to SQL server
    PreparedStatement ps = null;    // move query from Netbeen to SQl
    ResultSet rs = null;            // save result query

     /**
     * Get list product. This function use to query load product id, product title, import price,
     * sale price, percent price, product size S M L XL, quantity of size product, description. 
     * Create list product add all of product.
     * @return {list}[product] list product
     */
    public List<Product> getListProduct() {
        try {
            // your query to excute in SQL
            String query = "select P.product_id as product_id, P.product_tittle as product_tittle, P.product_import_price as product_import_price, P.product_price as product_price, "
                    + "P.product_sale_percent as product_sale_percent, P.product_disciption as product_disciption, PS.product_size_s as product_size_s, "
                    + "PS.product_size_m as product_size_m, PS.product_size_l as product_size_l, PS.product_size_xl as product_size_xl, P.catelogy_id as "
                    + "catelogy_id from Product P  join ProductSize PS on P.product_id = PS.product_id join Category C on P.catelogy_id = C.category_id ORDER BY product_id DESC;";
            con = new DBContext().getConnection();  // open connection to SQL
            ps = con.prepareStatement(query);       // move query from Netbeen to SQl
            rs = ps.executeQuery();                 // the same with click to "excute" btn;
            List<Product> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7) + rs.getInt(8) + rs.getInt(9) + rs.getInt(10),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getInt(11)
                ));
            }
            return list;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }
    
     /**
     * Get list product sale
     * This function heck sale product, which product has sale percent != 0.
     * Create list product and add all sale product.
     * @return {list}[product] list product
     */
    public List<Product> getListProductIsSaled() {
        try {
            // your query to excute in SQL
            String query = "select P.product_id as product_id, P.product_tittle as product_tittle, P.product_import_price as product_import_price, P.product_price as product_price, P.product_sale_percent as product_sale_percent,\n"
                    + "P.product_disciption as product_disciption, PS.product_size_s as product_size_s, PS.product_size_m as product_size_m,\n"
                    + "PS.product_size_l as product_size_l, PS.product_size_xl as product_size_xl, P.catelogy_id as catelogy_id\n"
                    + "from Product P \n"
                    + "join ProductSize PS on P.product_id = PS.product_id\n"
                    + "join Category C on P.catelogy_id = C.category_id\n"
                    + "where product_sale_percent <> 0 ORDER BY product_sale_percent DESC;";
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query);      // move query from Netbeen to SQl
            rs = ps.executeQuery();                // the same with click to "excute" btn;
            List<Product> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7) + rs.getInt(8) + rs.getInt(9) + rs.getInt(10),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getInt(11)
                ));
            }
            return list;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    
     /**
     * Get list product by is in order list - top trending.
     * This function use parameter categoryID to select all product have
     * category id equal categoryID from sql server to list product.
     * @return {list}[product] list product
     */
    public List<Product> getListProductIsOrdered() {
        try {
            // your query to excute in SQL
            String query = "select top 20 P.*, PS.*, C.Quantity\n"
                    + "from Product P \n"
                    + "join ProductSize PS on P.product_id = PS.product_id\n"
                    + "join (select c.product_id, sum(c.quantity) as Quantity\n"
                    + "from Cart c\n"
                    + "group by  c.product_id) C on C.product_id = P.product_id\n"
                    + "order by c.quantity desc;";
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query);      // move query from Netbeen to SQl
            rs = ps.executeQuery();                // the same with click to "excute" btn;
            List<Product> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(8) + rs.getInt(9) + rs.getInt(10) + rs.getInt(11),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getInt(11),
                        rs.getInt(7)
                ));
            }
            return list;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

     /**
     * Get list product by category id
     * This function use parameter categoryID to select all product have
     * category id equal categoryID from sql server to list product.
     * @param categoryID category id for getting
     * @return {list}[product] list product
     */
    public List<Product> getListProductByCategoryID(String categoryID) {
        List<Product> list = new ArrayList<>();
        try {
            // your query to excute in SQL
            String query = "select P.product_id, P.product_tittle, P.product_import_price, P.product_price, P.product_sale_percent,\n"
                    + "P.product_disciption, PS.product_size_s, PS.product_size_m,\n"
                    + "PS.product_size_l, PS.product_size_xl, P.catelogy_id\n"
                    + "from Product P \n"
                    + "join ProductSize PS on P.product_id = PS.product_id\n"
                    + "join Category C on P.catelogy_id = C.category_id\n"
                    + "where P.catelogy_id = ?";                
            con = new DBContext().getConnection();   // open connection to SQL
            ps = con.prepareStatement(query);        // move query from Netbeen to SQl
            ps.setString(1, categoryID);             // set categoryID get from servelet to ?
            rs = ps.executeQuery();                  // the same with click to "excute" btn;

            while (rs.next()) {
                list.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7) + rs.getInt(8) + rs.getInt(9) + rs.getInt(10),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getInt(11)
                ));
            }
            return list;
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

     /**
     * Get list product by product id
     * This function use parameter productID to select all product have product
     * id equal productID from sql server to list product.
     * @param productID product ID
     * @return [product] entity of product
     */
    public Product getProductIByID(String productID) {
        try {
            // your query to excute in SQL
            String query = "select P.product_id, P.product_tittle, P.product_import_price, P.product_price, P.product_sale_percent,\n"
                    + "P.product_disciption, PS.product_size_s, PS.product_size_m,\n"
                    + "PS.product_size_l, PS.product_size_xl, P.catelogy_id\n"
                    + "from Product P \n"
                    + "join ProductSize PS on P.product_id = PS.product_id\n"
                    + "join Category C on P.catelogy_id = C.category_id\n"
                    + "where P.product_id = ?";               
            con = new DBContext().getConnection();  // open connection to SQL
            ps = con.prepareStatement(query);       // move query from Netbeen to SQl
            ps.setString(1, productID);             // set productID get from servelet to ?
            rs = ps.executeQuery();                 // the same with click to "excute" btn;
            while (rs.next()) {
                return new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7) + rs.getInt(8) + rs.getInt(9) + rs.getInt(10),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getInt(11)
                );

            }
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    /**
     * Search product by product title
     * This function use parameter txtSearch to search all product have product
     * title equal txtSearch from sql server to list product.
     * @param txtSearch title of product
     * @return {list}[product] list product
     */
    public List<Product> searchProductByTitle(String txtSearch) {
        List<Product> list = new ArrayList<>();
        try {
             // your query to excute in SQL
            String query = "select P.product_id as product_id, P.product_tittle as product_tittle, P.product_import_price as product_import_price, P.product_price as product_price, P.product_sale_percent as product_sale_percent,\n"
                    + "P.product_disciption as product_disciption, PS.product_size_s as product_size_s, PS.product_size_m as product_size_m,\n"
                    + "PS.product_size_l as product_size_l, PS.product_size_xl as product_size_xl, P.catelogy_id as catelogy_id\n"
                    + "from Product P \n"
                    + "join ProductSize PS on P.product_id = PS.product_id\n"
                    + "join Category C on P.catelogy_id = C.category_id\n"
                    + "where P.product_tittle like ?";      
            con = new DBContext().getConnection();   // open connection to SQL
            ps = con.prepareStatement(query);        // move query from Netbeen to SQl
            ps.setString(1, "%" + txtSearch + "%");  // set txtSearch get from servelet to ?
            rs = ps.executeQuery();                  // the same with click to "excute" btn;
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7) + rs.getInt(8) + rs.getInt(9) + rs.getInt(10),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getInt(11)
                ));
            }
            return list;
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

   /**
     * Get list product by import price sort by ascending
     * This function Get list product by import price sort by ascending and return list sorted.
     * @return {list}[product] list product
     */
    public List<Product> sortListProductByImportPriceAsc() {
        try {
             // your query to excute in SQL
            String query = "select P.product_id as product_id, P.product_tittle as product_tittle, P.product_import_price as product_import_price, P.product_price as product_price\n"
                    + ",P.product_sale_percent as product_sale_percent, P.product_disciption as product_disciption, PS.product_size_s as product_size_s\n"
                    + ",PS.product_size_m as product_size_m, PS.product_size_l as product_size_l, PS.product_size_xl as product_size_xl, P.catelogy_id as catelogy_id \n"
                    + "from Product P  join ProductSize PS on P.product_id = PS.product_id join Category C on P.catelogy_id = C.category_id \n"
                    + "ORDER BY p.product_import_price ASC;";
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query);      // move query from Netbeen to SQl
            rs = ps.executeQuery();                // the same with click to "excute" btn;
            List<Product> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7) + rs.getInt(8) + rs.getInt(9) + rs.getInt(10),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getInt(11)
                ));
            }
            return list;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

     /**
     * Get list product by import price sort by decreasing
     * This function Get list product by import price sort by decreasing and return list sorted.
     * @return {list}[product] list product
     */
    public List<Product> sortListProductByImportPriceDesc() {
        try {
             // your query to excute in SQL
            String query = "select P.product_id as product_id, P.product_tittle as product_tittle, P.product_import_price as product_import_price, P.product_price as product_price\n"
                    + ",P.product_sale_percent as product_sale_percent, P.product_disciption as product_disciption, PS.product_size_s as product_size_s\n"
                    + ",PS.product_size_m as product_size_m, PS.product_size_l as product_size_l, PS.product_size_xl as product_size_xl, P.catelogy_id as catelogy_id \n"
                    + "from Product P  join ProductSize PS on P.product_id = PS.product_id join Category C on P.catelogy_id = C.category_id \n"
                    + "ORDER BY p.product_import_price DESC;";
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query);      // move query from Netbeen to SQl
            rs = ps.executeQuery();                // the same with click to "excute" btn;
            List<Product> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7) + rs.getInt(8) + rs.getInt(9) + rs.getInt(10),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getInt(11)
                ));
            }
            return list;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    /**
     * Get list product by sale price sort by ascending
     * This function Get list product by sale price sort by ascending and return list sorted.
     * @return {list}[product] list product
     */
    public List<Product> sortListProductByPriceAsc() {
        try {
             // your query to excute in SQL
            String query = "select P.product_id as product_id, P.product_tittle as product_tittle, P.product_import_price as product_import_price, P.product_price as product_price\n"
                    + ",P.product_sale_percent as product_sale_percent, P.product_disciption as product_disciption, PS.product_size_s as product_size_s\n"
                    + ",PS.product_size_m as product_size_m, PS.product_size_l as product_size_l, PS.product_size_xl as product_size_xl, P.catelogy_id as catelogy_id \n"
                    + "from Product P  join ProductSize PS on P.product_id = PS.product_id join Category C on P.catelogy_id = C.category_id \n"
                    + "ORDER BY p.product_price ASC;";
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query);      // move query from Netbeen to SQl
            rs = ps.executeQuery();                // the same with click to "excute" btn;
            List<Product> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7) + rs.getInt(8) + rs.getInt(9) + rs.getInt(10),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getInt(11)
                ));
            }
            return list;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

     /**
     * Get list product by sale price sort by decreasing
     * This function Get list product by sale price sort by decreasing and return list sorted.
     * @return {list}[product] list product
     */
    public List<Product> sortListProductByPriceDesc() {
        try {
             // your query to excute in SQL
            String query = "select P.product_id as product_id, P.product_tittle as product_tittle, P.product_import_price as product_import_price, P.product_price as product_price\n"
                    + ",P.product_sale_percent as product_sale_percent, P.product_disciption as product_disciption, PS.product_size_s as product_size_s\n"
                    + ",PS.product_size_m as product_size_m, PS.product_size_l as product_size_l, PS.product_size_xl as product_size_xl, P.catelogy_id as catelogy_id \n"
                    + "from Product P  join ProductSize PS on P.product_id = PS.product_id join Category C on P.catelogy_id = C.category_id \n"
                    + "ORDER BY p.product_price DESC;";
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query);      // move query from Netbeen to SQl
            rs = ps.executeQuery();                // the same with click to "excute" btn;
            List<Product> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7) + rs.getInt(8) + rs.getInt(9) + rs.getInt(10),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getInt(11)
                ));
            }
            return list;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    /**
     * Get total import price
     * This function get import price from list and total Import Price * Quantity
     * @param list list product need get total price
     * @return Integer total import price
     */
    public int totalImportPrice(List<Product> list) {
        int sum = 0;
        for (Product p : list) {
            sum += (p.getImportPrice() * p.getQuantity());
        }
        return sum;
    }

     /**
     * Get total sale price
     * This function get sale price from list and total Sale Price * Quantity
     * @param list list product need get total price
     * @return Integer total sale price
     */
    public int totalPrice(List<Product> list) {
        int sum = 0;
        for (Product p : list) {
            sum += (p.getPrice() * p.getQuantity());
        }
        return sum;
    }

    /**
     * Get Expenses import product
     * @param p [Product] product need expenses
     * @return Long expenses
     */
    public long getExpenses(Product p) {
        return p.getImportPrice() * p.getQuantity();
    }

    /**
     * Get Revenue sale product
     * @param p [Product] product need Revenue
     * @return Long Revenue
     */
    public long getRevenue(Product p) {
        return p.getPrice() * p.getQuantity();
    }

    /**
     * Get profit of a product
     * @param expenses Expenses import product
     * @param revenue Revenue sale product
     * @return Long revenue - expenses
     */
    public long getProfit(long expenses, long revenue) {
        return revenue - expenses;
    }

    /**
     * Delete product. This function use product and execute query to 
     * delete product, cart, product size in data
     * @param productID product id
     */
    public void deleteProduct(String productID) {
        // your query to excute in SQL
        String query = "delete from Cart where product_id = ?;\n"
                + "delete from ProductSize where product_id = ?;\n"
                + "delete from Product where product_id = ?;";
        try {
            con = new DBContext().getConnection();   // open connection to SQL
            ps = con.prepareStatement(query);        // move query from Netbeen to SQl
            ps.setString(1, productID);              // set productID get from servelet to ?
            ps.setString(2, productID);              // set productID get from servelet to ?
            ps.setString(3, productID);              // set productID get from servelet to ?
            rs = ps.executeQuery();                  // the same with click to "excute" btn;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Get new ID product
     * @return Integer new product id
     */
    public int getNewIDProduct() {
        // your query to excute in SQL
        String query_get = "select top 1 product_id from Product order by product_id desc";
        int maxProductID = -1;
        try {
            con = new DBContext().getConnection();   // open connection to SQL
            ps = con.prepareStatement(query_get);    // move query from Netbeen to SQl
            rs = ps.executeQuery();                  // the same with click to "excute" btn;
            maxProductID = rs.getInt(1) + 1;         // get max product id
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maxProductID;
    }

    /**
     * This function use parameter to add new product.
     * @param title Product title
     * @param importPrice Import price of product
     * @param price Sale price of product
     * @param salePercent Percent sale off
     * @param decript Description of product
     * @param sizeS Size S
     * @param sizeM Size M
     * @param sizeL Size L
     * @param sizeXL Size XL
     * @param cID Category ID
     */
    public void insertProduct(String title, int importPrice, int price,
            int salePercent, String decript, int sizeS, int sizeM, int sizeL, int sizeXL, int cID) {
        // get max product id
        int maxProductID = getMaxProductID() + 1;
        // your query to excute in SQL
        String query = "INSERT INTO Product VALUES(?, ?, ?, ?, ?, ?);\n"
                + "INSERT INTO ProductSize VALUES(?, ? , ?, ?, ?);";
        try {
            con = new DBContext().getConnection();   // open connection to SQL
            ps = con.prepareStatement(query);        // move query from Netbeen to SQl
            ps.setString(1, title);                  // set title to the first ?
            ps.setInt(2, importPrice);               // set importPrice to the first ?
            ps.setInt(3, price);                     // set price to the second ?
            ps.setInt(4, salePercent);               // set salePercent to ? at location 4
            ps.setString(5, decript);                // set decript to the first ? at location 4
            ps.setInt(6, cID);                       // set cID to the first ? at location 6
            ps.setInt(7, sizeS);                     // set sizeS to the first ? at location 7
            ps.setInt(8, sizeM);                     // set sizeM to the first ? at location 8
            ps.setInt(9, sizeL);                     // set sizeL to the first ? at location 9
            ps.setInt(10, sizeXL);                   // set sizeXL to the first ? at location 10
            ps.setInt(11, maxProductID);             // set maxProductID to the first ? at location 11
            rs = ps.executeQuery();                  // the same with click to "excute" btn;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   /**
     * This function use parameter to update a product.
     * @param id product id
     * @param title Product title
     * @param importPrice Import price of product
     * @param price Sale price of product
     * @param salePercent Percent sale off
     * @param decript Description of product
     * @param sizeS Size S
     * @param sizeM Size M
     * @param sizeL Size L
     * @param sizeXL Size XL
     * @param cID Category ID
     */
    public void updateProduct(String id, String title, int importPrice, int price,
            int salePercent, String decript, int sizeS, int sizeM, int sizeL, int sizeXL, int cID) {
        // your query to excute in SQL
        String query = "update Product\n"
                + "set product_tittle = ?,\n"
                + "product_import_price = ?,\n"
                + "product_price = ?,\n"
                + "product_sale_percent = ?,\n"
                + "product_disciption = ?,\n"
                + "catelogy_id = ?\n"
                + "where product_id = ?;\n"
                + "update ProductSize\n"
                + "set product_size_s = ?,\n"
                + "product_size_m = ?,\n"
                + "product_size_l = ?,\n"
                + "product_size_xl = ?\n"
                + "where product_id = ?;";
        try {
            con = new DBContext().getConnection();   // open connection to SQL
            ps = con.prepareStatement(query);        // move query from Netbeen to SQl
            ps.setString(1, title);                  // set title to ? at location 1
            ps.setInt(2, importPrice);               // set importPrice to ? at location 2
            ps.setInt(3, price);                     // set price to ? at location 3
            ps.setInt(4, salePercent);               // set salePercent to ? at location 4
            ps.setString(5, decript);                // set decript to ? at location 5
            ps.setInt(6, cID);                       // set cID to ? at location 6
            ps.setInt(7, Integer.parseInt(id));      // set id to ? at location 7
            ps.setInt(8, sizeS);                     // set sizeS to ? at location 8
            ps.setInt(9, sizeM);                     // set sizeM to ? at location 9
            ps.setInt(10, sizeL);                    // set sizeL to ? at location 10
            ps.setInt(11, sizeXL);                   // set sizeXL to ? at location 111
            ps.setInt(12, Integer.parseInt(id));     // set id to ? at location 12
            rs = ps.executeQuery();                  // the same with click to "excute" btn
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Check product exist by title. This function use title product already exist
     * @param insertTitle title need check
     * @return true if title already exist, false if not exist
     */
    public boolean checkProductExistByTitle(String insertTitle) {
        ProductDAO bdao = new ProductDAO();
        List<Product> list = bdao.getListProduct();
        for (Product p : list) {
            if (p.getTitle().equalsIgnoreCase(insertTitle)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Get product in a page
     * This function get 20 product in a page, 1-20 product last page
     * @param currentPage page
     * @return {list}[product] list product
     */
    public List<Product> paggingProduct(int currentPage) {
        List<Product> list = new ArrayList<>();
        // your query to excute in SQL
        String query = "SELECT p.product_id, p.product_tittle, p.product_import_price, \n"
                + "p.product_price, p.product_sale_percent, p.product_disciption, \n"
                + "ps.product_size_s, ps.product_size_m, ps.product_size_l, \n"
                + "ps.product_size_xl, p.catelogy_id \n"
                + "From Product p, ProductSize ps\n"
                + "WHERE P.product_id = ps.product_id\n"
                + "ORDER BY p.product_id DESC\n"
                + "OFFSET ? ROWS FETCH NEXT 20 ROWS ONLY;";
        try {
            con = new DBContext().getConnection();   // open connection to SQL
            ps = con.prepareStatement(query);        // move query from Netbeen to SQl
            ps.setInt(1, ((currentPage - 1) * 20));  // set OFFSET value into the first ?
            rs = ps.executeQuery();                  // the same with click to "excute" btn
            while (rs.next()) { 
                list.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7) + rs.getInt(8) + rs.getInt(9) + rs.getInt(10),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getInt(11)
                ));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Get max product ID
     * @return Integer product ID
     */
    public int getMaxProductID() {
        // your query to excute in SQL
        String query = "select max(product_id) from Product;";
        try {
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query);      // move query from Netbeen to SQl
            rs = ps.executeQuery();                // the same with click to "excute" btn
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return -1;
    }

    /**
     * Get total product
     * @return Integer total of product
     */
    public int getTotalProduct() {
         // your query to excute in SQL
        String query = "select COUNT(*) from Product;";
        try {
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query);      // move query from Netbeen to SQl
            rs = ps.executeQuery();                // the same with click to "excute" btn
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return -1;
    }
}
