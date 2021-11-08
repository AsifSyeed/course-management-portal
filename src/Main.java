import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main (String [] args) {

        Scanner ps = new Scanner(System.in);

        Student std = new Student();

        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/assignment2",
                    "root",
                    "root4421"
            );

            PreparedStatement preparedStatement;

            while (true) {
                System.out.println("Enter 1 to Student Registration");
                System.out.println("Enter 2 to Student Login");
                System.out.println("Enter 3 to Faculty Login\n");

                int dashboardCheck = ps.nextInt();
                ps.nextLine();

                if (dashboardCheck == 1) {
                    std.studentRegister();
                }
                else if (dashboardCheck == 2) {
                    System.out.println("Enter email: ");
                    String email = ps.nextLine();

                    System.out.println("Enter password: ");
                    String pass = ps.nextLine();

                    boolean loginVerification = std.studentLogin(email, pass);
                    if (loginVerification) {
                        System.out.println("Enter 1 to select Section 1");
                        System.out.println("Enter 2 to select Section 2\n");

                        int sec = ps.nextInt();

                        std.addSection(email, sec);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

