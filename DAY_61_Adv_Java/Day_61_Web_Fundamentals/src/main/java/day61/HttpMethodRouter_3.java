package day61;


public class HttpMethodRouter_3 {

    static class WebRequest {
        private String method;
        private String path;

        WebRequest(String method, String path) {
            this.method = method;
            this.path = path;
        }

        String getMethod() {
            return method;
        }

        String getPath() {
            return path;
        }
    }

    static class WebRouter {

        void route(WebRequest request) {

            String method = request.getMethod();
            String path = request.getPath();

            if (method.equals("GET")) {
                get(path);
            } else if (method.equals("POST")) {
                post(path);
            } else if (method.equals("PUT")) {
                put(path);
            } else if (method.equals("DELETE")) {
                delete(path);
            } else {
                System.out.println("405 Method Not Allowed");
            }
        }

        void get(String path) {
            System.out.println("GET  → Retrieving resource: " + path);
        }

        void post(String path) {
            System.out.println("POST → Creating resource: " + path);
        }

        void put(String path) {
            System.out.println("PUT  → Updating resource: " + path);
        }

        void delete(String path) {
            System.out.println("DELETE → Deleting resource: " + path);
        }
    }

    public static void main(String[] args) {

        WebRouter router = new WebRouter();

        router.route(new WebRequest("GET", "/users/101"));
        router.route(new WebRequest("POST", "/users"));
        router.route(new WebRequest("PUT", "/users/101"));
        router.route(new WebRequest("DELETE", "/users/101"));
        router.route(new WebRequest("PATCH", "/users/101"));
    }
}