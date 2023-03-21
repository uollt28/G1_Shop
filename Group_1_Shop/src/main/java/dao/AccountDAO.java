package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import entity.Account;
import entity.Cryptography;

/**
 * @author Lê Khanh Băng - CE160155
 */
public class AccountDAO {

    Connection con = null;                  // connect to SQL server
    PreparedStatement ps = null;            // move query from Netbeen to SQl
    ResultSet rs = null;                    // save result query
    Cryptography cry = new Cryptography();  // for encrypt phone and password of an account

    /**
     * Function get information of account
     * @param phone link with account
     * @param password of account
     * @return account of user or admin
     */
    public Account loginAccount(String phone, String password) {
        // your query to excute in SQL
        String query = "select * from Account where account_phone = ? and account_password = ?;";
        try {
            con = new DBContext().getConnection();       // open connection to SQL
            ps = con.prepareStatement(query);            // move query from Netbeen to SQl
            ps.setString(1, cry.encrypt(phone, 123456)); // set phone to the first ? with encyption
            ps.setString(2, cry.encrytMD5(password));    // set password to the second ? with encyption
            rs = ps.executeQuery();                      // excute the query to update table account.
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        cry.decrypt(rs.getString(2), 123456),
                        rs.getString(3),
                        rs.getInt(4));
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

     /**
     * Function check account that is exit
     * @param phone link with account
     * @return account of user in database
     */
    public Account checkAccountExist(String phone) {
        // your query to excute in SQL
        String query = "select * from Account where account_phone = ?;";
        try {
            con = new DBContext().getConnection();       // open connection to SQL
            ps = con.prepareStatement(query);            // move query from Netbeen to SQl
            ps.setString(1, cry.encrypt(phone, 123456)); // set phone to the first ? with encyption
            rs = ps.executeQuery();                      // excute the query to update table account.
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4));
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

     /**
     * Function get id of the last customer in database
     * @return id of the last customer in database
     */
    public int getMaxIDOfAccount() {
        // your query to excute in SQL
        String query = "select top 1 account_id from Account order by account_id DESC;";
        try {
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query);      // move query from Netbeen to SQl
            rs = ps.executeQuery();                // excute query and assign to result.
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return -1;
    }

     /**
     * Function get id of account by id of customer
     * @param customerID id of customer
     * @return id of account
     */
    public int getAccountIDByCustomerID(int customerID) {
        // your query to excute in SQL
        String query = "select top 1 account_id from Customer where customer_id = ?";
        try {
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query);      // move query from Netbeen to SQl
            ps.setInt(1, customerID);              // set customer id to the first.
            rs = ps.executeQuery();                // excute query and assign to result.
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return -1;
    }

    
    /**
     * function register account
     * @param phone link with account
     * @param password of account
     */
    public void registerAccount(String phone, String password) {
        // your query to excute in SQL
        String query = "insert into Account values(?, ? , 3); ";
        try {
            con = new DBContext().getConnection();       // open connection to SQL
            ps = con.prepareStatement(query);            // move query from Netbeen to SQl
            ps.setString(1, cry.encrypt(phone, 123456)); // set phone to the first ?.
            ps.setString(2, cry.encrytMD5(password));    // set password to the second ?.
            ps.executeUpdate();                          // excute the query to update table account.
        } catch (Exception e) {
        }
    }

    /**
     * function register information of user
     * @param fullname full name of user
     * @param email email of user
     * @param address address of user
     * @param maxAccountID id of account link with this information
     */
    public void registerCustomer(String fullname, String email, String address, int maxAccountID) {
        // your query to excute in SQL
        String query = "insert into Customer values(?, ? , ?, ?);";
        try {
            con = new DBContext().getConnection();          // open connection to SQL
            ps = con.prepareStatement(query);               // move query from Netbeen to SQl
            ps.setString(1, cry.encrypt(fullname, 123456)); // set fullname to the first ? with encyption.
            ps.setString(2, cry.encrypt(email, 123456));    // set email to the second ? with encyption.
            ps.setString(3, cry.encrypt(address, 123456));  // set address to the third ? with encyption.
            ps.setInt(4, maxAccountID);                     // set maxAccountID to the four ?.
            ps.executeUpdate();                             // excute the query to update table account.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Function get list of account
     * @return list of account
     */
    public List<Account> getListOfAccount() {
        List<Account> list = new ArrayList<>();
        try {
            // your query to excute in SQL
            String query = "select * from Account order by account_id DESC;";       
            con = new DBContext().getConnection();          // open connection to SQL
            ps = con.prepareStatement(query);               // move query from Netbeen to SQl
            rs = ps.executeQuery();                         // the same with click to "excute" btn;
            while (rs.next()) {
                list.add(new Account(rs.getInt(1), cry.decrypt(rs.getString(2), 123456), rs.getString(3), rs.getInt(4)));
            }
            return list;
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

    /**
     * Function delete account by id
     * @param aID Id of account for deleting
     */
    public void deleteAccount(String aID) {
        // your query to excute in SQL
        String query = "delete from Account where account_id = ?;";
        try {
            con = new DBContext().getConnection();   // open connection to SQL
            ps = con.prepareStatement(query);        // move query from Netbeen to SQl
            ps.setString(1, aID);                    // set categoryID get from servelet to ?
            rs = ps.executeQuery();                  // the same with click to "excute" btn;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Function get id of account by phone number
     * @param phone phone link with account
     * @return id of account by passed phone
     */
    public int getAccountIDByPhone(String phone) {
        AccountDAO adao = new AccountDAO();
        List<Account> list = adao.getListOfAccount();
        for (Account a : list) {
            if (a.getPhone().equals(phone)) {
                return a.getID();
            }
        }
        return -1;
    }
    
    /**
     * Function get account by id
     * @param id id of account
     * @return account of customer
     */
    public Account getAccountByAccountID(String id) {
        // your query to excute in SQL
        String query = "select * from Account where account_id = ?;";
        try {
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query);      // move query from Netbeen to SQl
            ps.setString(1, id);                   // set phone to the first ?
            rs = ps.executeQuery();                // excute the query to update table account.
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        cry.decrypt(rs.getString(2),123456),
                        rs.getString(3),
                        rs.getInt(4));
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }
    
    /**
     * Function check phone that is existed or not existed
     * @param phone phone of user
     * @param accID id of account
     * @return phone that is existed or not existed
     */
    public boolean checkPhoneExist(String phone, int accID) {
        AccountDAO adao = new AccountDAO();
        List<Account> list = adao.getListOfAccount();
        for (Account acc : list) {
            if (acc.getID() == accID) {
                continue;
            } else {
                if (acc.getPhone().equals(phone)) {
                    return true;
                }
            }
        }
        return false;
    }
}
