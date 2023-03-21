package control;

import dao.CategoryDAO;
import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import entity.Product;
import entity.Category;

/**
 *
 * @author Huỳnh Hữu Nghĩa - CE160343 
 */
public class SearchServelet extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");    // For search by Vietmamese keyword.

        String txtSearch = request.getParameter("txtSearch").trim();

        ProductDAO pdao = new ProductDAO();
        List<Product> listProduct = pdao.searchProductByTitle(txtSearch);

        CategoryDAO cdao = new CategoryDAO();
        List<Category> listCategory = cdao.getListCategory();

        if (listProduct.isEmpty()) {
            request.setAttribute("noFoundProduct", 0);
        } else {
            request.setAttribute("listProduct", listProduct);
        }
        
        request.setAttribute("listCategory", listCategory);
        request.setAttribute("searchValue", txtSearch);
        request.setAttribute("maxPage", 1);
        request.getRequestDispatcher("Home.jsp").forward(request, response);
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
//        processRequest(request, response);
        request.setCharacterEncoding("UTF-8");    // For search by Vietmamese keyword.

        String txtSearch = request.getParameter("txtSearch");

        ProductDAO pdao = new ProductDAO();
        List<Product> listProduct = pdao.searchProductByTitle(txtSearch);

        CategoryDAO cdao = new CategoryDAO();
        List<Category> listCategory = cdao.getListCategory();

        request.setAttribute("listProduct", listProduct);
        request.setAttribute("listCategory", listCategory);
        request.setAttribute("searchValue", txtSearch);
        request.getRequestDispatcher("manageProduct").forward(request, response);
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
