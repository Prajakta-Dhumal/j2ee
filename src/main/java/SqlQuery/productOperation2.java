package SqlQuery;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class productOperation2
{
    static Connection con;
    static {
        try
        {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm","root","sql@123");
        } catch (SQLException e)
        {
            System.out.println(e);
        }
    }
    public  void maxProduct()
    {
        Statement stmt;
        ResultSet rs;
        String query="select * from product_data where product_price=(select max(product_price) from product_data)";
        try {
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            if (rs.next()){
                System.out.println("------------------------------------");
                System.out.println("Product_id:"+rs.getInt(1));
                System.out.println("Product_name:"+rs.getString(2));
                System.out.println("Product_category:"+rs.getString(3));
                System.out.println("Product_price:"+rs.getDouble(4));
                System.out.println("--------------------------------------");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
   public void minProduct()
    {
        Statement stmt;
        ResultSet rs;
        String query="select * from product_data where product_price=(select min(product_price) from product_data)";
        try {
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            if (rs.next()){
                System.out.println("------------------------------------");
                System.out.println("Product_id:"+rs.getInt(1));
                System.out.println("Product_name:"+rs.getString(2));
                System.out.println("Product_category:"+rs.getString(3));
                System.out.println("Product_price:"+rs.getDouble(4));
                System.out.println("--------------------------------------");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
