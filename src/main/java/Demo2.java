import java.sql.*;
import java.util.Scanner;

public class Demo2
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the product id");
        int product_id=sc.nextInt();
        System.out.println("Enter the product name");
        String product_name=sc.next();
        System.out.println("Enter the product category:");
        String product_category=sc.next();
        System.out.println("Enter the product price");
        double product_price=sc.nextDouble();

        //Declare the resources
        Connection con=null;
        Statement stmt=null;

        //Create sql server
        String query="insert into product_data values("+product_id+",'"+product_name+"','"+product_category+"',"+product_price+")";
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm","root","sql@123");
            stmt=con.createStatement();
            int count=stmt.executeUpdate(query);
            System.out.println(count);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            if (con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                if (stmt!=null){
                    try {
                        stmt.close();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        }
    }

}
