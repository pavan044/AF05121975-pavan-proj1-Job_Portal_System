import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PostJob {

    public void postJob() {
        try {
            Scanner sc = new Scanner(System.in);
            Connection con = DBConnection.getConnection();

            System.out.print("Enter Job Title: ");
            String title = sc.nextLine();

            System.out.print("Enter Company: ");
            String company = sc.nextLine();

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO jobs(title,company) VALUES(?,?)"
            );

            ps.setString(1, title);
            ps.setString(2, company);

            ps.executeUpdate();
            System.out.println("Job Posted Successfully");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}