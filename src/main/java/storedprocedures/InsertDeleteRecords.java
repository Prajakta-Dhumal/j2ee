package storedprocedures;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertDeleteRecords
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the user_id for delete:");
        int id= sc.nextInt();;
        System.out.println("Enter the user_name for insert");
        String user_name=sc.next();
        System.out.println("Enter the password for insert");
        String pswd=sc.next();
        Connection con;
        CallableStatement cstmt;
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm","root","sql@123");
            cstmt=con.prepareCall("{call loginoperations(?,?,?)}");
            cstmt.setInt(1,id);
            cstmt.setString(2,user_name);
            cstmt.setString(3,pswd);
            cstmt.execute();
            System.out.println("Procedures executed sucessfully");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
