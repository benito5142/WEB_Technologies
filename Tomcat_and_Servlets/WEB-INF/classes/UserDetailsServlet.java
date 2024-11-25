import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/result")
public class UserDetailsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // Retrieve parameters from the form submission
        String title = "Form Inputs";
        String name = request.getParameter("userName");
        String email = request.getParameter("userEmail");
        String phone = request.getParameter("userPhno");
        String age = request.getParameter("userAge");
        String address = request.getParameter("userAddress");
        String dob = request.getParameter("userDob");
        String gender = request.getParameter("userGender");
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Generate the HTML response
        out.println("<html><head><title>" + title + "</title></head>");
        out.println("<body><h2>Form Submission Details</h2>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("<p>Phone: " + phone + "</p>");
        out.println("<p>Age: " + age + "</p>");
        out.println("<p>Address: " + address + "</p>");
        out.println("<p>Date of Birth: " + dob + "</p>");
        out.println("<p>Gender: " + gender + "</p>");
        out.println("</body></html>");
    }
}
