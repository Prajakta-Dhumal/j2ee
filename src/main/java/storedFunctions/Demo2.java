package storedFunctions;

import java.sql.*;
import java.util.Scanner;

public class Demo2
{
    public static void main(String[] args) {
        Connection con;
        CallableStatement cstmt;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the radius");
        double radius=sc.nextDouble();

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm","root","sql@123");
            cstmt=con.prepareCall("{?=call areacirlce(?)}");
            cstmt.setDouble(2,radius);

            cstmt.registerOutParameter(1, Types.DOUBLE);
            cstmt.execute();
            System.out.println("Addition of no is:"+cstmt.getDouble(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
