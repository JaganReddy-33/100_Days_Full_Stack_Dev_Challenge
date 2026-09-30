package day61;

import java.util.LinkedHashMap;
import java.util.Map;

public class RequestDataSystem_5 {

    static class HttpRequest {

        private String method;
        private String path;
        private Map<String, String> queryParameters;
        private Map<String, String> formData;
        private String body;

        HttpRequest(String method, String path) {
            this.method = method;
            this.path = path;
            this.queryParameters = new LinkedHashMap<>();
            this.formData = new LinkedHashMap<>();
        }

        void addQueryParameter(String key, String value) {
            queryParameters.put(key, value);
        }

        void addFormField(String key, String value) {
            formData.put(key, value);
        }

        void setBody(String body) {
            this.body = body;
        }

        void display() {

            System.out.println("Method: " + method);
            System.out.println("Path  : " + path);

            System.out.println();
            System.out.println("Query Parameters:");

            queryParameters.forEach(
                    (key, value) ->
                            System.out.println(key + " = " + value)
            );

            System.out.println();
            System.out.println("Form Data:");

            formData.forEach(
                    (key, value) ->
                            System.out.println(key + " = " + value)
            );

            System.out.println();
            System.out.println("Request Body:");
            System.out.println(body);
        }
    }

    public static void main(String[] args) {

        HttpRequest getRequest =
                new HttpRequest("GET", "/products");

        getRequest.addQueryParameter("category", "laptop");
        getRequest.addQueryParameter("page", "1");

        System.out.println("===== GET REQUEST =====");
        getRequest.display();

        HttpRequest postRequest =
                new HttpRequest("POST", "/users");

        postRequest.setBody(
                "{\"name\":\"Jagan\",\"city\":\"Bengaluru\"}"
        );

        postRequest.addFormField("source", "web");

        System.out.println();
        System.out.println("===== POST REQUEST =====");
        postRequest.display();
    }
}