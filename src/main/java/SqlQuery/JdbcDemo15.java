package SqlQuery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcDemo15
{
    public static void main(String[] args)
    {
        Connection con;
        PreparedStatement pstmt;
         String query="delete from product_data where product_id=?";
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm","root","sql@123");
            pstmt=con.prepareStatement(query);

            //set the values
            pstmt.setInt(1,5);
            int count=pstmt.executeUpdate();
            pstmt.setInt(1,6);
            int count1=pstmt.executeUpdate();
            System.out.println(count+count1 +"Record deleted sucefully");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
