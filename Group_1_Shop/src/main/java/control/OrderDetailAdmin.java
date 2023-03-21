package control;

import dao.CustomerDAO;
import dao.OrdersDAO;
import entity.Customer;
import entity.Orders;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author Trần Đăng Khoa - CE160367
 */
@WebServlet(name = "OrderDetailAdmin", urlPatterns = {"/orderDetailAdmin"})
public class OrderDetailAdmin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String orderID = request.getParameter("orderID");
        String cusID = request.getParameter("cusID");
        
        CustomerDAO cdao = new CustomerDAO();
        Customer cus = cdao.getCustomerByID(Integer.parseInt(cusID));
        
        OrdersDAO odao = new OrdersDAO();
        List<Orders> listOrders = odao.getListOrdersByID(orderID);
        
        int totalPrice = 0;
        for (Orders c : listOrders) {
            totalPrice += c.getPrice() * c.getQuantity();
        }
        request.setAttribute("listOrder", listOrders);
        request.setAttribute("orderID", orderID);
        request.setAttribute("customer", cus);
        request.setAttribute("totalPrice", totalPrice);
        request.getRequestDispatcher("OrdersDetailAdmin.jsp").forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
