package SqlQuery;

import java.sql.*;
import java.util.Scanner;

public class JdbcDemo12
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the user name:");
        String uname=sc.next();
        System.out.println("Enter the password:");
        String pswd=sc.next();

        Connection con;
        Statement stmt;
        ResultSet rs;

        String query="select user_name,password from login_data";

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm","root","sql@123");
               stmt=con.createStatement();
               rs=stmt.executeQuery(query);
               boolean found=false;
               while (rs.next())
               {
                   String dbuser=rs.getString(1);
                   String dbpassword=rs.getString(2);
                   if (dbuser.equals(uname)&& dbpassword.equals(pswd))
                   {
                       System.out.println("Login sucessfully...");
                       found=true;
                   }
               }
               if (!found)
               {
                   System.out.println("Login failed");
               }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
