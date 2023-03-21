package control;

import dao.AccountDAO;
import entity.Account;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * @author Lê Khanh Băng - CE160155
 */
@WebServlet(name = "AuthenEmail", urlPatterns = {"/authenEmail"})
public class AuthenEmail extends HttpServlet {

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
        String authenCode = request.getParameter("randomCode");
        String inputCode = request.getParameter("inputCode");

        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int countFailedAuthen = Integer.parseInt(request.getParameter("countFailedAuthen"));

        AccountDAO adao = new AccountDAO();
        Account account = adao.checkAccountExist(phone);

        if (inputCode.equals(authenCode)) {
            adao.registerAccount(phone, password);
            adao.registerCustomer(fullName, email, address, adao.getMaxIDOfAccount());
            HttpSession seesion = request.getSession();
            seesion.setAttribute("accountSeesion", account);
            request.setAttribute("registerSuccess", true);
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        } else {
            request.setAttribute("isValidCode", false);
            request.setAttribute("phone", phone);
            request.setAttribute("password", password);
            request.setAttribute("fullName", fullName);
            request.setAttribute("address", address);
            request.setAttribute("email", email);
            countFailedAuthen++;
            request.setAttribute("countFailedAuthen", countFailedAuthen);
            if (countFailedAuthen >= 3) {
                response.sendRedirect("home");
            } else {
                request.getRequestDispatcher("AuthenEmail.jsp").forward(request, response);
            }
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
