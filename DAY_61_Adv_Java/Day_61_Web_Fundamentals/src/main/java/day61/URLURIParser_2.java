package day61;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.Map;

public class URLURIParser_2 {

    public static void main(String[] args) {

        String input =
                "https://api.example.com:8443/users/profile?id=101&city=Bengaluru";

        URI uri = URI.create(input);

        System.out.println("Complete URI : " + uri);
        System.out.println("Scheme       : " + uri.getScheme());
        System.out.println("Host         : " + uri.getHost());
        System.out.println("Port         : " + uri.getPort());
        System.out.println("Path         : " + uri.getPath());
        System.out.println("Query        : " + uri.getQuery());

        System.out.println();
        System.out.println("Query Parameters:");

        Map<String, String> parameters = parseQuery(uri.getQuery());

        parameters.forEach((key, value) ->
                System.out.println(key + " = " + value)
        );
    }

    static Map<String, String> parseQuery(String query) {

        Map<String, String> parameters = new LinkedHashMap<>();

        if (query == null || query.isBlank()) {
            return parameters;
        }

        String[] pairs = query.split("&");

        for (String pair : pairs) {

            String[] keyValue = pair.split("=", 2);

            String key = keyValue[0];
            String value = keyValue.length > 1 ? keyValue[1] : "";

            parameters.put(key, value);
        }

        return parameters;
    }
}