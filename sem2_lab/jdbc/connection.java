import java.sql.*;
public class Connection 
{
    public static void main(String[] args) 
    {
        try
        {
            //load driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //create connection
            Connection con=DriverManager.getConnection(
                "jdbc:oracle:thin:@//localhost:1521/XEPDB1",
                "gouri","gouri123"
            );
            System.out.println("Connected sucessufully!");
            con.close();
        }   
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}

/*output
  Connected sucessufully!
  */
