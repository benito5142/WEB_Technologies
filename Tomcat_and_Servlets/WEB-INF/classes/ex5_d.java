import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/QuestionServletd")
public class ex5_d extends HttpServlet {

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
            // Database connection
            String DB_URL = "jdbc:mysql://localhost:3306/your_database_name"; // replace with your DB URL
            String DB_USER = "your_db_user";  // replace with your DB username
            String DB_PASSWORD = "your_db_password"; // replace with your DB password

            Connection conn = null;
            PreparedStatement stmt = null;

            try {
                // Register the JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Open a connection
                conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

                // Prepare SQL query to insert data
                String sql = "INSERT INTO users (userName, userEmail, userAge, userPassword, musicGenre) VALUES (?, ?, ?, ?, ?)";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, userName);
                stmt.setString(2, userEmail);
                stmt.setInt(3, Integer.parseInt(userAge)); // assuming age is an integer
                stmt.setString(4, userPassword);
                stmt.setString(5, musicGenre);

                // Execute the insert query
                int rowsAffected = stmt.executeUpdate();

                if (rowsAffected > 0) {
                    out.println("<html><body>");
                    out.println("<h2>Form Submission Successful</h2>");
                    out.println("<p>Your data has been successfully stored in the database.</p>");
                    out.println("</body></html>");
                    response.sendRedirect("ex5_d_home.html");
                } else {
                    out.println("<html><body>");
                    out.println("<h2>Error in Storing Data</h2>");
                    out.println("<p>There was an issue saving your information.</p>");
                    out.println("</body></html>");
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                out.println("<html><body>");
                out.println("<h2>Error</h2>");
                out.println("<p>There was an issue connecting to the database: " + e.getMessage() + "</p>");
                out.println("</body></html>");
            } finally {
                try {
                    // Clean up the environment
                    if (stmt != null) stmt.close();
                    if (conn != null) conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
