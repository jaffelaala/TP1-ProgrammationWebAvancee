import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class VisitCounter extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
	request.setCharacterEncoding("UTF-8");
        
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        int count = 1;
        Cookie[] cookies = request.getCookies();
        
        
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("visitCount")) {
                    try {
                        count = Integer.parseInt(cookie.getValue()) + 1;
                    } catch (NumberFormatException e) {
                        count = 1; // Si la valeur est corrompue
                    }
                    break;
                }
            }
        }
        
        
        Cookie visitCookie = new Cookie("visitCount", String.valueOf(count));
        visitCookie.setMaxAge(60 * 60 * 24 * 30); // Dure 30 jours
        response.addCookie(visitCookie);
        
        out.println("<html><head><meta charset='UTF-8'></head><body>");
        out.println("<h2>Compteur de visites</h2>");
        out.println("<p>Vous avez visité cette page <b>" + count + "</b> fois.</p>");
        out.println("<br><a href='form.html'>Retour au formulaire</a>");
        out.println("</body></html>");
    }
}