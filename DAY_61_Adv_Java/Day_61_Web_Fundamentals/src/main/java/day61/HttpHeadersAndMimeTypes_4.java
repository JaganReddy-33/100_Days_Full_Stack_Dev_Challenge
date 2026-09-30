package day61;

import java.util.LinkedHashMap;
import java.util.Map;

public class HttpHeadersAndMimeTypes_4 {

    static class HttpMessage {

        private Map<String, String> headers = new LinkedHashMap<>();

        void addHeader(String name, String value) {
            headers.put(name, value);
        }

        void displayHeaders() {

            System.out.println("HTTP Headers:");

            for (Map.Entry<String, String> entry : headers.entrySet()) {
                System.out.println(
                        entry.getKey() + ": " + entry.getValue()
                );
            }
        }
    }

    public static void main(String[] args) {

        HttpMessage response = new HttpMessage();

        response.addHeader("Content-Type", "application/json");
        response.addHeader("Accept", "application/json");
        response.addHeader("Cache-Control", "no-cache");
        response.addHeader("Authorization", "Bearer sample-token");

        response.displayHeaders();

        System.out.println();
        System.out.println("MIME Type Examples:");
        System.out.println("JSON : application/json");
        System.out.println("HTML : text/html");
        System.out.println("Text : text/plain");
        System.out.println("XML  : application/xml");
        System.out.println("Form : application/x-www-form-urlencoded");
    }
}