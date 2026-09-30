package day61;

import java.util.HashMap;
import java.util.Map;

public class HttpRequestResponseSimulator_1 {

    static class HttpRequest {
        private String method;
        private String path;
        private Map<String, String> headers;
        private String body;

        HttpRequest(String method, String path) {
            this.method = method;
            this.path = path;
            this.headers = new HashMap<>();
        }

        void addHeader(String name, String value) {
            headers.put(name, value);
        }

        void setBody(String body) {
            this.body = body;
        }

        String getMethod() {
            return method;
        }

        String getPath() {
            return path;
        }

        Map<String, String> getHeaders() {
            return headers;
        }

        String getBody() {
            return body;
        }
    }

    static class HttpResponse {
        private int statusCode;
        private String statusMessage;
        private String body;

        HttpResponse(int statusCode, String statusMessage, String body) {
            this.statusCode = statusCode;
            this.statusMessage = statusMessage;
            this.body = body;
        }

        void display() {
            System.out.println("HTTP/1.1 " + statusCode + " " + statusMessage);
            System.out.println();
            System.out.println(body);
        }
    }

    static class WebServer {

        HttpResponse handleRequest(HttpRequest request) {

            System.out.println("Server received request");
            System.out.println("Method : " + request.getMethod());
            System.out.println("Path   : " + request.getPath());

            if (request.getMethod().equals("GET") && request.getPath().equals("/users")) {
                return new HttpResponse(
                        200,
                        "OK",
                        "[{\"id\":1,\"name\":\"Jagan\"},{\"id\":2,\"name\":\"Rahul\"}]"
                );
            }

            return new HttpResponse(
                    404,
                    "Not Found",
                    "{\"message\":\"Resource not found\"}"
            );
        }
    }

    public static void main(String[] args) {

        HttpRequest request = new HttpRequest("GET", "/users");
        request.addHeader("Accept", "application/json");

        WebServer server = new WebServer();

        HttpResponse response = server.handleRequest(request);

        System.out.println();
        System.out.println("Client received response:");
        response.display();
    }
}