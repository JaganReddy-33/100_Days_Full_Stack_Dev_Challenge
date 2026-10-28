package day62;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/post")
public class PostRequestServlet_5 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        String terms = req.getParameter("terms");

        String fullName = firstName + " " + lastName;

        resp.getWriter().println("""
                <!DOCTYPE html>
                <html>
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Registration Successful</title>

                    <style>
                        * {
                            margin: 0;
                            padding: 0;
                            box-sizing: border-box;
                        }

                        body {
                            min-height: 100vh;
                            display: flex;
                            justify-content: center;
                            align-items: center;
                            padding: 40px 20px;
                            font-family: Arial, sans-serif;
                            background: #f1f5f9;
                            color: #0f172a;
                        }

                        .card {
                            width: 100%;
                            max-width: 700px;
                            background: #ffffff;
                            border-radius: 24px;
                            padding: 45px;
                            box-shadow: 0 20px 60px rgba(15, 23, 42, 0.12);
                        }

                        .success-icon {
                            width: 70px;
                            height: 70px;
                            margin: 0 auto 20px;
                            display: flex;
                            justify-content: center;
                            align-items: center;
                            border-radius: 50%;
                            background: #dcfce7;
                            color: #16a34a;
                            font-size: 34px;
                            font-weight: bold;
                        }

                        h1 {
                            text-align: center;
                            color: #0f172a;
                            font-size: 30px;
                            margin-bottom: 10px;
                        }

                        .message {
                            text-align: center;
                            color: #64748b;
                            font-size: 15px;
                            margin-bottom: 35px;
                        }

                        .message strong {
                            color: #2563eb;
                        }

                        .details {
                            display: grid;
                            grid-template-columns: 1fr 1fr;
                            gap: 16px;
                        }

                        .detail {
                            padding: 18px;
                            border: 1px solid #e2e8f0;
                            border-radius: 12px;
                            background: #f8fafc;
                        }

                        .detail.full {
                            grid-column: span 2;
                        }

                        .label {
                            display: block;
                            margin-bottom: 6px;
                            color: #64748b;
                            font-size: 12px;
                            font-weight: 600;
                            text-transform: uppercase;
                            letter-spacing: 0.5px;
                        }

                        .value {
                            color: #0f172a;
                            font-size: 15px;
                            font-weight: 600;
                            word-break: break-word;
                        }

                        .status {
                            display: inline-flex;
                            align-items: center;
                            gap: 6px;
                            padding: 6px 10px;
                            border-radius: 20px;
                            background: #dcfce7;
                            color: #15803d;
                            font-size: 12px;
                            font-weight: 700;
                        }

                        .footer {
                            margin-top: 30px;
                            padding-top: 25px;
                            border-top: 1px solid #e2e8f0;
                            text-align: center;
                            color: #94a3b8;
                            font-size: 12px;
                        }

                        @media (max-width: 600px) {
                            .card {
                                padding: 30px 20px;
                            }

                            .details {
                                grid-template-columns: 1fr;
                            }

                            .detail.full {
                                grid-column: span 1;
                            }
                        }
                    </style>
                </head>

                <body>

                    <div class="card">

                        <div class="success-icon">✓</div>

                        <h1>Registration Successful</h1>

                        <p class="message">
                            Welcome, <strong>""" + fullName + """
                            </strong>! Your registration details were received successfully.
                        </p>

                        <div class="details">

                            <div class="detail">
                                <span class="label">First Name</span>
                                <span class="value">""" + firstName + """
                                </span>
                            </div>

                            <div class="detail">
                                <span class="label">Last Name</span>
                                <span class="value">""" + lastName + """
                                </span>
                            </div>

                            <div class="detail full">
                                <span class="label">Email Address</span>
                                <span class="value">""" + email + """
                                </span>
                            </div>

                            <div class="detail">
                                <span class="label">Phone Number</span>
                                <span class="value">""" + phone + """
                                </span>
                            </div>

                            <div class="detail">
                                <span class="label">Terms & Conditions</span>
                                <span class="status">✓ Accepted</span>
                            </div>

                        </div>

                        <div class="footer">
                            Data received through HTTP POST using HttpServletRequest
                        </div>

                    </div>

                </body>
                </html>
                """);
    }
}