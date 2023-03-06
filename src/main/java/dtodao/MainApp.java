package dtodao;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp
{
      static Scanner sc=new Scanner(System.in);
   static BookDao b1=new BookDao();
    public static void main(String[] args)
    {

        System.out.println("Select your choice");
        System.out.println("1:ADD BOOK");
        System.out.println("2:DELETE BOOK:");
        System.out.println("3:SHOW BOOK");
        int choice=sc.nextInt();
        if (choice==1)
        {
          insertBook();
        } else if (choice==2)
        {
           removeBook();
        } else if (choice==3)
        {
            showBooks();
        }
        else {
            System.out.println("Invalid choice");
        }
    }
    static void insertBook()
    {
        //accept bookName,book price
        System.out.println("Enter the book name:");
        String name=sc.next();
        System.out.println("Enter the book price:");
        double price=sc.nextDouble();
        Book_Dto b2=new Book_Dto();
        //call the setter method to set the value of name & price;
        b2.setBookName(name);
        b2.setBookPrice(price);
        //Call the addBook() from DAO class and pass object variable
        int count=b1.addBook(b2);
        System.out.println(count+"BOOK INSERTED SUCESSFULLY");

    }
    static void removeBook()
    {
    //Accept Id from user to delete Book
        System.out.println("Enter the Book id");
        int bookId=sc.nextInt();
        //create object of DTO-->class to access the setter method of id
        Book_Dto b2=new Book_Dto();
        b2.setBookId(bookId);
        //Call deleteBook() from DAO--> class
        int count=b1.deleteBook(b2);
        System.out.println(count+"BOOK DELETED SUCESFULLY...");
    }
    static void showBooks()
    {
//        Book_Dto b=new Book_Dto();
       ArrayList<Book_Dto> b2 = b1.displayBooks();
       for(Book_Dto b1 : b2)
       {
           System.out.println(b1);

       }


    }



}

