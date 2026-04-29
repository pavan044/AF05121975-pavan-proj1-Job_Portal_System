import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Insert default jobs
        new AddDefaultJobs().insertJobs();

        int choice;

        do {
            System.out.println("\n===== JOB PORTAL =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // ✅ FIX buffer

            switch (choice) {

                case 1:
                    new RegisterUser().register();
                    break;

                case 2:
                    int userId = new LoginUser().login(sc); // ✅ FIXED

                    if (userId != -1) {

                        int ch;
                        do {
                            System.out.println("\n--- USER MENU ---");
                            System.out.println("1. View Jobs");
                            System.out.println("2. Apply Job");
                            System.out.println("3. Update Profile");
                            System.out.println("4. View Applications");
                            System.out.println("5. Logout");
                            System.out.print("Enter choice: ");
                            ch = sc.nextInt();
                            sc.nextLine(); // ✅ FIX buffer

                            switch (ch) {

                                case 1:
                                    new ViewJobs().viewJobs();
                                    break;

                                case 2:
                                    new ViewJobs().viewJobs();
                                    new ApplyJob().apply(userId, sc); // ✅ FIXED
                                    break;

                                case 3:
                                    new UpdateProfile().updateProfile(userId);
                                    break;

                                case 4:
                                    new ViewApplications().viewApplications();
                                    break;
                            }

                        } while (ch != 5);
                    }
                    break;
            }

        } while (choice != 3);

        System.out.println("Thank You!");
    }
}