package Mobile_App;

import java.util.Scanner;

public class Main_App
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        MobileOperation op=new MobileOperation();
        System.out.println("==========================");
        op.getCmpanyName();
        System.out.println("==========================");
        System.out.println("select the company:");
        String company=sc.next();
        System.out.println("======================");
        op.getModelName(company);
        System.out.println("======================");
        System.out.println("Enter the model name:");
        String model=sc.next();
        System.out.println("========================");
        op.getModelDetails(model);
        System.out.println("========================");
        System.out.println("Enter the units you want to purchase:");
        System.out.println("=========================");
        int units=sc.nextInt();
        System.out.println("=========================");
        op.getUnits(units,model);


    }
}
