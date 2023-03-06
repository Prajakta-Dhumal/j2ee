package storedFunctions;

import java.sql.*;
import java.util.Scanner;

public class Demo4
{
    public static void main(String[] args)
    {
        Connection con;
        CallableStatement cstmt;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the credit score");
        double credit=sc.nextDouble();
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm","root","sql@123");
            cstmt=con.prepareCall("{?=call loanAccept1(?)}");
            cstmt.setDouble(2,credit);
            cstmt.registerOutParameter(1, Types.DOUBLE);
            cstmt.execute();
            System.out.println("Final result is:"+cstmt.getString(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
