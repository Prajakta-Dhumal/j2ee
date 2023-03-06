package storedFunctions;

import java.sql.*;
import java.util.Scanner;

public class Demo1
{
    public static void main(String[] args) {
        Connection con;
        CallableStatement cstmt;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no1");
        int no1=sc.nextInt();
        System.out.println("Enter the  no2");
        int no2=sc.nextInt();
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm","root","sql@123");
            cstmt=con.prepareCall("{?=call addnumbers(?,?)}");
            cstmt.setInt(2,no1);
            cstmt.setInt(3,no2);
            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.execute();
            System.out.println("Addition of no is:"+cstmt.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
