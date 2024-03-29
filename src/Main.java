import java.sql.*;
import java.util.Scanner;

public class Main {
    static Connection con = DBConnection.getConnection();

    public static void main(String[] args) {

        Scanner ps = new Scanner(System.in);

        Student std = new Student();
        Section sec = new Section();
        Faculty fac = new Faculty();


        while (true) {
            System.out.println("Enter 1 to Student Registration");
            System.out.println("Enter 2 to Student Login");
            System.out.println("Enter 3 to Faculty Login\n");

            int dashboardCheck = ps.nextInt();
            ps.nextLine();

            if (dashboardCheck == 1) {
                std.studentRegister();
            } else if (dashboardCheck == 2) {
                System.out.println("Enter email: ");
                String email = ps.nextLine();

                System.out.println("Enter password: ");
                String pass = ps.nextLine();

                boolean loginVerification = std.studentLogin(email, pass);
                if (loginVerification) {

                    String u_id = "";
                    String u_name = "";

                    try {
                        String query = "select sid, s_name, s_email from student";

                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery(query);

                        if (rs != null) {
                            while (rs.next()) {
                                String id = rs.getString("sid");
                                String name = rs.getString("s_name");
                                String std_email = rs.getString("s_email");

                                if (std_email.equals(email)) {
                                    u_id = id;
                                    u_name = name;
                                }
                            }
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Enter 1 to select Section 1");
                    System.out.println("Enter 2 to select Section 2\n");

                    sec.showSection();

                    int sectionNo = ps.nextInt();

                    std.addSection(u_id, u_name, sectionNo);
                    sec.addStudent(sectionNo);
                }
            } else if (dashboardCheck == 3) {
                System.out.println("Enter Faculty email: ");
                String email = ps.nextLine();

                System.out.println("Enter Faculty password: ");
                String pass = ps.nextLine();

                boolean loginVerification = fac.facultyLogin(email, pass);
                if (loginVerification) {
                    System.out.println("Enter 1 to select Section 1");
                    System.out.println("Enter 2 to select Section 2\n");

                    int secNo = ps.nextInt();

                    fac.showSection(secNo);
                }
            }
        }

    }
}

