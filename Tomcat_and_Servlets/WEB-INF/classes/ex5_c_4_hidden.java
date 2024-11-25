import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/QuestionServletc4")
public class ex5_c_4_hidden extends HttpServlet {

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
            out.println("<html>");
            out.println("<head>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; background-color: #f4f4f9; margin: 0; padding: 20px; }");
            out.println(".container { max-width: 600px; margin: auto; padding: 20px; background: #fff; border-radius: 8px; box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); }");
            out.println("h2 { color: #d9534f; }");
            out.println("p { font-size: 1.1em; color: #555; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<h2>Form Submission Error</h2>");
            out.println("<p>" + validationErrors.toString() + "</p>");
            out.println("</div>");
            out.println("</body></html>");
        } else {
            out.println("<html>");
            out.println("<head>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; background-color: #f4f4f9; margin: 0; padding: 20px; }");
            out.println(".container { max-width: 600px; margin: auto; padding: 20px; background: #fff; border-radius: 8px; box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); }");
            out.println("h3 { color: #5cb85c; }");
            out.println("a { display: inline-block; margin-top: 15px; padding: 10px 20px; color: #fff; background-color: #0275d8; text-decoration: none; border-radius: 4px; }");
            out.println("a:hover { background-color: #025aa5; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<h3>Welcome, " + userName + "!</h3>");
            out.println("<p>Click the link below to visit your homepage:</p>");
            out.println("<form action='QuestionServletc4home' method='POST'>");
            out.println("<input type='hidden' name='userName' value='"+userName+"'>");
            out.println("<input type='submit' value='Go to the Home page'>");
            out.println("</form>");
            out.println("</div>");
            out.println("</body></html>");

            out.close();
        }
    }    
}
