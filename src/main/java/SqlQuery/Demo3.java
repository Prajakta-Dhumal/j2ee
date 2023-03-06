package SqlQuery;

import java.sql.*;
import java.util.Scanner;

public class Demo3
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the id ");
        int id=sc.nextInt();
        System.out.println("Enter the name for update:");
        String name=sc.next();
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        String query="update product_data set product_name='"+name+"' where product_id="+id+"";
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm","root","sql@123");
            stmt=con.createStatement();
            int count=stmt.executeUpdate(query);
            System.out.println(count+"product name updated sucesfully");
            if (count>0)
            {
                System.out.println("Record update suces");
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }





    }
}
