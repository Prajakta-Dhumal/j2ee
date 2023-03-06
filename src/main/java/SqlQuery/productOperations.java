package SqlQuery;

import java.sql.*;

//Bussiness Logic
public class productOperations
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
    public void addProduct(String name, String category, double price)
    {
        //Insert product details
        Statement stmt=null;
        String query="insert into product_data(product_name,product_category,product_price) values('"+name+"','"+category+"',"+price+")";
        try {
            stmt=con.createStatement();
            int count=stmt.executeUpdate(query);
            System.out.println(count+"Product added sucesfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void deleteProduct(int id)
    {
        //Delete product details
        Statement stmt=null;
        String query="delete from product_data where product_id=+"+id+"";
        try {
            stmt=con.createStatement();
            int count=stmt.executeUpdate(query);
            System.out.println(count+"Product delete sucesfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void displayDetails()
    {
        //Display details
        Statement stmt;
        ResultSet rs;
         String query="select * from product_data";
        try {
            stmt=con.createStatement();
             rs=stmt.executeQuery(query);
             while (rs.next()){
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
