package SqlQuery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcDemo14
{
    public static void main(String[] args) {
        Connection con;
        PreparedStatement pstmt;
        String  query="insert into product_data values(?,?,?,?)";
        //connection
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm","root","sql@123");
           pstmt=con.prepareStatement(query);

           //set values
            pstmt.setInt(1,0);
            pstmt.setString(2,"HEADPHONES");
            pstmt.setString(3,"GADGETS");
            pstmt.setDouble(4,40000.45);
            int count=pstmt.executeUpdate();
            pstmt.setInt(1,0);
            pstmt.setString(2,"PROJECTOR");
            pstmt.setString(3,"ELECTRONICS");
            pstmt.setDouble(4,25000.50);
            int count1=pstmt.executeUpdate();
            System.out.println(count+count1 +"Record inserted sucesfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
