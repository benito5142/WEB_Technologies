import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/QuestionServletc")
public class ex5_c extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        // Retrieve form parameters
        String userName = request.getParameter("userName");
        String userEmail = request.getParameter("userEmail");
        String userAge = request.getParameter("userAge");
        String userPassword = request.getParameter("userPassword");
        String musicGenre = request.getParameter("musicGenre");

        StringBuilder validationErrors = new StringBuilder();

        // Validate inputs
        if (userName == null || userName.trim().isEmpty() || !userName.matches("[a-zA-Z ]+")) {
            validationErrors.append("Invalid name. ");
        }
        if (userEmail == null || userEmail.trim().isEmpty() || !userEmail.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            validationErrors.append("Invalid email. ");
        }
        if (userPassword == null || userPassword.trim().isEmpty() || userPassword.length() < 8) {
            validationErrors.append("Password must be at least 8 characters. ");
        }
        try {
            int age = Integer.parseInt(userAge);
            if (age < 5 || age > 120) validationErrors.append("Age out of realistic range. ");
        } catch (NumberFormatException e) {
            validationErrors.append("Invalid age. ");
        }
        if (musicGenre == null || musicGenre.trim().isEmpty()) {
            validationErrors.append("Music genre is required. ");
        }

        PrintWriter out = response.getWriter();
        if (validationErrors.length() > 0) {
            out.println("<html><body>");
            out.println("<h2>Form Submission Error</h2>");
            out.println("<p>" + validationErrors.toString() + "</p>");
            out.println("</body></html>");
        } else {
            // Set cookies for validated data
            response.addCookie(new Cookie("userName", userName));
            response.addCookie(new Cookie("userEmail", userEmail));
            response.addCookie(new Cookie("userAge", userAge));
            response.addCookie(new Cookie("musicGenre", musicGenre));

            // Redirect to an HTML page
            response.sendRedirect("ex5_c_home.html");
        }
    }
}
