package LibraryManagementSystem;

import java.sql.*;

public class IssueBook {

    public static void main(String[] args) {

        try {
            Connection con = DBConnection.getConnection();
            con.setAutoCommit(false);

            // Enter details
            int bookId = 110;
            int memberId = 6;

            // check book available
            PreparedStatement ps1 = con.prepareStatement(
                    "SELECT available FROM books WHERE book_id=?");
            ps1.setInt(1, bookId);
            ResultSet rs1 = ps1.executeQuery();

            if (!rs1.next() || rs1.getInt("available") <= 0) {
                System.out.println("Book not available");
                return;
            }

            // insert issue record
            PreparedStatement ps2 = con.prepareStatement(
                    "INSERT INTO issued_books(book_id,member_id,issue_date,status) VALUES(?,?,CURDATE(),'ISSUED')");
            ps2.setInt(1, bookId);
            ps2.setInt(2, memberId);
            ps2.executeUpdate();

            // update quantity
            PreparedStatement ps3 = con.prepareStatement(
                    "UPDATE books SET available=available-1 WHERE book_id=?");
            ps3.setInt(1, bookId);
            ps3.executeUpdate();

            con.commit();   // success
            System.out.println("Book Issued!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

