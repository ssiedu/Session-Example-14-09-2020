import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class VerifyUser extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //we are storing the app-name to context object
        
        //fetch-the-context-object
        ServletContext context=getServletContext();
        //to-store-something-to-this-context-object
        context.setAttribute("appname", "Global-Info-App");
        
        //read the request
        String id=request.getParameter("t1");
        //process the request
        if(id.equalsIgnoreCase("abc") || id.equalsIgnoreCase("xyz") || id.equalsIgnoreCase("pqr")){
            
            //storing the userid to session so that it will be available for other servlets also.
            
            //step-1 (fetch the session object created for this user)
            HttpSession session=request.getSession();
            //step-2 (store the data to this session object by using a method called setAttribute)
            session.setAttribute("userid", id);
            session.setAttribute("loginTime", new java.util.Date());
            //session.putValue("userid", id);
            response.sendRedirect("dashboard.jsp");
        }else{
            PrintWriter out=response.getWriter();
            out.println("Invalid Account");
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
