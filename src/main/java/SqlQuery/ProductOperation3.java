package SqlQuery;

import java.sql.*;
import java.util.Scanner;


public class ProductOperation3
{
    static Connection con;
    static {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm", "root", "sql@123");
        } catch (SQLException e)
        {
            System.out.println(e);
        }
    }
    public void addProduct()
    {
        Statement stmt;
        int count;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the product name");
        String pname=sc.next();
        System.out.println("Enter the product category");
        String category=sc.next();
        System.out.println("Enter the product price");
        double price=sc.nextDouble();
        String query="insert into product_data(product_name,product_category,product_price) values('"+pname+"','"+category+"',"+price+")";
        try {
            stmt=con.createStatement();
            count=stmt.executeUpdate(query);
            if (count>0)
            {
                System.out.println("Product inserted sucesfully");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void displayProduct()
    {
        Statement stmt;
        ResultSet rs;

        String query="select * from product_data";
        try {
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            while (rs.next())
            {
                System.out.println("-----------------------------------");
                System.out.println("Product id:"+rs.getInt(1));
                System.out.println("Product name:"+rs.getString(2));
                System.out.println("Product category:"+rs.getString(3));
                System.out.println("Product price:"+rs.getDouble(4));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
