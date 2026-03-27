import java.sql.*;
import java.util.Scanner;

public class BookTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "system",
                    "manager"
            );

            con.setAutoCommit(true);
            System.out.println("Connected successfully!");

            Statement s = con.createStatement();

            // Create table safely
            try {
                String createSQL = "CREATE TABLE Book(" +
                        "BookId NUMBER PRIMARY KEY," +
                        "Title VARCHAR2(50)," +
                        "Author VARCHAR2(50)," +
                        "Price NUMBER)";
                s.executeUpdate(createSQL);
                System.out.println("Table created successfully!");
            } catch (SQLException e) {
                System.out.println("Table already exists!");
            }

            int cont;

            do {
                System.out.println("\n===== MENU =====");
                System.out.println("1.Insert Book Details");
                System.out.println("2.Display all Books");
                System.out.println("3.Display Book Based on Title");
                System.out.println("4.Display All Books of a Given Author");
                System.out.println("5.Update price of a given Book");
                System.out.println("6.Delete a given Book");

                System.out.print("Enter choice: ");
                int ch = sc.nextInt();
                sc.nextLine(); //  clear buffer

                switch (ch) {

                    //  INSERT
                    case 1:
                        String insertSQL = "INSERT INTO Book VALUES (?,?,?,?)";
                        PreparedStatement ps = con.prepareStatement(insertSQL);

                        System.out.print("Id: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Title: ");
                        String title = sc.nextLine();

                        System.out.print("Author: ");
                        String author = sc.nextLine();

                        System.out.print("Price: ");
                        int price = sc.nextInt();

                        ps.setInt(1, id);
                        ps.setString(2, title);
                        ps.setString(3, author);
                        ps.setInt(4, price);

                        ps.executeUpdate();
                        System.out.println(" Book inserted!");
                        break;

                    //  DISPLAY ALL
                    case 2:
                        ResultSet rs = s.executeQuery("SELECT * FROM Book");

                        boolean hasData = false;

                        while (rs.next()) {
                            hasData = true;
                            System.out.println(
                                    rs.getInt("BookId") + " | " +
                                    rs.getString("Title") + " | " +
                                    rs.getString("Author") + " | " +
                                    rs.getInt("Price")
                            );
                        }

                        if (!hasData) {
                            System.out.println(" No books found!");
                        }
                        break;

                    //  SEARCH BY TITLE
                    case 3:
                        System.out.print("Enter Title: ");
                        String searchTitle = sc.nextLine();

                        String sql1 = "SELECT * FROM Book WHERE Title=?";
                        PreparedStatement ps1 = con.prepareStatement(sql1);
                        ps1.setString(1, searchTitle);

                        ResultSet rs1 = ps1.executeQuery();

                        boolean found = false;

                        while (rs1.next()) {
                            found = true;
                            System.out.println(
                                    rs1.getInt(1) + " | " +
                                    rs1.getString(2) + " | " +
                                    rs1.getString(3) + " | " +
                                    rs1.getInt(4)
                            );
                        }

                        if (!found) {
                            System.out.println(" Book not found!");
                        }
                        break;

                    //  SEARCH BY AUTHOR
                    case 4:
                        System.out.print("Enter Author: ");
                        String searchAuthor = sc.nextLine();

                        String sql2 = "SELECT * FROM Book WHERE Author=?";
                        PreparedStatement ps2 = con.prepareStatement(sql2);
                        ps2.setString(1, searchAuthor);

                        ResultSet rs2 = ps2.executeQuery();

                        boolean foundAuthor = false;

                        while (rs2.next()) {
                            foundAuthor = true;
                            System.out.println(
                                    rs2.getInt(1) + " | " +
                                    rs2.getString(2) + " | " +
                                    rs2.getString(3) + " | " +
                                    rs2.getInt(4)
                            );
                        }

                        if (!foundAuthor) {
                            System.out.println(" No books found for this author!");
                        }
                        break;

                    //  UPDATE
                    case 5:
                        System.out.print("Enter Book ID: ");
                        int uid = sc.nextInt();

                        System.out.print("Enter New Price: ");
                        int newPrice = sc.nextInt();

                        String sql3 = "UPDATE Book SET Price=? WHERE BookId=?";
                        PreparedStatement ps3 = con.prepareStatement(sql3);

                        ps3.setInt(1, newPrice);
                        ps3.setInt(2, uid);

                        int rows = ps3.executeUpdate();

                        if (rows > 0)
                            System.out.println(" Updated!");
                        else
                            System.out.println(" Book not found!");
                        break;

                    // DELETE
                    case 6:
                        System.out.print("Enter Book ID: ");
                        int did = sc.nextInt();

                        String sql4 = "DELETE FROM Book WHERE BookId=?";
                        PreparedStatement ps4 = con.prepareStatement(sql4);

                        ps4.setInt(1, did);

                        int d = ps4.executeUpdate();

                        if (d > 0)
                            System.out.println(" Deleted!");
                        else
                            System.out.println(" Book not found!");
                        break;

                    default:
                        System.out.println(" Invalid choice!");
                }

                System.out.print("Continue? (1-Yes / 0-No): ");
                cont = sc.nextInt();

            } while (cont == 1);

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

/*
output
  Connected successfully!
Table created successfully!

===== MENU =====
1.Insert Book Details
2.Display all Books
3.Display Book Based on Title
4.Display All Books of a Given Author
5.Update price of a given Book
6.Delete a given Book
Enter choice: 1
Id: 12
Title: wof
Author: apj
Price: 650
 Book inserted!
Continue? (1-Yes / 0-No): 1

===== MENU =====
1.Insert Book Details
2.Display all Books
3.Display Book Based on Title
4.Display All Books of a Given Author
5.Update price of a given Book
6.Delete a given Book
Enter choice: 6
Enter Book ID: 45
 Book not found!
Continue? (1-Yes / 0-No): 1

===== MENU =====
1.Insert Book Details
2.Display all Books
3.Display Book Based on Title
4.Display All Books of a Given Author
5.Update price of a given Book
6.Delete a given Book
Enter choice: 6
Enter Book ID: 12
 Deleted!
Continue? (1-Yes / 0-No): 1

===== MENU =====
1.Insert Book Details
2.Display all Books
3.Display Book Based on Title
4.Display All Books of a Given Author
5.Update price of a given Book
6.Delete a given Book
Enter choice: 2
 No books found!
Continue? (1-Yes / 0-No): 1

===== MENU =====
1.Insert Book Details
2.Display all Books
3.Display Book Based on Title
4.Display All Books of a Given Author
5.Update price of a given Book
6.Delete a given Book
Enter choice: 3
Enter Title: hh
 Book not found!
Continue? (1-Yes / 0-No): 0
  */
