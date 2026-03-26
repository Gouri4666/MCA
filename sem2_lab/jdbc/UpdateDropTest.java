import java.sql.*;

public class UpdateDropTest {
    public static void main(String[] args) {
        try {
            // 1. Load driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 2. Create connection
            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/XEPDB1",
                "gouri",
                "gouri123"
            );

            System.out.println("Connected Successfully!");

            // 3. UPDATE using PreparedStatement 🔥
            String updateQuery = "UPDATE student SET name = ?, age = ? WHERE id = ?";

            PreparedStatement ps = con.prepareStatement(updateQuery);

            ps.setString(1, "Alex");
            ps.setInt(2, 25);
            ps.setInt(3, 1);   // update record with id = 1

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Record Updated Successfully!");
            } else {
                System.out.println("No record found to update!");
            }

            // 4. DROP TABLE
            Statement stmt = con.createStatement();

            String dropQuery = "DROP TABLE student";

            stmt.executeUpdate(dropQuery);
            System.out.println("Table Dropped Successfully!");

            // 5. Close connection
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

/*
output

Connected Successfully!
Record Updated Successfully!
Table Dropped Successfully!

*/
