package storedprocedures;

import java.sql.*;
import java.util.Scanner;

public class CountOfCategory
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the category ");
        String category=sc.next();
        Connection con;
        CallableStatement cstmt;
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm","root","sql@123");
            cstmt=con.prepareCall("{call countcategory(?,?)}");
            cstmt.setString(1,category);
            cstmt.registerOutParameter(2, Types.INTEGER);
            cstmt.execute();
            System.out.println("Total number of product is "+cstmt.getInt(2));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
