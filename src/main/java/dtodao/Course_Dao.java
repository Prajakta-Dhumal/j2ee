package dtodao;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;

public class Course_Dao
{
    static Connection con;
    static {
        try {
            DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm","root","sql@123");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
 public int addCourse(Course_Dto c1)
 {
     PreparedStatement pstmt;
     int count=0;
     String query="insert into course_details(course_name,course_fee) values(?,?)";
     try {
        pstmt= con.prepareStatement(query);
        pstmt.setString(1,c1.getCourse_name());
        pstmt.setDouble(2,c1.getCourse_fee());
       count= pstmt.executeUpdate();
     } catch (SQLException e) {
         System.out.println(e);
     }
     return count;
 }


}
