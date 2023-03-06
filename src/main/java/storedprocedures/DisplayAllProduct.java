package storedprocedures;

import java.sql.*;
import java.util.*;

public class DisplayAllProduct
{
    public static void main(String[] args) {
        Connection con;
        CallableStatement cstmt;
        ResultSet rs;
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm","root","sql@123");
            cstmt=con.prepareCall("{call displayallproduct()}");
            boolean status=cstmt.execute();
            System.out.println(status);  //If status is false then it is DDL Query else it is consider as DML
            rs=cstmt.getResultSet();
            while (rs.next())
            {
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getDouble(4));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
