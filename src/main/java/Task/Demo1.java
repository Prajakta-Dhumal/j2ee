package Task;

import java.util.Scanner;

public class Demo1
{
    public static void main(String[] args)
    {
        int oddSum=0;
        int evenSum=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array");
        int size=sc.nextInt();
        int arr[]=new int[size];
        for (int i=1;i<arr.length;i++)
        {
            System.out.println("Enter the number to store in array:");
            int num=sc.nextInt();
            arr[i]=num;


        }
        for (int i=1;i<arr.length;i++)
        {
           if (arr[i]%2==0)
           {
               evenSum=arr[i]+evenSum;
           }
    else
           {
             oddSum=arr[i]+oddSum;
           }

        }
        System.out.println("Sum of even number:"+evenSum);
        System.out.println("Sum of odd number:"+oddSum);

    }
}
