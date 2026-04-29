import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddDefaultJobs {

    public void insertJobs() {
        try {
            Connection con = DBConnection.getConnection();

            // Check if jobs already exist
            var st = con.createStatement();
            var rs = st.executeQuery("SELECT COUNT(*) FROM jobs");
            rs.next();

            if (rs.getInt(1) > 0) {
                return; // jobs already exist
            }

            // Insert 5 default jobs
            String query = "INSERT INTO jobs(title, company) VALUES (?,?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, "Java Developer");
            ps.setString(2, "TCS");
            ps.executeUpdate();

            ps.setString(1, "Web Developer");
            ps.setString(2, "Infosys");
            ps.executeUpdate();

            ps.setString(1, "Software Engineer");
            ps.setString(2, "Wipro");
            ps.executeUpdate();

            ps.setString(1, "Data Analyst");
            ps.setString(2, "Accenture");
            ps.executeUpdate();

            ps.setString(1, "Backend Developer");
            ps.setString(2, "HCL");
            ps.executeUpdate();

            System.out.println("Default Jobs Added");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
