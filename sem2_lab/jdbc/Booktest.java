import java.sql.*;
import java.util.*;
class Test
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
            System.out.println("connected!");
            Statement s=con.createStatement();
            //create table
            try{
                
                s.executeUpdate("create table book(id number,title varchar2(25),author varchar2(25),price number)");
                    System.out.println("table created");
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            //main
            int ch,cont;
            do
            {
                System.out.println("Menu");
                System.out.println("1.Insert");
                System.out.println("2.Display All");
                System.out.println("3.Display on title");
                System.out.println("4.Display on author");
                System.out.println("5.Update price");
                System.out.println("6.Delete a book");
                System.out.print("Enter choice: ");
                ch=sc.nextInt();
                switch(ch)
                {
                case 1:
                    {
                    //insert
                    PreparedStatement ps1=con.prepareStatement("Insert into book(id,title,author,price) values(?,?,?,?)");
                    System.out.print("Enter id: ");
                    int id=sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter title: ");
                    String title=sc.nextLine();
                    System.out.print("Enter author: ");
                    String author=sc.nextLine();
                    System.out.print("Enter price: ");
                    int price=sc.nextInt();
                    
                    ps1.setInt(1,id);
                    ps1.setString(2, title);
                    ps1.setString(3,author);
                    ps1.setInt(4,price);
                    int res1=ps1.executeUpdate();
                    if(res1>0)
                        System.out.println("1 row inserted");
                    else
                        System.out.println("Insertiob failed!");
                }
                    break;
                case 2:
                    {
                    //diaplay all
                    ResultSet rs1=s.executeQuery("select * from book");
                    boolean found=false;
                    while(rs1.next())
                    {
                        found=true;
                        int id=rs1.getInt("id");
                        String title=rs1.getString("title");
                        String author=rs1.getString("author");
                        int price=rs1.getInt("price");
                        
                        System.out.println(id+" "+title+" "+author+" "+price);
                    }
                    if(!found)
                        System.out.println("Not found");
                    }
                    break;
                case 3:
                    {
                        
                        PreparedStatement ps2=con.prepareStatement("select * from book where title=?");
                        sc.nextLine();
                        System.out.println("Enter title: ");
                        String title=sc.nextLine();
                        ps2.setString(1,title);
                        ResultSet rs2=ps2.executeQuery();
                        
                        
                        boolean found=false;
                        while(rs2.next())
                        {
                            found=true;
                            int id=rs2.getInt("id");
                            String title1=rs2.getString("title");
                            String author=rs2.getString("author");
                            int price=rs2.getInt("price");
                            System.out.println(id+" "+title1+" "+author+" "+price);
                        }
                        if(!found)
                            System.out.println("Not found");
                    }
                    break;
                case 4:
                    {
                        PreparedStatement ps3=con.prepareStatement("select * from book where author=?");
                        sc.nextLine();
                        System.out.println("Enter author to search: ");
                        String a=sc.nextLine();
                        ps3.setString(1, a);
                        ResultSet rs3=ps3.executeQuery();
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
                            System.out.println("Book not found");
                    }
                    break;
                case 5://update price
                    {
                        PreparedStatement ps5=con.prepareStatement("update book set price =? where id=?");
                        System.out.print("Enter id: ");
                        int id=sc.nextInt();
                        System.out.print("Enter price: ");
                        int price=sc.nextInt();
                        ps5.setInt(1,price);
                        ps5.setInt(2,id);
                        int res5=ps5.executeUpdate();
                        if(res5>0)
                            System.out.println("price updated");
                        else
                            System.out.println("updation failed");
                    }
                    break;
                case 6://delete a book
                    {
                        PreparedStatement ps6=con.prepareStatement("delete from book where id=?");
                        System.out.println("Enter id to delete: ");
                        int id=sc.nextInt();
                        ps6.setInt(1,id);
                        int res6=ps6.executeUpdate();
                        if(res6>0)
                            System.out.println("Book deleted");
                        else
                            System.out.println("Cant delete");
                    }
                    break;
                default:System.out.println("Invalid choice!");
                }
                System.out.print("continue: ");
                cont=sc.nextInt();
            }while(cont==1);
            con.close();
            sc.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
