import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deathWish")
public class DoOrDie extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // Retrieve parameters from the form submission
        String title = "Your Life Span";
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String gender = request.getParameter("gender");
        String[] food = request.getParameterValues("food");

        Object[][] foodValues = {
            {"Chappathi", 4, 4},  // food item, toxicity, energy
            {"Idly", 2, 5},
            {"Dosai", 2, 6},
            {"Cornflex", 4, 8},
            {"Salad", 1, 7},
            {"Noodles", 5, 5},
            {"Bread and Jam", 3, 5},
            {"Pasta", 3, 6},
            {"Parotta", 8, 5},
            {"Upma", 3, 5}
        };
        
        int totalToxicity = 0;
        int totalEnergy = 0;

        // Calculate total toxicity and energy from selected food items
        if (food != null) {
            for (String selectedFood : food) {
                for (Object[] item : foodValues) {
                    if (item[0].equals(selectedFood)) {
                        totalToxicity += (int)item[1];
                        totalEnergy += (int)item[2];
                        break;
                    }
                }
            }
        }

        // Calculate expected lifespan
        int A = Integer.parseInt(age);
        int G = "Male".equals(gender) ? 1 : 2; // Male = 1, Female = 2
        double expectedLifespan;
        if (A > 65) {
            expectedLifespan = A;
        } else {
            expectedLifespan = (65 - A) * (1 - (totalToxicity / 50.0)) + (totalEnergy / 2.0 * G / 2.0) + A;
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Generate the HTML response
        out.println("<html><head><title>" + title + "</title>");
        out.println("<style>");
        out.println("body { text-align: center; font-family: Arial, sans-serif; }");
        out.println(".candle-container { margin: 50px; }");
        out.println(".candle { width: 200px; transition: opacity 1s ease-in-out; }");
        out.println(".lifespan-counter { font-size: 24px; margin-top: 20px; }");
        out.println(".name-display { font-size: 36px; font-weight: bold; margin-bottom: 30px; }");
        out.println("</style>");
        out.println("</head><body>");

        // Display the user's name prominently
        out.println("<div class='name-display'>Hello " + name + "!</div>");
        
        // Add the candle burning GIF and lifespan timer
        out.println("<div class='candle-container'>");
        out.println("<img id='candleGif' class='candle' src='https://media3.giphy.com/media/SVyuDpWztND5sMmmMR/200.webp?cid=ecf05e47xm0ses8ie9enycgllvuphfbfccyar33y0vzgy6ga&ep=v1_gifs_search&rid=200.webp&ct=g' alt='Burning Candle'>");
        out.println("<div class='lifespan-counter'>Lifespan: <span id='lifespan'>0</span> years</div>");
        out.println("</div>");

        // JavaScript to manage the countdown and GIF switch
        out.println("<script>");
        out.println("let lifespan = 0;");
        out.println("const expectedLifespan = " + (int)expectedLifespan + ";");
        out.println("const countdownTarget = expectedLifespan;");
        out.println("const lifespanElement = document.getElementById('lifespan');");
        out.println("const candleGifElement = document.getElementById('candleGif');");

        // Increment the lifespan every second and update the GIF when necessary
        out.println("const countdownInterval = setInterval(() => {");
        out.println("  lifespan++;");
        out.println("  lifespanElement.textContent = lifespan;");
        
        // Change the GIF when lifespan reaches the expected value
        out.println("  if (lifespan === countdownTarget) {");
        out.println("    candleGifElement.style.opacity = '0';");  // Smooth transition
        out.println("    setTimeout(() => {");
        // Append a random number to the URL to prevent caching of the new GIF
        out.println("      candleGifElement.src = 'https://media0.giphy.com/media/B313NwxrHpzUs/200.webp?cid=790b7611ur9pm603g77qd3hyjxuyrzyi7l4ntxdll5o38pby&ep=v1_gifs_search&rid=200.webp&ct=g' + new Date().getTime();");
        out.println("      candleGifElement.style.opacity = '1';");  // Fade back in
        out.println("    }, 1000);  // Delay for the fade-out transition");
        out.println("  }");
        
        // Stop the interval when it reaches the maximum expected lifespan
        out.println("  if (lifespan >= countdownTarget) {");
        out.println("    clearInterval(countdownInterval);");
        out.println("  }");
        out.println("}, 100);");

        out.println("</script>");
        out.println("</body></html>");
    }
}
