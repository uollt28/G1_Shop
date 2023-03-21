package control;

import dao.CartDAO;
import dao.CustomerDAO;
import dao.OrdersDAO;
import entity.Cart;
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
 * @author Huỳnh Hữu Nghĩa - CE160343 
 */
@WebServlet(name = "PayingHanlder", urlPatterns = {"/orderHandler"})
public class OrderHandler extends HttpServlet {

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
        OrdersDAO odao = new OrdersDAO();
        
        String orderDate = odao.getTodayDate();
        String orderNote = request.getParameter("note");
        String email  = request.getParameter("email");
        String fullName = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        HttpSession session = request.getSession();
        
        String cID = "" ;
        String status = "Processcing";
        int quantity = 0;
        long total = 0;
        int shipFee = 30000;
        
        List<Orders> listOrder = (List)session.getAttribute("listOrderSesion");
        
        odao.addNewOrder(orderDate, listOrder, orderNote);
        
        int maxOID = odao.getMaxOrderID();
        List<Orders> tempList = odao.getNewestOrder(maxOID);
        List<Orders> list = odao.getListOrderDistinct(tempList);
        
        for (Orders o : list) {
            cID = o.getCustomer_id();
            quantity = o.getNumberProduct();
            total = o.getTotalPrice();
        }
        
        CustomerDAO cdao = new CustomerDAO();
        cdao.sendEmailOrderSuccess(fullName, email, phone, address, String.valueOf(maxOID), status, quantity, shipFee, total);
        
        
        CartDAO cartdao = new CartDAO();
        List<Cart> listCart = cartdao.getListCartByCustomerID(Integer.parseInt(cID));
        session.setAttribute("listCartSize", listCart.size());
        request.getRequestDispatcher("loadCustomerInfo").forward(request, response);
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
