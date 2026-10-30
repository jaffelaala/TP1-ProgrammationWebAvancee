import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FormServlet extends HttpServlet {
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
	
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        // Recuperation des donnees
        String prenom = request.getParameter("prenom");
        String nom = request.getParameter("nom");
        String dateNaissance = request.getParameter("dateNaissance");
        String sexe = request.getParameter("sexe");
        
      	// Les cookies
        Cookie c1 = new Cookie("firstName", prenom);
        Cookie c2 = new Cookie("lastName", nom);
        Cookie c3 = new Cookie("birthDay", dateNaissance);
        Cookie c4 = new Cookie("Sex", sexe);
        
        
        c1.setMaxAge(60 * 60 * 24);
        c2.setMaxAge(60 * 60 * 24);
        c3.setMaxAge(60 * 60 * 24);
        c4.setMaxAge(60 * 60 * 24);
        
        
        response.addCookie(c1);
        response.addCookie(c2);
        response.addCookie(c3);
        response.addCookie(c4);
        
        //Reponse 
        out.println("<html><head><meta charset='UTF-8'></head><body>");
        out.println("<h2>Résultats du formulaire</h2>");
        out.println("<table border='1' cellpadding='5'>");
        out.println("<tr><th>Champ</th><th>Valeur</th></tr>");
        out.println("<tr><td>Prénom</td><td>" + prenom + "</td></tr>");
        out.println("<tr><td>Nom</td><td>" + nom + "</td></tr>");
        out.println("<tr><td>Date de naissance</td><td>" + dateNaissance + "</td></tr>");
        out.println("<tr><td>Sexe</td><td>" + sexe + "</td></tr>");
        out.println("</table>");
        out.println("<br><a href='ReadCookie'>Lire mes cookies</a>");
        out.println("<br><a href='VisitCounter'>Compter les vistes</a>");
        out.println("</body></html>");
    }
}