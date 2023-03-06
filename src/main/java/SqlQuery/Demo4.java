package SqlQuery;

import java.sql.*;

public class Demo4 {
    public static void main(String[] args) {
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        //Selection of query
        String query="Select * from product_data";
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm","root","sql@123");
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            while (rs.next()){
                System.out.println("------------------------------------");
                System.out.println("Product_id:"+rs.getInt(1));
                System.out.println("Product_name:"+rs.getString(2));
                System.out.println("Product_category:"+rs.getString(3));
                System.out.println("Product_price:"+rs.getDouble(4));
                System.out.println("-----------------------------------------");


            }

        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        finally
        {
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
                    if (rs!=null){
                        try {
                            rs.close();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }

        }
    }
}
