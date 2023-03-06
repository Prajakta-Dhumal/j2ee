package SqlQuery;

import java.sql.*;
import java.util.Scanner;

public class Student_Data
{
    static Connection con;
    static
    {
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm","root","sql@123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void add_student()
    {
        PreparedStatement pstmt;

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the student name:");
        String name=sc.next();
        System.out.println("Enter the student Stream:");
        String stream=sc.next();
        System.out.println("Enter the perceantage:");
        double per=sc.nextDouble();
        String query="insert into student_info(student_name,stream,percentage) values(?,?,?)";
        try {
            pstmt=con.prepareStatement(query);
            pstmt.setString(1,name);
            pstmt.setString(2,stream);
            pstmt.setDouble(3,per);
            int count= pstmt.executeUpdate();
            System.out.println(count+"record insertes sucefully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void searchById(int id)
    {

        PreparedStatement pstmt=null;
        ResultSet rs=null;


       String query="select * from student_info where student_id=?";
        try {
            pstmt= con.prepareStatement(query);
            pstmt.setInt(1,id);
            boolean found=false;
            rs=pstmt.executeQuery();
            if (rs.next())
            {
                System.out.println("-------------------------");
                System.out.println( rs.getInt(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getDouble(4));
                found=true;

            }
            else
            {
                System.out.println("Student does not exit");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void searchByName(String name){
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        String query="select * from student_info where student_name=?";
        try {
            pstmt= con.prepareStatement(query);
            pstmt.setString(1,name);
            boolean found=false;
            rs=pstmt.executeQuery();
            if (rs.next())
            {
                System.out.println("-------------------------");
                System.out.println("Student id: "+rs.getInt(1));
                System.out.println("Stdent name: "+rs.getString(2));
                System.out.println("Student stream: "+rs.getString(3));
                System.out.println("Student percentage:"+rs.getDouble(4));
                found=true;

            }
            else
            {
                System.out.println("Student does not exit");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }


    }
    public void searchByStream(String stream){
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String query="select * from student_info where stream=?";
        try {
            pstmt= con.prepareStatement(query);
            pstmt.setString(1,stream);
            boolean found=false;
            rs=pstmt.executeQuery();
            if (rs.next())
            {
                System.out.println("-------------------------");
                System.out.println( "Student id"+rs.getInt(1));
                System.out.println("Student name"+rs.getString(2));
                System.out.println("Student stream"+rs.getString(3));
                System.out.println("percentage"+rs.getDouble(4));
                found=true;

            }
            else
            {
                System.out.println("Student does not exit");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }


    }
}
