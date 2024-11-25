import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ShowCookieServlet")
public class ex5_chome extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve cookies
        Cookie[] cookies = request.getCookies();
        String userName = "Guest";  // Default value if cookie is not found

        // Look for the "userName" cookie
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("userName".equals(cookie.getName())) {
                    userName = cookie.getValue();
                    break;
                }
            }
        }

        // Return the username in the response
        out.println(userName);
    }
}
