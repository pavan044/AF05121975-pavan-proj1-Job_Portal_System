import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteJob {

    public void deleteJob() {
        try {
            Scanner sc = new Scanner(System.in);
            Connection con = DBConnection.getConnection();

            System.out.print("Enter Job ID to Delete: ");
            int jobId = sc.nextInt();

            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM jobs WHERE job_id=?"
            );

            ps.setInt(1, jobId);

            ps.executeUpdate();
            System.out.println("Job Deleted Successfully");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}