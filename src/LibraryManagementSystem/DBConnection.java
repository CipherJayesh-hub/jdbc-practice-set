// it is a connection java utility class for stablished connection
// use don't rewrite the connection credential in every file just use thia class object
package LibraryManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 class DBConnection {

            // 1. Connection credentials (private = secure)
            private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
            private static final String URL = "Database Url";
            private static final String USER = "root";
            private static final String PASSWORD = "Password";

            // 2. Method to get connection
            public static Connection getConnection() throws SQLException {
                try {
                    // Load Driver
                    Class.forName(DRIVER);
                } catch (ClassNotFoundException e) {
                    // Convert checked exception into runtime-friendly message
                    throw new SQLException("JDBC Driver not found", e);
                }

                // Return connection
                return DriverManager.getConnection(URL, USER, PASSWORD);
            }
        }



