package SqlQuery;

import java.sql.*;

public class JdbcDemo17
{
    public static void main(String[] args)
    {
        Connection con;
        PreparedStatement pstmt;
        ResultSet rs=null;
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm","root","sql@123");
            String query="select stream,count(stream) as count from student_info group by stream order by count(stream) desc";
            pstmt=con.prepareStatement(query);
            rs=pstmt.executeQuery();
            while (rs.next())
            {
                System.out.println(rs.getString(1)+":"+rs.getInt(2));
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}
