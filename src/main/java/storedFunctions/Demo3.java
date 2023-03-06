package storedFunctions;

import java.sql.*;
import java.util.Scanner;

public class Demo3
{
    public static void main(String[] args) {
        Connection con;
        CallableStatement cstmt;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the quantity");
        int quantity= sc.nextInt();
        System.out.println("Enter the price:");
        double price= sc.nextDouble();

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm","root","sql@123");
            cstmt=con.prepareCall("{?=call product_bill(?,?)}");
            cstmt.setInt(2,quantity);
            cstmt.setDouble(3,price);
            cstmt.registerOutParameter(1, Types.DOUBLE);
            cstmt.execute();
            System.out.println("Finally bill of product is:"+cstmt.getDouble(1));

        } catch (SQLException e) {
            System.out.println(e);

        }
    }
}
