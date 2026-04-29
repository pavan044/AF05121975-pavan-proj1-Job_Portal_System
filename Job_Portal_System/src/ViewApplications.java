import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewApplications {

    public void viewApplications() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM applications");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("app_id") + " | User: " +
                    rs.getInt("user_id") + " | Job: " +
                    rs.getInt("job_id")
                );
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}