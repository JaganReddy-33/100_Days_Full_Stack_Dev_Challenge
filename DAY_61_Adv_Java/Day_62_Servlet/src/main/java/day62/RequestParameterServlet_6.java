package day62;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/request-params")
public class RequestParameterServlet_6 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        response.getWriter().println("""
            <!DOCTYPE html>
            <html>
            <head>
                <meta charset="UTF-8">
                <title>Request Parameters</title>
                <style>
                    body {
                        margin: 0;
                        font-family: Arial, sans-serif;
                        background: #f4f7fb;
                        display: flex;
                        justify-content: center;
                        align-items: center;
                        min-height: 100vh;
                    }

                    .card {
                        width: 420px;
                        background: white;
                        padding: 35px;
                        border-radius: 16px;
                        box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
                    }

                    h1 {
                        margin-top: 0;
                        color: #1f2937;
                    }

                    .row {
                        padding: 14px 0;
                        border-bottom: 1px solid #e5e7eb;
                    }

                    .label {
                        font-size: 13px;
                        color: #6b7280;
                    }

                    .value {
                        margin-top: 5px;
                        font-size: 16px;
                        color: #111827;
                        font-weight: 600;
                    }

                    .url {
                        margin-top: 25px;
                        padding: 12px;
                        background: #f3f4f6;
                        border-radius: 8px;
                        font-size: 13px;
                        word-break: break-all;
                    }
                </style>
            </head>
            <body>

                <div class="card">
                    <h1>Request Parameters</h1>

                    <div class="row">
                        <div class="label">Name</div>
                        <div class="value">%s</div>
                    </div>

                    <div class="row">
                        <div class="label">Email</div>
                        <div class="value">%s</div>
                    </div>

                    <div class="row">
                        <div class="label">Course</div>
                        <div class="value">%s</div>
                    </div>

                    <div class="url">
                        Parameters received using HttpServletRequest.getParameter()
                    </div>
                </div>

            </body>
            </html>
            """.formatted(name, email, course));

    }

}