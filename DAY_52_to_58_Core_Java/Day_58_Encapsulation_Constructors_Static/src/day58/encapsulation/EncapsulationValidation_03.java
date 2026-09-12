package day58.encapsulation;

public class EncapsulationValidation_03 {

    private int studentId;
    private String studentName;
    private double marks;

    public void setStudentId(int studentId) {
        if (studentId <= 0) {
            System.out.println("Error: Student ID must be greater than 0.");
            return;
        }
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentName(String studentName) {
        if (studentName == null || studentName.trim().isEmpty()) {
            System.out.println("Error: Student name cannot be null or empty.");
            return;
        }
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setMarks(double marks) {
        if (marks < 0 || marks > 100) {
            System.out.println("Error: Marks must be between 0 and 100.");
            return;
        }
        this.marks = marks;
    }

    public double getMarks() {
        return marks;
    }

    public void displayStudentDetails() {
        System.out.println("\n--- Student Details ---");
        System.out.println("Student ID   : " + getStudentId());
        System.out.println("Student Name : " + getStudentName());
        System.out.println("Marks        : " + getMarks());
    }
}