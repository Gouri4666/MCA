import java.sql.*;
import java.util.*;
class AllinOne
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "system",
                "root"
            );
            System.out.println("Connected!");
            //create table
            Statement s=con.createStatement();
            try
            {
                s.executeUpdate("create table book(id number,title varchar2(25),author varchar2(25),price number)");
                System.out.println("table created!");
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            //insert value
            try
            {
                PreparedStatement ps=con.prepareStatement("insert into book(id,title,author,price) values (?,?,?,?)");
                ps.setInt(1,1);
                ps.setString(2,"WOF");
                ps.setString(3, "APJ");
                ps.setInt(4,650);
                ps.executeUpdate();
                System.out.println("value inserted");

            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            //display
            try
            {
                ResultSet rs=s.executeQuery("select * from book");
                boolean found=false;
                while(rs.next())
                {
                found=true;
                int id=rs.getInt("id");
                String title=rs.getString("title");
                String author=rs.getString("author");
                int price=rs.getInt("price");
                System.out.println(id+" "+title+" "+author+" "+price);
                }   
                if(!found)
                {
                    System.out.println("Not found!");
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            //update price
            try
            {
                PreparedStatement ps2=con.prepareStatement("update book set price=? where id=?");
                ps2.setInt(1,700);
                ps2.setInt(2,10);
                int update=ps2.executeUpdate();
                if(update>0)
                {
                    System.out.println("Price updated");
                }else
                {
                    System.out.println("Updateion failed");
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            //insert one value too
            try
            {
                PreparedStatement ps3=con.prepareStatement("insert into book(id,title,author,price) values (?,?,?,?)");
                ps3.setInt(1,2);
                ps3.setString(2,"Freedom");
                ps3.setString(3,"MGandhi");
                ps3.setInt(4,540);
                ps3.executeUpdate();
                System.out.println("one row inserted");
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            //display
            try
            {
                ResultSet rs2=s.executeQuery("select * from book");
                boolean found=false;
                while(rs2.next())
                {
                    found=true;
                    int id=rs2.getInt("id");
                    String title=rs2.getString("title");
                    String author=rs2.getString("author");
                    int price=rs2.getInt("price");                    
                    System.out.println(id+" "+title+" "+author+" "+price);
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            //diaply book with id 2
            try
            {
                PreparedStatement ps4=con.prepareStatement("select * from book where id=?");
                ps4.setInt(1,2);
                ResultSet rs3=ps4.executeQuery();
                
                boolean found=false;
                while(rs3.next())
                {
                    found=true;
                    int id=rs3.getInt("id");
                    String title=rs3.getString("title");
                    String author=rs3.getString("author");
                    int price=rs3.getInt("price");
                    System.out.println(id+" "+title+" "+author+" "+price);
                }
                if(!found)
                {
                    System.out.println("not found!");
                }

            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            //delete book with id=1
            try
            {
                PreparedStatement ps5=con.prepareStatement("delete from book where id=?");
                ps5.setInt(1,1);
                ps5.executeUpdate();
                System.out.println("Deleted row with id=1");
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            //drop table
            PreparedStatement ps6=con.prepareStatement("drop table book");
            ps6.executeUpdate();
            System.out.println("table droped!");
            con.close();
            sc.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
