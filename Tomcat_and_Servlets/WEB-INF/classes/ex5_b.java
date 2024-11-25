import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/QuestionServlet")
public class ex5_b extends HttpServlet {

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

        // Validate Name
        if (userName == null || userName.trim().isEmpty()) {
            validationErrors.append("Name is required.<br>");
        } else if (!userName.matches("[a-zA-Z ]+")) { // Allow only alphabetic characters and spaces
            validationErrors.append("Name can only contain alphabetic characters and spaces.<br>");
        }

        // Validate Email
        if (userEmail == null || userEmail.trim().isEmpty()) {
            validationErrors.append("Email is required.<br>");
        } else if (!userEmail.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) { // Improved email regex
            validationErrors.append("Please enter a valid email address.<br>");
        }

        // Validate Password
        if (userPassword == null || userPassword.trim().isEmpty()) {
            validationErrors.append("Password is required.<br>");
        } else if (userPassword.length() < 8) { // Password must be at least 8 characters
            validationErrors.append("Password must be at least 8 characters long.<br>");
        }

        // Validate Age
        if (userAge == null || userAge.trim().isEmpty()) {
            validationErrors.append("Age is required.<br>");
        } else {
            try {
                int age = Integer.parseInt(userAge);
                if (age < 5 || age > 120) {
                    validationErrors.append("Please enter a realistic age (0-120).<br>");
                }
            } catch (NumberFormatException e) {
                validationErrors.append("Please enter a valid age in numbers.<br>");
            }
        }

        // Validate Music Genre
        if (musicGenre == null || musicGenre.trim().isEmpty()) {
            validationErrors.append("Music genre is required.<br>");
        }

        // Prepare the response
        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        // Check if there were validation errors
        if (validationErrors.length() > 0) {
            out.println("<h2>Form Submission Error</h2>");
            out.println("<p>" + validationErrors.toString() + "</p>");
        } else {
            response.sendRedirect("ex5_b_home.html");
        }

        out.println("</body></html>");
    }
}
