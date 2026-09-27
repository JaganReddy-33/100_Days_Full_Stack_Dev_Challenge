package day58.constructors;

public class ConstructorRules_05 {

    private String requestId;
    private String endpoint;
    private String method;
    private int timeout;

    public ConstructorRules_05() {
        this.requestId = "AUTO-GENERATED";
        this.endpoint = "/";
        this.method = "GET";
        this.timeout = 30;
    }

    public ConstructorRules_05(
            String requestId,
            String endpoint,
            String method,
            int timeout) {

        this.requestId = requestId;
        this.endpoint = endpoint;
        this.method = method;
        this.timeout = timeout;
    }

    public boolean isValidRequest() {
        return requestId != null
                && !requestId.trim().isEmpty()
                && endpoint != null
                && !endpoint.trim().isEmpty()
                && timeout > 0;
    }

    public void updateTimeout(int timeout) {
        if (timeout > 0) {
            this.timeout = timeout;
        }
    }

    public void displayRequest() {
        System.out.println("\n--- API Request Configuration ---");
        System.out.println("Request ID : " + requestId);
        System.out.println("Endpoint   : " + endpoint);
        System.out.println("Method     : " + method);
        System.out.println("Timeout    : " + timeout + " seconds");
        System.out.println("Valid      : " + isValidRequest());
    }
}