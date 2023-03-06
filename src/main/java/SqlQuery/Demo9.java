package SqlQuery;

import java.sql.*;
import java.util.Scanner;

public class Demo9
{
    public static void main(String[] args) {
        Connection con=null;
        ResultSet rs=null;
        Statement stmt=null;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the product_Category:");
        String prod_cate=sc.next();
        //Selection  query
        String query="select * from product_data where product_category='"+prod_cate+"'";

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm","root","sql@123");
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            boolean found=false;
            while (rs.next()){
                System.out.println("------------------------------------");
                System.out.println("Product_id:"+rs.getInt(1));
                System.out.println("Product_name:"+rs.getString(2));
                System.out.println("Product_category:"+rs.getString(3));
                System.out.println("Product_price:"+rs.getDouble(4));
                System.out.println("-----------------------------------------");
               found=true;

            }
            if (found==false){
                System.out.println("Product does not exist");
            }

        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

    }
}
