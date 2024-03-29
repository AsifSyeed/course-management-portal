import java.sql.*;

public class Section {
    static Connection con = DBConnection.getConnection();

    PreparedStatement preparedStatement;

    public void showSection() {
        try {
            String query = "select * from section";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            if (rs != null) {
                while (rs.next()) {
                    String sectionName = rs.getString("sec_name");
                    String time = rs.getString("sec_time");
                    int count = 9 - rs.getInt("sec_count");

                    System.out.println(sectionName + "        " + time + "        " + count +" seat(s) remaining");
                }
            }
            else {
                System.out.println("No section found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addStudent (int secNo) {
        if (secNo == 1) {
            String secName = "Section-01";
            String query = "update section set sec_count = sec_count + 1  where sec_name = ?";

            try {
                preparedStatement = con.prepareStatement(query);
                preparedStatement.setString(1, secName);

                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if (secNo == 2) {
            String secName = "Section-02";
            String query = "update section set sec_count = sec_count + 1  where sec_name = ?";

            try {
                preparedStatement = con.prepareStatement(query);
                preparedStatement.setString(1, secName);

                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
