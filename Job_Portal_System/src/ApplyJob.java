import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class ApplyJob {

    public void apply(int userId, Scanner sc) {
        try {
            Connection con = DBConnection.getConnection();

            System.out.print("Enter Job ID: ");
            int jobId = sc.nextInt();

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO applications(user_id,job_id) VALUES(?,?)"
            );

            ps.setInt(1, userId);
            ps.setInt(2, jobId);

            ps.executeUpdate();
            System.out.println("Applied Successfully");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}