import java.sql.*;

public class OracleTest {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "system";
        String password = "manager";

        try {
            // Load Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Connect to Oracle
            Connection con = DriverManager.getConnection(url, username, password);
            con.setAutoCommit(true); // ensures inserts are committed immediately
            System.out.println("Connected to Oracle DB successfully!");

            Statement stmt = con.createStatement();

            // 1️⃣ Drop table if it exists
            try {
                stmt.executeUpdate("DROP TABLE students");
                System.out.println("Old table 'students' dropped.");
            } catch (SQLException e) {
                // Ignore error if table does not exist
            }

            // 2️⃣ Create table
            String createTableSQL = "CREATE TABLE students (" +
                                    "id NUMBER PRIMARY KEY, " +
                                    "name VARCHAR2(50), " +
                                    "age NUMBER)";
            stmt.executeUpdate(createTableSQL);
            System.out.println("Table 'students' created successfully.");

            // 3️⃣ Insert rows
            String insertSQL = "INSERT INTO students(id, name, age) VALUES (?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(insertSQL);

            pst.setInt(1, 1);
            pst.setString(2, "Alice");
            pst.setInt(3, 20);
            pst.executeUpdate();

            pst.setInt(1, 2);
            pst.setString(2, "Bob");
            pst.setInt(3, 22);
            pst.executeUpdate();

            System.out.println("Inserted sample students.");

            // 4️⃣ Display rows
            ResultSet rs = stmt.executeQuery("SELECT id, name, age FROM students");
            while(rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                                   ", Name: " + rs.getString("name") +
                                   ", Age: " + rs.getInt("age"));
            }

            // 5️⃣ Drop table at the end (optional)
            stmt.executeUpdate("DROP TABLE students");
            System.out.println("Table 'students' deleted at the end.");

            // Close resources
            rs.close();
            pst.close();
            stmt.close();
            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
