package SqlQuery;

import java.sql.*;
import java.util.Scanner;

public class JbdcDemo13
{
    public static void main(String[] args)
    {
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        String query=null;
        ProductOperation3 op=new ProductOperation3();
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm","root","sql@123");
        } catch (SQLException e) {
            System.out.println(e);
        }
        Scanner sc=new Scanner(System.in);
        System.out.println("Select the option \n1.Login: \n2.Sign Up:");
        int choice=sc.nextInt();
        if (choice==1)
        {
            System.out.println("Enter the user name:");
            String uname=sc.next();
            System.out.println("Enter the password");
            String pswd= sc.next();
            query="select user_name,password from login_data where user_name='"+uname+"' and password='"+pswd+"'";
            try {

                stmt=con.createStatement();
                rs=stmt.executeQuery(query);
                boolean found=false;
                while (rs.next())
                {
                    String dbnmae = rs.getString(1);
                    String dbpswd=rs.getString(2);
                    if (dbnmae.equals(uname)&& dbpswd.equals(pswd))
                    {
                        System.out.println("Login sucessfully");
                        System.out.println("Enter the choice to \n1.Add product\n2.Display product");
                        int option=sc.nextInt();
                        if (option==1)
                        {
                           op.addProduct();
                        }
                        else if (option==2) {
                            op.displayProduct();

                        }

                     found=false;
                    }

                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        }
        else if (choice==2)
        {
            System.out.println("Enter the user name:");
            String user_name=sc.next();
            System.out.println("Enter the password");
            String user_password=sc.next();
            query="insert into login_data(user_name,password) values('"+user_name+"','"+user_password+"')";
            try {


                stmt=con.createStatement();
                int count=stmt.executeUpdate(query);
                if (count>0)
                {
                    System.out.println("Registration sucessfully");

                }
            } catch (SQLException e) {
                System.out.println(e);
            }


        }

    }
}
