package SqlQuery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcDemo16
{
    public static void main(String[] args)
    {
        Student_Data st=new Student_Data();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your choice:\n1.Add student\n2.Search Student");
        int choice=sc.nextInt();
        if (choice==1)
        {
            st.add_student();
        }
        else if (choice==2)
        {
            System.out.println("select the option\n1.Search by id\n2.Search by name\n3.Search by stream");
            int option=sc.nextInt();
            if (option==1)
            {
                System.out.println("Enter the id");
                int id=sc.nextInt();
                st.searchById(id);
            }
            else if (option==2)
            {
                System.out.println("Enter the name for search:");
                String name=sc.next();
                st.searchByName(name);
            } else if (option==3)
            {
                System.out.println("Enter the Stream for search:");
                String stream=sc.next();
                st.searchByStream(stream);
            }
            else
            {
                System.out.println("Invalid choice");
            }


        }


    }
}
