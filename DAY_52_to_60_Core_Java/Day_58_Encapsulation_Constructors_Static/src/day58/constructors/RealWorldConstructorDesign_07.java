package day58.constructors;

public class RealWorldConstructorDesign_07 {

    private String applicationId;
    private String candidateName;
    private String companyName;
    private String role;
    private String applicationSource;
    private String status;

    public RealWorldConstructorDesign_07(
            String applicationId,
            String candidateName,
            String companyName,
            String role,
            String applicationSource) {

        this.applicationId = applicationId;
        this.candidateName = candidateName;
        this.companyName = companyName;
        this.role = role;
        this.applicationSource = applicationSource;
        this.status = "APPLIED";
    }

    public void updateStatus(String status) {
        if (status != null && !status.trim().isEmpty()) {
            this.status = status;
        }
    }

    public boolean isActiveApplication() {
        return !status.equalsIgnoreCase("REJECTED")
                && !status.equalsIgnoreCase("WITHDRAWN");
    }

    public void displayApplication() {
        System.out.println("\n--- Job Application ---");
        System.out.println("Application ID : " + applicationId);
        System.out.println("Candidate      : " + candidateName);
        System.out.println("Company        : " + companyName);
        System.out.println("Role           : " + role);
        System.out.println("Source         : " + applicationSource);
        System.out.println("Status         : " + status);
        System.out.println("Active         : " + isActiveApplication());
    }
}