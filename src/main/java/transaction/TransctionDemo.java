package transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TransctionDemo
{
    public static void main(String[] args) {
        Connection con=null;
        PreparedStatement pstmt;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the product id for delete the record:");
        int id= sc.nextInt();

        String query="delete from product_data where product_id=?";
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm","root","sql@123");
            con.setAutoCommit(false);
           pstmt= con.prepareStatement(query);
           pstmt.setInt(1,id);
           pstmt.executeUpdate();
            System.out.println("Are you sure to delete the data permantly");
            System.out.println("1:YES\n2:NO");
            int choice=sc.nextInt();
            if (choice==1)
            {
                con.commit();
                System.out.println("Record deleted sucesfully");
            }
            else {
                con.rollback();
                System.out.println("Transction cancelled");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
