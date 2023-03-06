package SqlQuery;

import java.sql.*;
import java.util.Scanner;

public class Demo6
{
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the product id :");
        int id = sc.nextInt();

        //Selection query
        String query = "Select * from product_data where product_id="+id+"";
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm", "root", "sql@123");
            stmt = con.createStatement();
            rs=stmt.executeQuery(query);
            if (rs.next())
            {
                System.out.println("------------------------------------");
                System.out.println("Product_id:"+rs.getInt(1));
                System.out.println("Product_name:"+rs.getString(2));
                System.out.println("Product_category:"+rs.getString(3));
                System.out.println("Product_price:"+rs.getDouble(4));
                System.out.println("-----------------------------------------");

            }
            else {
                System.out.println("Id does not exits");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            if (con!=null && stmt!=null && rs!=null){
                try {
                    con.close();
                    rs.close();
                    stmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
