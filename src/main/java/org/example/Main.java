package org.example;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static class Demo3 {
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the id for update");
            int id=sc.nextInt();
            Connection con=null;
            Statement stmt=null;
            String qurey=null;
            System.out.println("Enter your choice to update the details\n1.Updtae name\n2.update category\n3.update price");
            int choice=sc.nextInt();
            if (choice==1)
            {
                System.out.println("Enter the latest name for update");
                String name=sc.next();
                qurey="update product_data set product_name=name where id=id";
                System.out.println("Product updated sucesfully");
            }

        }
    }
}