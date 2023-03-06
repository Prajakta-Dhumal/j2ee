package storedprocedures;

import java.sql.*;
import java.util.Scanner;

public class InsertRecords
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the model name");

        String model_name= sc.next();
        System.out.println("Enter the company name");
        String company=sc.next();
        System.out.println("Enter the price ");
        double price=sc.nextDouble();
        System.out.println("Enter the stock");
        int stock=sc.nextInt();
        Connection con;
        CallableStatement cstmt;
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm","root","sql@123");
            cstmt=con.prepareCall("{call addmobileinfo(?,?,?,?)}");
            cstmt.setString(1,model_name);
            cstmt.setString(2,company);
            cstmt.setDouble(3,price);
            cstmt.setInt(4,stock);
            cstmt.execute();
            System.out.println("Procedures executed sucessfully");
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

}
