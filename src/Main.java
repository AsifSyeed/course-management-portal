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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

