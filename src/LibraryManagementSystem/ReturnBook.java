package LibraryManagementSystem;
import java.sql.*;
import java.util.Scanner;

public class ReturnBook {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Issue ID: ");
        int issueId = sc.nextInt();

        try {
            Connection con = DBConnection.getConnection();
            con.setAutoCommit(false);   // start transaction

            //Check issue record exists
            PreparedStatement ps1 = con.prepareStatement(
                    "SELECT book_id FROM issued_books WHERE issue_id=? AND status='ISSUED'");
            ps1.setInt(1, issueId);
            ResultSet rs = ps1.executeQuery();

            if (!rs.next()) {
                System.out.println("Invalid Issue ID or Book already returned!");
                return;
            }

            int bookId = rs.getInt("book_id");

            //Update issued_books table
            PreparedStatement ps2 = con.prepareStatement(
                    "UPDATE issued_books SET status='RETURNED', return_date=CURDATE() WHERE issue_id=?");
            ps2.setInt(1, issueId);
            ps2.executeUpdate();

            //Increase book quantity
            PreparedStatement ps3 = con.prepareStatement(
                    "UPDATE books SET available=available+1 WHERE book_id=?");
            ps3.setInt(1, bookId);
            ps3.executeUpdate();

            //Commit
            con.commit();
            System.out.println("Book Returned Successfully");

        } catch (Exception e) {
            System.out.println("Error Transaction Failed");
            e.printStackTrace();
        }
    }
}
