package control;

import dao.CustomerDAO;
import dao.OrdersDAO;
import entity.Account;
import entity.Customer;
import entity.Orders;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author Lê Trung Uôl - CE160438
 */
@WebServlet(name = "LoadOrderDetail", urlPatterns = {"/loadOrderDetail"})
public class LoadOrderDetail extends HttpServlet {

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
        String oID = request.getParameter("oID");
        HttpSession session = request.getSession();
        Account acc = (Account) session.getAttribute("accountSeesion");

        CustomerDAO cdao = new CustomerDAO();
        Customer cus = cdao.getCustomerByAccountID(acc.getID());
        
        OrdersDAO odao = new OrdersDAO();
        List<Orders> listOrdersOfCus = odao.getListOrdersByID(oID);
        
        int totalPrice = 0;
        for (Orders c : listOrdersOfCus) {
            totalPrice += c.getPrice()* c.getQuantity();
        }
        request.setAttribute("listOrderOfCustomer", listOrdersOfCus);
        request.setAttribute("orderID", oID);
        request.setAttribute("customer", cus);
        request.setAttribute("totalPrice", totalPrice);
        request.getRequestDispatcher("OrderDetail.jsp").forward(request, response);
        
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
