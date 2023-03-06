package SqlQuery;

import java.util.Scanner;

public class jbdcDemo11
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        productOperation2 op=new productOperation2();
        System.out.println("Enter your choice:\n1.Product details with max price\n2.Product details with min price");
        int choice=sc.nextInt();
        if (choice==1){
            op.maxProduct();
        } else if (choice==2) {
          op.minProduct();
        }
    }
}
