import java.sql.*;

public class ViewJobs {

    public void viewJobs() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM jobs");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("job_id") + " | " +
                    rs.getString("title") + " | " +
                    rs.getString("company")
                );
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}