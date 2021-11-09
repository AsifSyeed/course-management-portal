import java.sql.*;

public class Faculty {
    static Connection con = DBConnection.getConnection();

    public boolean facultyLogin(String f_email, String f_pass) {
        boolean facultyVerified = false;


        try {
            String query = "select faculty_email, faculty_pass from faculty";

            Statement st = con.createStatement();
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
            } else {
                System.out.println("Student not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (facultyVerified) {
            System.out.println("Faculty login Successful!\n");
        } else {
            System.out.println("Invalid Faculty username or password. Please try again!");
        }

        return facultyVerified;
    }

    public void showSection(int secNo) {
        if (secNo == 1) {
            System.out.println("Section-01");
            try {
                String query = "select s_name, s_id from sectionstudentList where sectionNo = 1";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query);

                if (rs != null) {
                    while (rs.next()) {
                        String name = rs.getString("s_name");
                        String id = rs.getString("s_id");

                        System.out.println(name + "         " + id);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (secNo == 2) {
            System.out.println("Section-02");
            try {
                String query = "select s_name, s_id from sectionstudentList where sectionNo = 2";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query);

                if (rs != null) {
                    while (rs.next()) {
                        String name = rs.getString("s_name");
                        String id = rs.getString("s_id");

                        System.out.println(name + "         " + id);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Please select a valid section!");
        }
    }
}
