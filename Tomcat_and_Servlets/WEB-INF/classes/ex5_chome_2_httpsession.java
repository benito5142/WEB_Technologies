import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/QuestionServletc2home")
public class ex5_chome_2_httpsession extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve HttpSession
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");

        // Set default value if the session attribute is not found
        if (userName == null) {
            userName = "Guest";
        }

        // Generate HTML dynamically
        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Groovy - Popular Songs</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; margin: 0; padding: 0; background-color: #f4f4f4; }");
        out.println("header { padding: 10px; text-align: center; background-color: #7827e7; color: #fff; }");
        out.println(".popular-section { padding: 20px; text-align: center; }");
        out.println(".popular { margin: 10px; display: inline-block; text-align: center; }");
        out.println(".cover { width: 150px; height: 150px; border: 2px solid #ccc; border-radius: 5px; transition: border-color 0.3s; }");
        out.println(".cover:hover { border-color: #7827e7; }");
        out.println(".popular-song-name { font-size: 1.1em; font-weight: bold; text-decoration: none; color: #333; display: block; margin-top: 8px; }");
        out.println(".popular-singer-name { font-size: 0.9em; color: #666; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");

        // Header section
        out.println("<header>");
        out.println("<h1>Welcome, " + userName + "!</h1>");
        out.println("<p>Enjoy our selection of popular songs</p>");
        out.println("</header>");

        // Song listing section
        out.println("<div class='popular-section'>");
        out.println("<h2>Popular Songs</h2>");
        
        // Songs data
        String[][] songs = {
            {"Electric Love", "Borns", "https://open.spotify.com/track/2GiJYvgVaD2HtM8GqD9EgQ", "./Exercise 5 servlet/images/electric love.jpg"},
            {"FEIN", "Travis Scott, Playboi Carti", "https://open.spotify.com/track/42VsgItocQwOQC3XWZ8JNA", "./Exercise 5 servlet/images/fein.jpg"},
            {"Do I Wanna Know", "Arctic Monkeys", "https://open.spotify.com/track/5FVd6KXrgO9B3JPmC8OPst", "./Exercise 5 servlet/images/do i wanna know.jpg"},
            {"Here", "Alessia Shah", "https://open.spotify.com/track/5LrN7yUQAzvthd4QujgPFr", "./Exercise 5 servlet/images/here.jpg"},
            {"Jericho", "Iniko", "https://open.spotify.com/track/4ztdjZ2t7BVo5DLIFQBdJh", "./Exercise 5 servlet/images/jericho.jpg"},
            {"Astronaut In The Ocean", "Masked Wolf", "https://open.spotify.com/album/7vus4Q8r5DS2Dl1JClxEsA", "./Exercise 5 servlet/images/astronaut in the ocean.jpg"},
            {"Promiscuous", "Nelly Furtado, Timbaland", "https://open.spotify.com/track/2gam98EZKrF9XuOkU13ApN", "./Exercise 5 servlet/images/promiscuous.jpg"},
            {"Swim", "Chase Atlantic", "https://open.spotify.com/track/3M0lSi5WW79CXQamgSBIjx", "./Exercise 5 servlet/images/swim.jpg"},
            {"Gurenge", "LiSA", "https://open.spotify.com/track/0qMip0B2D4ePEjBJvAtYre", "./Exercise 5 servlet/images/gurenge.jpg"}
        };

        // Generate HTML for each song
        for (String[] song : songs) {
            out.println("<div class='popular'>");
            out.println("  <a href='" + song[2] + "'>");
            out.println("    <img class='cover' src='" + song[3] + "' alt='" + song[0] + "' />");
            out.println("  </a>");
            out.println("  <a href='" + song[2] + "' class='popular-song-name'>" + song[0] + "</a>");
            out.println("  <div class='popular-singer-name'>" + song[1] + "</div>");
            out.println("</div>");
        }

        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}
