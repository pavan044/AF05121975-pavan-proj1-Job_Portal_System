import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class LoginUser {

    public int login(Scanner sc) {  
        int userId = -1;

        try {
            Connection con = DBConnection.getConnection();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM users WHERE email=? AND password=?"
            );

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                userId = rs.getInt("id");
                System.out.println("Login Successful");
            } else {
                System.out.println("Invalid Credentials");
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return userId;
    }
}
