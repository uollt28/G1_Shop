package dao;

import context.DBContext;
import entity.Orders;
import entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Trần Đăng Khoa - CE160367
 */
public class OrdersDAO {

    Connection con = null;          // connect to SQL server
    PreparedStatement ps = null;    // move query from Netbeen to SQl
    ResultSet rs = null;            // save result query

    /**
     * To get list of all orders that is ordered for loading.
     * @return list of all ordered orders.
     */
    public List<Orders> getListOrders() {
        try {
            // your query to excute in SQL
            String query = "select o.order_id, o.customer_id, c.product_id, c.size, "
                    + "c.quantity, o.order_status, o.order_date, o.note \n"
                    + "from Orders o, Cart c \n"
                    + "where o.order_id = c.order_id and o.order_id <> 1 \n"
                    + "order by o.order_id desc;";
            con = new DBContext().getConnection();  // open connection to SQL
            ps = con.prepareStatement(query);       // move query from Netbeen to SQl
            rs = ps.executeQuery();                 // the same with click to "excute" btn;
            List<Orders> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new Orders(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                ));
            }
            return list;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    /**
     * To get list of order by order id.
     * @param oID id of order for getting.
     * @return list of order by order id.
     */
    public List<Orders> getListOrdersByID(String oID) {
        try {
            // your query to excute in SQL
            String query = "select o.order_id, o.customer_id, c.product_id, c.size, c.quantity,"
                    + " o.order_status, o.order_date, o.note \n"
                    + "from Orders o, Cart c\n"
                    + "where o.order_id = c.order_id and o.order_id = ?;";
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query);      // move query from Netbeen to SQl
            ps.setString(1, oID);                  // set oID  to the first ?
            rs = ps.executeQuery();                // the same with click to "excute" btn;
            List<Orders> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new Orders(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                ));
            }
            return list;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    /**
     * To get list of orders by range of date for searching
     * @param beginDate the passed begin date in range
     * @param endDate the passed end date in range
     * @return list of orders by range of date
     */
    public List<Orders> filtterOrdersByDate(String beginDate, String endDate) {
        try {
            // your query to excute in SQL
            String query = "select o.order_id, o.customer_id, c.product_id, c.size, c.quantity,"
                    + " o.order_status, o.order_date, o.note \n"
                    + "from Orders o, Cart c\n"
                    + "where o.order_id = c.order_id and o.order_id <> 1 and o.order_date between ? and ? \n"
                    + "Order by o.order_date desc;";
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query);      // move query from Netbeen to SQl
            ps.setString(1, beginDate);            // set beginDate to the first ?
            ps.setString(2, endDate);              // set end to the second ?
            rs = ps.executeQuery();                // the same with click to "excute" btn;
            List<Orders> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new Orders(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                ));
            }
            return list;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    /**
     * to get list of order of a specified customer by id.
     * @param cusID id of customer for fitter.
     * @return list of order of a specified customer
     */
    public List<Orders> getListOrdersOfCustomer(String cusID) {
        try {
            // your query to excute in SQL
            String query = "select o.order_id, o.customer_id, c.product_id, c.size, c.quantity, "
                    + "o.order_status, o.order_date, o.note\n"
                    + "from Orders o, Cart c \n"
                    + "where o.order_id = c.order_id and o.order_id <> 1 and o.customer_id = ?\n"
                    + "order by o.order_id desc;";
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query);      // move query from Netbeen to SQl
            ps.setString(1, cusID);                // set cusID to the first ?
            rs = ps.executeQuery();                // the same with click to "excute" btn;
            List<Orders> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new Orders(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                ));
            }
            return list;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    /**
     * to add new order into order list when user ordered.
     * @param date the date when user order.
     * @param order list of products of this order.
     * @param note note when user order.
     */
    public void addNewOrder(String date, List<Orders> order, String note) {
        // your query to excute in SQL
        String query = "insert into Orders values(?,'Processing',?,?)";
        try {
            con = new DBContext().getConnection();  // open connection to SQL
            ps = con.prepareStatement(query);       // move query from Netbeen to SQl
            ps.setString(1, date);                  // set date to the first ?
            ps.setString(2, order.get(0).getCustomer_id()); // set list of orderd product to the second ?
            ps.setString(3, note);                  // set note to the third ?
            rs = ps.executeQuery();                 // the same with click to "excute" btn;
        } catch (Exception e) {
            e.getMessage();
        }
        for (Orders o : order) {
            // get max of order id for adding.
            int order_id = getMaxOrderID();
            // query add new cart.
            query = "update Cart\n"
                    + "set order_id = ?\n"
                    + "where product_id = ? AND customer_id = ? AND size = ? AND quantity = ?";
            try {
                con = new DBContext().getConnection();     // open connection to SQL
                ps = con.prepareStatement(query);          // move query from Netbeen to SQl
                ps.setString(1, String.valueOf(order_id)); // set order_id to the first ?
                ps.setString(2, o.getProduct_id());        // set product_id to the second ?
                ps.setString(3, o.getCustomer_id());       // set customer_id to the third ?
                ps.setString(4, o.getSize());              // set size to the four ?
                ps.setInt(5, o.getQuantity());             // set quantity to the fiveth ?
                rs = ps.executeQuery();                    // the same with click to "excute" btn;
            } catch (Exception e) {
                e.getMessage();
            }
            // update product size when a product is orderd.
            updateSizeProduct(o.getProduct_id(), o.getSize(), o.getQuantity());
        }
    }

    /**
     * to update the product's size when a product is ordered.
     * @param product_id passed product's id to update.
     * @param size passed size to update.
     * @param quantity passed quantity to update.
     */
    public void updateSizeProduct(String product_id, String size, int quantity) {
        int sizeAvailability = getSizeAvailability(product_id, size);
        String querySize = null;
        switch (size) {
            case "S":
                querySize = "update ProductSize\n"
                        + "set product_size_s = ?\n"
                        + "where product_id = ?";
                break;
            case "L":
                querySize = "update ProductSize\n"
                        + "set product_size_l = ?\n"
                        + "where product_id = ?";
                break;
            case "M":
                querySize = "update ProductSize\n"
                        + "set product_size_m = ?\n"
                        + "where product_id = ?";
                break;
            case "XL":
                querySize = "update ProductSize\n"
                        + "set product_size_xl = ?\n"
                        + "where product_id = ?";
                break;
        }
        try {
            con = new DBContext().getConnection();     // open connection to SQL
            ps = con.prepareStatement(querySize);      // move query from Netbeen to SQl
            ps.setInt(1, sizeAvailability - quantity); // set new quantity of product to the first ?
            ps.setString(2, product_id);               // set product id to the second ?
            rs = ps.executeQuery();                    // the same with click to "excute" btn;
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /**
     * to get max id of order list for adding into order.
     * @return max id of order list.
     */
    public int getMaxOrderID() {
        int id = -1;
        // your query to excute in SQL
        String query = "select top 1 order_id from Orders order by order_id DESC;";
        try {
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query);      // move query from Netbeen to SQl
            rs = ps.executeQuery();                // the same with click to "excute" btn;
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return id;
    }

    /**
     * To check whether an order is availability or not.
     * @param order list of order to check.
     * @return the status is availability or not.
     */
    public boolean checkOrderAvailability(ArrayList<Orders> order) {
        boolean check = true;
        for (Orders o : order) {
            if (!checkExitWhenOrder(o.getProduct_id(), o.getSize(), o.getQuantity())) {
                check = false;
                break;
            }
        }
        return check;
    }

    /**
     * To get size is availability or not.
     * @param product_id passed id of product to check.
     * @param size passed size of product to check.
     * @return number of product that is availability.
     */
    public int getSizeAvailability(String product_id, String size) {
        int num = -1;
        String query = null;
        // your query to excute in SQL
        switch (size) {
            case "S":
                query = "select product_size_s from ProductSize where product_id = ?";
                break;
            case "L":
                query = "select product_size_l from ProductSize where product_id = ?";
                break;
            case "M":
                query = "select product_size_m from ProductSize where product_id = ?";
                break;
            case "XL":
                query = "select product_size_xl from ProductSize where product_id = ?";
                break;
        }
        try {
            con = new DBContext().getConnection();     // open connection to SQL
            ps = con.prepareStatement(query);          // move query from Netbeen to SQl
            ps.setInt(1, Integer.parseInt(product_id));// set product_id of product to the first ? 
            rs = ps.executeQuery();                    // the same with click to "excute" btn;
            while (rs.next()) {
                num = rs.getInt(1);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return num;
    }

    /**
     * to check whether an order is exist when user ordered or not.
     * @param product_id passed id of product to check.
     * @param size passed size of product to check.
     * @param quantity passed quantity of product to check.
     * @return status of order is ordered or not.
     */
    public boolean checkExitWhenOrder(String product_id, String size, int quantity) {
        int num = getSizeAvailability(product_id, size);
        System.out.println("Availabible: " + product_id + " : " + num + " : " + quantity);
        if (num < quantity) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * To get the current date when user order.
     * @return current date when user order.
     */
    public String getTodayDate() {
        return String.valueOf(java.time.LocalDate.now());
    }

    /**
     * To get number of product of a specified order.
     * @param list list of orders that contains the same id. 
     * @return the number of product in an order.
     */
    public int getOrderQuantity(List<Orders> list) {
        int listLength = list.size();
        int orderQuantity;
        if (listLength == 0) {
            orderQuantity = 0;
        } else {
            orderQuantity = 1;
        }
        for (int i = 0; i < listLength - 1; i++) {
            if (list.get(i).getId().equals(list.get(i + 1).getId())) {
                continue;
            } else {
                orderQuantity++;
            }
        }
        return orderQuantity;
    }

    /**
     * To delete an order by passed order id.
     * @param oID passed id of an order.
     */
    public void deleteOrders(String oID) {
        // your query to excute in SQL
        String query = "delete from Orders where order_id = ?;";
        try {
            con = new DBContext().getConnection();  // open connection to SQL
            ps = con.prepareStatement(query);       // move query from Netbeen to SQl
            ps.setString(1, oID);                   // set oID get from servelet to ?
            rs = ps.executeQuery();                 // the same with click to "excute" btn;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * To update status of order_id in cart when it is ordered.
     * @param oID new id of order when it is ordered.
     */
    public void updateOrderIDOfCart(String oID) {
        // your query to excute in SQL
        String query = "update Cart set order_id = null where order_id = ?";
        try {
            con = new DBContext().getConnection();   // open connection to SQL
            ps = con.prepareStatement(query);        // move query from Netbeen to SQl
            ps.setString(1, oID);                    // set oID get from servelet to ?
            ps.executeUpdate();                      // the same with click to "excute" btn;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * To get total of expenses of list orders. 
     * @param list passed list of order.
     * @return total of expenses of list orders.
     */
    public long getTotalExpenes(List<Orders> list) {
        long expenses = 0;
        ProductDAO pdao = new ProductDAO();
        for (Orders o : list) {
            String pID = o.getProduct_id();
            Product p = pdao.getProductIByID(pID);
            expenses += p.getImportPrice() * o.getQuantity();
        }
        return expenses;
    }

    /**
     * To get total of revenue of list orders. 
     * @param list passed list of order.
     * @return total of revenue of list orders.
     */
    public long getTotalRevenue(List<Orders> list) {
        long revenue = 0;
        // default ship fee.
        int shipFee = 30000; 
        ProductDAO pdao = new ProductDAO();
        for (Orders o : list) {
            String pID = o.getProduct_id();
            Product p = pdao.getProductIByID(pID);
            revenue += o.getTotalPrice() + shipFee;
        }
        return revenue;
    }

    /**
     * To get list of order is distinct. It's total of price for all product is ordered in list.
     * @param list passed list of order that contains products.
     * @return list of order is distinct for showing with user.
     */
    public List<Orders> getListOrderDistinct(List<Orders> list) {
        int totalPrice = 0;
        // loop to each order to check.
        for (int i = 0; i <= list.size() - 1; i++) {
            // set up the quantity of product default is 1
            int numberProduct = 1;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).getId().equals(list.get(j).getId())) {
                    // get total price of product is the same order id.
                    totalPrice += list.get(j).getPrice() * list.get(j).getQuantity();
                    // set total price for previous product.
                    list.get(i).setTotalPrice(list.get(i).getPrice() * list.get(i).getQuantity() + totalPrice);
                    // remove the product is the smae order id after set pirce into total.
                    list.remove(j);
                    j--;
                    numberProduct++;
                }
            }
            totalPrice = 0;
            // in case the order contains one product only.
            if (list.get(i).getTotalPrice() == 0) {
                // get to total price.
                list.get(i).setTotalPrice(list.get(i).getPrice() * list.get(i).getQuantity());
            }
            // set new numnber of product.
            list.get(i).setNumberProduct(numberProduct);
        }
        return list;
    }

    /**
     * To get the newest order in order list.
     * @param maxID max id of the newest order.
     * @return the newest order that contains products is ordered.
     */
    public List<Orders> getNewestOrder(int maxID) {
        try {
            // your query to excute in SQL
            String query = "select o.order_id, o.customer_id, c.product_id, c.size, c.quantity, "
                    + "o.order_status, o.order_date, o.note\n"
                    + "from Orders o, Cart c\n"
                    + "where o.order_id = c.order_id and o.order_id = ?;";
            con = new DBContext().getConnection();  // open connection to SQL
            ps = con.prepareStatement(query);       // move query from Netbeen to SQl
            ps.setInt(1, maxID);                    // set maxID of product to the first ?
            rs = ps.executeQuery();                 // the same with click to "excute" btn;
            List<Orders> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new Orders(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                ));
            }
            return list;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }
}
