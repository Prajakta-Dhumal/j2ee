package SqlQuery;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.Scanner;

public class Demo8
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the lowest price:");
        int lower_price=sc.nextInt();
        System.out.println("Enter the higest price:");
        int higher_price=sc.nextInt();
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;

        //Selection query
        String query="select * from product_data where product_price between "+lower_price+" and "+higher_price+" ";
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm", "root", "sql@123");
            stmt = con.createStatement();
            rs=stmt.executeQuery(query);
            while (rs.next())
            {
                System.out.println("------------------------------------");
                System.out.println("Product_id:"+rs.getInt(1));
                System.out.println("Product_name:"+rs.getString(2));
                System.out.println("Product_category:"+rs.getString(3));
                System.out.println("Product_price:"+rs.getDouble(4));
                System.out.println("-----------------------------------------");

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }
}
