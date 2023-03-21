package dao;

import context.DBContext;
import entity.Cryptography;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import entity.Customer;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;

/**
 *
 * @author Lê Khanh Băng - CE160155
 */
public class CustomerDAO {

    Connection con = null;                 // connect to SQL server
    PreparedStatement ps = null;           // move query from Netbeen to SQl
    ResultSet rs = null;                   // save result query
    Cryptography cry = new Cryptography(); // for encrypt phone and password of an account

    /**
     * Function get list of customer
     * @return list of customer
     */
    public List<Customer> getListCustomer() {
        List<Customer> list = new ArrayList<>();
        try {
            // your query to excute in SQL
            String query = "select * from Customer order by customer_id DESC;";       
            con = new DBContext().getConnection();          // open connection to SQL
            ps = con.prepareStatement(query);               // move query from Netbeen to SQl
            rs = ps.executeQuery();                         // the same with click to "excute" btn;
            while (rs.next()) {
                list.add(new Customer(rs.getInt(1),
                        cry.decrypt(rs.getString(2), 123456),
                        cry.decrypt(rs.getString(3), 123456),
                        cry.decrypt(rs.getString(4), 123456),
                        rs.getInt(5)));
            }
            return list;
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

    /**
     * Function search customer by name
     * @param name that user want to find
     * @return name of customer
     */
    public List<Customer> SearchCustomerByName(String name) {
        List<Customer> listCus = this.getListCustomer();
        List<Customer> listResult = new ArrayList<>();
        for (Customer c : listCus) {
            if (c.getName().toLowerCase().contains(name.toLowerCase())) {
                listResult.add(new Customer(c.getID(), c.getName(), c.getEmail(), c.getAddress(), c.getAccountID()));
            }
        }
        return listResult;
    }

    /**
     * Function delete customer by Id
     * @param cID Id of customer is passed
     */
    public void deleteCustomerByID(String cID) {
        AccountDAO adao = new AccountDAO();
        // get id of customer.
        int aID = adao.getAccountIDByCustomerID(Integer.parseInt(cID));
        // your query to excute in SQL
        String query = "delete from Cart where customer_id = ?\n"
                + "delete from Orders where customer_id = ?\n"
                + "delete from Customer where customer_id = ?\n"
                + "delete from Account where account_id = ?";
        try {
            con = new DBContext().getConnection();   // open connection to SQL
            ps = con.prepareStatement(query);        // move query from Netbeen to SQl
            ps.setInt(1, Integer.parseInt(cID));     // set customer id get from servelet to ?
            ps.setInt(2, Integer.parseInt(cID));     // set customer id get from servelet to ?
            ps.setInt(3, Integer.parseInt(cID));     // set customer id get from servelet to ?
            ps.setInt(4, aID);                       // set account id get from servelet to ?
            rs = ps.executeQuery();                  // the same with click to "excute" btn;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Function get name of customer by account
     * @param aID Id account of customer
     * @return name of customer that have this account
     */
    public String getCustomerNameByAccountID(int aID) {
        CustomerDAO cdao = new CustomerDAO();
        List<Customer> list = cdao.getListCustomer();
        for (Customer c : list) {
            if (c.getAccountID() == aID) {
                return c.getName();
            }
        }
        return null;
    }

   /**
     * Function get customer by account
     * @param aID Id account of customer
     * @return customer that have this account
     */
    public Customer getCustomerByAccountID(int aID) {
        CustomerDAO cdao = new CustomerDAO();
        List<Customer> list = cdao.getListCustomer();
        for (Customer c : list) {
            if (c.getAccountID() == aID) {
                return c;
            }
        }
        return null;
    }

    /**
     * Function get customer by id
     * @param cID Id of customer
     * @return customer that have this id
     */
    public Customer getCustomerByID(int cID) {
        CustomerDAO cdao = new CustomerDAO();
        List<Customer> list = cdao.getListCustomer();
        for (Customer c : list) {
            if (c.getID() == cID) {
                return c;
            }
        }
        return null;
    }

    /**
     * Function update information of customer
     * @param name name of customer
     * @param email email of customer
     * @param phone phone of customer
     * @param pass password of account 
     * @param address address of customer
     * @param accID accID of customer
     */
    public void updateCustomerInfo(String name, String email, String phone, String pass, String address, String accID) {
        Customer c = this.getCustomerByAccountID(Integer.parseInt(accID));
        String cusID = String.valueOf(c.getID());
        // your query to excute in SQL
        String query = "update Customer\n"
                + "set customer_fullName = ?,\n"
                + "customer_email = ?,\n"
                + "customer_address = ?\n"
                + "where customer_id = ?;\n"
                + "\n"
                + "update Account\n"
                + "set account_phone = ?,\n"
                + "account_password = ?\n"
                + "where account_id = ?;";
        try {
            con = new DBContext().getConnection();          // open connection to SQL
            ps = con.prepareStatement(query);               // move query from Netbeen to SQl
            ps.setString(1, cry.encrypt(name, 123456));     // set name get from servelet to ? with encyption
            ps.setString(2, cry.encrypt(email, 123456));    // set email get from servelet to ? with encyption
            ps.setString(3, cry.encrypt(address, 123456));  // set address get from servelet to ? with encyption
            ps.setString(4, cusID);                         // set cusID get from servelet to ?
            ps.setString(5, cry.encrypt(phone, 123456));    // set phone get from servelet to ? with encyption
            ps.setString(6, cry.encrytMD5(pass));           // set pass get from servelet to ? with encyption
            ps.setString(7, accID);                         // set accID get from servelet to ?
            ps.executeUpdate();                             // the same with click to "excute" btn;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     /**
     * Function create verification code for authentication email when register
     * @return verification code with 6 random digits 
     */
    public String generateRandomCode() {
        Random r = new Random();
        int number = r.nextInt(999999);
        return String.format("%06d", number);
    }

     /**
     * Function verify customer email
     * @param toEmail email of customer
     * @param randomCode verification code sent to customer
     * @return completion or not completion
     */
    public boolean sendEmailAuthen(String toEmail, String randomCode) {
        final String formEmail = "group1shop.fpt@gmail.com";
        final String password = "gzqoghcnqnoqmsxa";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop,
                new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(formEmail, password);
            }
        });

        try {
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setHeader("Content-Type", "text/plain; charset=UTF-8");
            mimeMessage.setFrom(new InternetAddress(formEmail));
            mimeMessage.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(toEmail)
            );
            mimeMessage.setSubject("[Group1Shop] XÁC THỰC ĐỊA CHỈ EMAIL", "utf-8");
            mimeMessage.setContent("<h4>Xin Chào <b>" + toEmail + "</b>,</h4>"
                    + "\n<h4>Bạn vui lòng xác thực email để hoàn tất đăng kí tài khoản. </h4>"
                    + "\n<h4>Mã xác thực 6 số của bạn là: <font color=red> " + randomCode + "</font></h4>"
                    + "\n<br><h4>Trân trọng,</h4>"
                    + "\n<h4>Group1Shop</h4>",
                    "text/html; charset=UTF-8");

            Transport.send(mimeMessage);

            System.out.println("Done");
            return true;

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Function notice of successful order
     * @param fulllName name of user
     * @param toEmail email of user
     * @param phone phone of user
     * @param address address of user
     * @param oID id of ordering
     * @param status status of ordering
     * @param quantity quantity of ordering
     * @param shipFee fee of ship
     * @param total total order value
     */
    public void sendEmailOrderSuccess(String fulllName, String toEmail, String phone, String address, String oID, String status, int quantity, int shipFee, long total) {
        final String formEmail = "group1shop.fpt@gmail.com";
        final String password = "gzqoghcnqnoqmsxa";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop,
                new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(formEmail, password);
            }
        });

        try {
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setHeader("Content-Type", "text/plain; charset=UTF-8");
            mimeMessage.setFrom(new InternetAddress(formEmail));
            mimeMessage.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(toEmail)
            );
            mimeMessage.setSubject("[Group1Shop] ĐẶT HÀNG THÀNH CÔNG", "utf-8");
            mimeMessage.setContent("<span>Xin Chào <b>" + fulllName + ",</b></span>"
                    + "<span> Group1Shop store xác nhận đơn hàng của quí khách đã được đặt thành công. </span>"
                    + "<h4>#Thông tin khách hàng:</h4>"
                    + "_Tên khách hàng: " + fulllName
                    + "<br>_Số điện thoại: " + phone
                    + "<br>_Email: " + toEmail
                    + "<br>_Đia chỉ: " + address
                    + "<h4>#Thông tin đơn hàng:</h4>"
                    + "_Mã đơn hàng: " + oID
                    + "<br>_Trạng thái: " + status
                    + "<br>_Số lượng sản phẩm: " + quantity
                    + "<br>_Phí vận chuyển: " + shipFee + " đ"
                    + "<br>_Hình thức thanh toán: Ship code(Thanh toán khi nhận hàng)"
                    + "<br><span>_Tổng tiền: <b><font color=red> " + (total + shipFee) + " đ</font></b></span><br>"
                    + "<br><span>Group1Shop rất cảm ơn quí khách đã tin tưởng và đặt hàng. Đơn hàng sẽ được xử lí và giao đến quí khác trong 3-7 ngày."
                    + " Lưu ý: Mọi thắc mắc cần tư vấn về sản phẩm hay đơn hàng. Xin vui lòng liên hệ <b>Hotline: 0933.782.768.</b></h4>"
                    + "<h4>Trân trọng,</span>"
                    + "<h4>Group1Shop</h4>",
                    "text/html; charset=UTF-8");

            Transport.send(mimeMessage);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
