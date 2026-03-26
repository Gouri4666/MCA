import java.sql.*;

public class InsertTest {
    public static void main(String[] args) {
        try {
            // 1. Load Oracle Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 2. Create Connection
            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/XEPDB1",
                "gouri",
                "gouri123"
            );

            System.out.println("Connected Successfully!");

            // 3. Create Table
            Statement stmt = con.createStatement();

            String createTable = "CREATE TABLE student (" +
                                 "id NUMBER PRIMARY KEY, " +
                                 "name VARCHAR2(50), " +
                                 "age NUMBER)";

            stmt.executeUpdate(createTable);
            System.out.println("Table Created!");



            // 5. Insert using PreparedStatement (IMPORTANT 🔥)
            String insertQuery = "INSERT INTO student VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(insertQuery);

            ps.setInt(1, 1);
            ps.setString(2, "John");
            ps.setInt(3, 22);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Data Inserted Successfully!");
            }

            // 6. Close connection
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

/*output
  Connected Successfully!
Table Created!
Data Inserted Successfully!
  */
