import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/formServe")
public class ex5_b extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            out.println("<html><head><meta charset='UTF-8'><meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<title>Styled Form</title>");
            out.println("<style>");
            out.println("body {font-family: Arial, sans-serif; margin: 0; padding: 0; display: flex; justify-content: center; align-items: center; height: 100vh; background-color: #f0f0f0;}");
            out.println(".container {background-color: white; padding: 20px; border-radius: 10px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); max-width: 400px; width: 100%; text-align: center;}");
            out.println("h1 {color: orchid;}");
            out.println("p {font-size: 16px;}");
            out.println("label {font-weight: bold;}");
            out.println(".error {color: red;}");
            out.println("</style></head><body>");
            out.println("<div class='container'>");

            if (name == null || name.isEmpty()) {
                out.println("<p class='error'>Name is required.</p>");
            } 
            else if (!name.matches("[a-zA-Z\\s]+")) {
                out.println("<p class='error'>Name must not contain numbers or special characters.</p>");
            } 
            else if (email == null || email.isEmpty()) {
                out.println("<p class='error'>Email is required.</p>");
            } 
            else if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                out.println("<p class='error'>Email must be in a valid format.</p>");
            }
            else if (password == null || password.isEmpty()) {
                out.println("<p class='error'>Password is required.</p>");
            } 
            else if (password.length() < 8 || !password.matches(".*\\d.*") || !password.matches(".*[a-zA-Z].*")) {
                out.println("<p class='error'>Password is weak. Please choose a password with at least 8 characters, including both letters and numbers.</p>");
            }
            else {
                out.println("<script>alert('Form submitted successfully!');</script>");
                out.println("<h1>Form Details</h1>");
                out.println("<label for='name'>Name:</label>");
                out.println("<p>" + name + "</p>");
                out.println("<label for='email'>Email:</label>");
                out.println("<p>" + email + "</p>");
                out.println("<h2 style='color:green;'>Form submitted successfully!</h2>");
            }

            out.println("</div>"); 
            out.println("</body></html>");
        } 
        finally {
            out.close();
        } 
    } 
}
