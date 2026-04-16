import java.sql.*;
import java.util.*;
class jdbcrough
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
            System.out.println("Connected!");
            Statement s=con.createStatement();
            //craete table
            try{
                s.executeUpdate("create table book (id number,name varchar2(25))");
                System.out.println("Table created");
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            //insert 1 row
            try
            {
                PreparedStatement ps1=con.prepareStatement("insert into book(id,name) values(?,?)");
                ps1.setInt(1,11);
                ps1.setString(2, "wof");
                ps1.executeUpdate();
                System.out.println("Inserted");
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            //display
            ResultSet rs1=s.executeQuery("select * from book");
            while(rs1.next())
            {
                int id=rs1.getInt("id");
                String name=rs1.getString("name");
                System.out.println(id+" "+name);
            }
            //update name of book
            try{
                PreparedStatement ps2=con.prepareStatement("update  book set name=? where id=?");
                ps2.setString(1, "aadu");
                ps2.setInt(2,11);
                ps2.executeUpdate();
                System.out.println("updated");
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            //display with id
            try{

                PreparedStatement ps3=con.prepareStatement("select * from book where id=?");
                ps3.setInt(1, 11);
                ResultSet rs2=ps3.executeQuery();

                boolean found=false;
                while(rs2.next())
                {
                    found=true;
                    String n=rs2.getString("name");
                    System.out.println("Name: "+n);
                }
                if(!found)
                    System.out.println("Not found");
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            //delete row with id=2
            try{
                PreparedStatement ps4=con.prepareStatement("delete from book where id=?");
                ps4.setInt(1,11);
                ps4.executeUpdate();
                System.out.println("Updated");
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            //drop table
            try
            {
                PreparedStatement ps5=con.prepareStatement("drop table book");
                ps5.executeUpdate();
                System.out.println("droped table");
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            con.close();
            sc.close();
        }
        catch(Exception e)
        {
            System.out.println("Table already Created");
        }
    }
}
