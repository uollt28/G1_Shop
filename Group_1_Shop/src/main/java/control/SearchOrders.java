package control;

import dao.CustomerDAO;
import dao.OrdersDAO;
import dao.ProductDAO;
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
@WebServlet(name = "SearchOrders", urlPatterns = {"/searchOrders"})
public class SearchOrders extends HttpServlet {

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
        String oID = request.getParameter("txtSearch");
        
        OrdersDAO odao = new OrdersDAO();

        ProductDAO pdao = new ProductDAO();
        List<Orders> list = odao.getListOrdersByID(oID);
       
        long expenses = 0, revenue = 0, profit = 0;
        
        expenses = odao.getTotalExpenes(list);
        List<Orders> listOrders = odao.getListOrderDistinct(list);
        revenue = odao.getTotalRevenue(list);
        
        profit  = revenue - expenses;
        CustomerDAO cusDao = new CustomerDAO();
        
        List<Customer> listCustomer = cusDao.getListCustomer();
        
        int orderQuantity = odao.getOrderQuantity(list);
        request.setAttribute("listCustomer", listCustomer);
        request.setAttribute("listOrders", listOrders);
        request.setAttribute("orderQuantity", orderQuantity);
        request.setAttribute("expenses", expenses);
        request.setAttribute("revenue", revenue);
        request.setAttribute("profit", profit);
        request.setAttribute("txtOrderIDValue", oID);
        request.getRequestDispatcher("ManageOrders.jsp").forward(request, response);
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
