package LibraryManagementSystem;

import java.sql.*;

public class ViewAllMembers {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        DBConnection db = new DBConnection();
        String sql = "SELECT * FROM members";
        try{
            connection = db.getConnection();
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                System.out.println(
                        rs.getInt("member_id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getString("email") + " | " +
                                rs.getString("phone") + " | " +
                                rs.getString("join_date") + " | " +
                                rs.getString("status")
                );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try{
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
