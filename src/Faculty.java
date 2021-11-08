import java.sql.*;

public class Faculty {
    Connection connection;

    {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/assignment2",
                    "root",
                    "root4421"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean facultyLogin(String f_email, String f_pass) {
        boolean facultyVerified = false;


        try {
            String query = "select faculty_email, faculty_pass from faculty";

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            if (rs != null) {
                while (rs.next()) {
                    String email = rs.getString("faculty_email");
                    String pass = rs.getString("faculty_pass");

                    if (email.equals(f_email) && pass.equals(f_pass)) {
                        facultyVerified = true;
                        break;
                    }
                }
            }
            else {
                System.out.println("Faculty not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (facultyVerified) {
            System.out.println("Faculty login Successful!\n");
        }
        else {
            System.out.println("Invalid Faculty username or password. Please try again!");
        }

        return facultyVerified;
    }
}
