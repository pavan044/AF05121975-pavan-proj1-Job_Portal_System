import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateProfile {

    public void updateProfile(int userId) {
        try {
            Scanner sc = new Scanner(System.in);
            Connection con = DBConnection.getConnection();

            sc.nextLine(); 

            System.out.print("Enter New Name: ");
            String name = sc.nextLine();

            PreparedStatement ps = con.prepareStatement(
                "UPDATE users SET name=? WHERE id=?"
            );

            ps.setString(1, name);
            ps.setInt(2, userId);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Profile Updated Successfully");
            else
                System.out.println("Update Failed");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
