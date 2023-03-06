package dtodao;

import java.sql.*;
import java.util.ArrayList;

public class BookDao
{
    static Connection con;
    static {
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm","root","sql@123");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public int  addBook(Book_Dto b)
    {
        //write insert query
        int count=0;
        PreparedStatement pstmt;
        String query="insert into book_info(book_name,book_price) values(?,?)";
        try {
            pstmt=con.prepareCall(query);
            pstmt.setString(1,b.getBookName());
            pstmt.setDouble(2,b.getBookPrice());
           count= pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return count;
    }
    public int deleteBook(Book_Dto b)
    {
       PreparedStatement pstmt;
       int count=0;
       String query="delete from book_info where b_id=?";
        try {
          pstmt= con.prepareCall(query);
          pstmt.setInt(1,b.getBookId());
          count=pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return count;
    }
    public ArrayList<Book_Dto> displayBooks()
    {
        Statement stmt;
        ResultSet rs;
        ArrayList<Book_Dto> book_List=new ArrayList<>();
        //create
        String query="select * from book_info";
        try {
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            while (rs.next()){
                int id=rs.getInt(1);
                String name=rs.getString(2);
                double price=rs.getDouble(3);
                //add info into DTO class object
                Book_Dto b=new Book_Dto();
                b.setBookId(id);
                b.setBookName(name);
                b.setBookPrice(price);
                //add DTO class object into list
                book_List.add(b);
            }


        } catch (SQLException e) {
            System.out.println(e);
        }
        return book_List;


    }


}
