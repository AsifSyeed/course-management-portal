import java.awt.*;
import java.sql.*;
import java.util.Scanner;

public class Student {
    static Connection con = DBConnection.getConnection();

    PreparedStatement preparedStatement;
    Scanner ps = new Scanner(System.in);

    public void studentRegister() {

        try {
            System.out.println("Enter your Student ID: ");
            String id = ps.nextLine();

            System.out.println("Enter your Name: ");
            String name = ps.nextLine();

            System.out.println("Enter your Email: ");
            String email = ps.nextLine();

            System.out.println("Enter your Password: ");
            String pass = ps.nextLine();

            String query = "insert into student (sid, s_name, s_email, s_pass) values (?, ?, ?, ?)";

            preparedStatement = con.prepareStatement(query);

            preparedStatement.setString(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, pass);

            preparedStatement.executeUpdate();
            System.out.println("Registration Successful. Proceed to login!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean studentLogin(String u_email, String u_pass) {
        boolean loginVerified = false;


        try {
            String query = "select s_email, s_pass from student";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            if (rs != null) {
                while (rs.next()) {
                    String email = rs.getString("s_email");
                    String pass = rs.getString("s_pass");

                    if (email.equals(u_email) && pass.equals(u_pass)) {
                        loginVerified = true;
                        break;
                    }
                }
            }
            else {
                System.out.println("Student not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (loginVerified) {
            System.out.println("Login Successful!");
        }
        else {
            System.out.println("Invalid username or password. Please try again!");
        }

        return loginVerified;
    }

    public void addSection (String id, String name, int sec) {

        try {
            String query = "insert into sectionstudentList (s_id, s_name, sectionNo) values (?, ?, ?)";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, String.valueOf(sec));

            preparedStatement.executeUpdate();
            System.out.println("Section added successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }


    }
}
