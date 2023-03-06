package Mobile_App;

import java.sql.*;

public class MobileOperation
{
    static Connection con=null;
    static
    {
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm","root","sql@123");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void getCmpanyName()
    {
        Statement stmt=null;
        ResultSet rs=null;
        String query="select distinct(company) from mobile_info";
        try {
            stmt=con.createStatement();
           rs= stmt.executeQuery(query);
           while (rs.next())
           {
               System.out.println(rs.getString(1));
           }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void getModelName(String company)
    {
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String query="select model from mobile_info where company=?";
        try {

           pstmt= con.prepareStatement(query);
           pstmt.setString(1,company);
           rs=pstmt.executeQuery();
           while (rs.next())
           {
               System.out.println(rs.getString(1));
           }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void getModelDetails(String model)
    {
        PreparedStatement pstmt;
        ResultSet rs;
        String query="select * from mobile_info where model=?";
        try {
            pstmt=con.prepareStatement(query);
            pstmt.setString(1,model);
           rs= pstmt.executeQuery();
           boolean found=false;
           while (rs.next())
           {
               System.out.println(rs.getInt(1));
               System.out.println(rs.getString(2));
               System.out.println(rs.getString(3));
               System.out.println(rs.getDouble(4));
               System.out.println(rs.getInt(5));
               found=true;

           }
           if (!found)
           {
               System.out.println("model not valid");
           }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void getUnits(int units,String model)
    {
        PreparedStatement pstmt;
        ResultSet rs;
        int stock=0;
        String query="select price,stock from mobile_info where model=?";
        String query1="update mobile_info set stock=? where model=?";
        try {
            pstmt=con.prepareStatement(query);
            pstmt.setString(1,model);
            rs=pstmt.executeQuery();
            if(rs.next())
            {
                double price=rs.getDouble(1);
                stock=rs.getInt(2);

                if(units<=stock)
                {
                    double total=price*units;
                    System.out.println("TOTAL AMOUNT:"+total);
                    pstmt= con.prepareStatement(query1);
                    pstmt.setInt(1,stock-units);
                    pstmt.setString(2,model);
                    pstmt.executeUpdate();
                    System.out.println("Units updated sucesfully");

                }
                else
                {
                    System.out.println("Out of stock....");
                }
            }
            else
            {
                System.out.println("Invalid model");
            }



        } catch (SQLException e) {
            System.out.println(e);
        }

    }


}
