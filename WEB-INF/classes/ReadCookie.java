import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ReadCookie extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        Cookie[] cookies = request.getCookies();
        
        String firstName = "Non défini";
        String lastName = "Non défini";
        String birthDay = "Non défini";
        String sex = "Non défini";
        
        
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("firstName")) {
                    firstName = cookie.getValue();
                } else if (cookie.getName().equals("lastName")) {
                    lastName = cookie.getValue();
                } else if (cookie.getName().equals("birthDay")) {
                    birthDay = cookie.getValue();
                } else if (cookie.getName().equals("Sex")) {
                    sex = cookie.getValue();
                }
            }
        }
        

        // Affichage
        out.println("<html><head><meta charset='UTF-8'></head><body>");
        out.println("<h2>Valeurs des Cookies enregistrés</h2>");
        out.println("<ul>");
        out.println("<li><b>Prénom (firstName) :</b> " + firstName + "</li>");
        out.println("<li><b>Nom (lastName) :</b> " + lastName + "</li>");
        out.println("<li><b>Date de naissance (birthDay) :</b> " + birthDay + "</li>");
        out.println("<li><b>Sexe (Sex) :</b> " + sex + "</li>");
        out.println("</ul>");
        out.println("<br><a href='form.html'>Retour au formulaire</a>");
        out.println("</body></html>");
    }
}