package day54;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Question5 {
    private static final String SQL = "INSERT INTO employees (employee_id, first_name, last_name, "
            + "gender, age, email, phone, department_id, salary, joining_date, city, experience_years) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public static void runQuestion5() {
        try (Connection con = ConnectionEx.getConnection();
             PreparedStatement stmt = con.prepareStatement(SQL);
             Scanner sc = new Scanner(System.in)) {

            for (int i = 1; i <= 5; i++) {
                System.out.println("\n--- Entering details for Employee " + i + " ---");

                System.out.print("Enter Employee_Id: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Employee FirstName: ");
                String firstName = sc.nextLine();

                System.out.print("Enter Employee lastName: ");
                String lastName = sc.nextLine();

                System.out.print("Enter Gender: ");
                String gender = sc.nextLine();

                System.out.print("Enter age: ");
                int age = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter email: ");
                String email = sc.nextLine();

                System.out.print("Enter phone number: ");
                String phone = sc.nextLine();

                System.out.print("Enter Department ID: ");
                int dept = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Salary: ");
                double salary = sc.nextDouble();
                sc.nextLine();

                System.out.print("Enter Joining Date (YYYY-MM-DD): ");
                String date = sc.nextLine();
                java.sql.Date joiningDate = java.sql.Date.valueOf(date);

                System.out.print("Enter City: ");
                String city = sc.nextLine();

                System.out.print("Enter Experience Years: ");
                int expYears = sc.nextInt();
                sc.nextLine();

                stmt.setInt(1, id);
                stmt.setString(2, firstName);
                stmt.setString(3, lastName);
                stmt.setString(4, gender);
                stmt.setInt(5, age);
                stmt.setString(6, email);
                stmt.setString(7, phone);
                stmt.setInt(8, dept);
                stmt.setDouble(9, salary);
                stmt.setDate(10, joiningDate);
                stmt.setString(11, city);
                stmt.setInt(12, expYears);

                stmt.addBatch();
            }

            int[] result = stmt.executeBatch();

            System.out.println();
            int employeeIndex = 1;
            for (int status : result) {
                if (status >= 0) {
                    System.out.println("Employee " + employeeIndex + " → " + status + " row affected");
                } else if (status == PreparedStatement.SUCCESS_NO_INFO) {
                    System.out.println("Employee " + employeeIndex + " → 1 row affected (success status code -2)");
                }
                employeeIndex++;
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
