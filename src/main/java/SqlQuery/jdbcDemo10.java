package SqlQuery;

import java.util.Scanner;

public class jdbcDemo10 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        productOperations operations=new productOperations();
        System.out.println("Enter your choice:\n1.Add the Product\n2.Delete the product\n3.Display the product");
        int choice=sc.nextInt();
        if (choice==1)
        {
            System.out.println("Enter the the product name:");
            String name=sc.next();
            System.out.println("Enter the product category:");
            String category=sc.next();
            System.out.println("Enter the product Price");
            double price=sc.nextDouble();
            operations.addProduct(name,category,price);

        }
        else if (choice==2)
        {
            System.out.println("Enter the product id:");
            int id=sc.nextInt();
            operations.deleteProduct(id);

        }
        else if (choice==3)
        {
         operations.displayDetails();
        }
        else
        {
            System.out.println("Invalid choice");
        }
    }
}
