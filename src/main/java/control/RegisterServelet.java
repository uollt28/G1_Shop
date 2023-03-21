package control;

import dao.AccountDAO;
import dao.CustomerDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import entity.Account;

/**
 *
 * @author Lê Khanh Băng - CE160155
 */
public class RegisterServelet extends HttpServlet {

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
        request.removeAttribute("accountExitMessage");

        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        AccountDAO adao = new AccountDAO();
        Account account = adao.checkAccountExist(phone);

        if (account == null) { // is signed up
            CustomerDAO cdao = new CustomerDAO();
            String randomCode = cdao.generateRandomCode();
            if (cdao.sendEmailAuthen(email, randomCode)) {
                request.setAttribute("phone", phone);
                request.setAttribute("password", password);
                request.setAttribute("fullName", fullName);
                request.setAttribute("address", address);
                
                request.setAttribute("email", email);
                request.setAttribute("randomCode", randomCode);
                request.setAttribute("countFailedAuthen", 0);
                request.getRequestDispatcher("AuthenEmail.jsp").forward(request, response);
            } else {
                request.setAttribute("accountExitMessage", "Địa chỉ email không tồn tại! Vui lòng nhập địa chỉ mới!!!");
                request.getRequestDispatcher("Register.jsp").forward(request, response);
            }
        } else { // is not signed up
            request.setAttribute("accountExitMessage", "Tài khoản đã tồn tại. Vui lòng tạo tài khoản mới!");
            request.getRequestDispatcher("Register.jsp").forward(request, response);
        }

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
