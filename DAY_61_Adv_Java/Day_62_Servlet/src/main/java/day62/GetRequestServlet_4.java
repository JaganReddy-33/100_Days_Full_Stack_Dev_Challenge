package day62;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/get")
public class GetRequestServlet_4 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html; charset=UTF-8");

        
        String apiUrl = "https://jsonplaceholder.typicode.com/users";

        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest apiRequest = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .GET()
                    .build();

            HttpResponse<String> apiResponse = client.send(apiRequest, HttpResponse.BodyHandlers.ofString());

            response.getWriter().println("<h2>Sample Users Fetched from Internet:</h2>");
            response.getWriter().println("<pre style='background: #f4f4f4; padding: 15px; border-radius: 5px;'>" 
                    + apiResponse.body() 
                    + "</pre>");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            response.getWriter().println("<p style='color:red;'>Error fetching users from API.</p>");
        }
    }
}