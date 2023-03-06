package dtodao;

import java.util.Scanner;

public class Course_mainApp
{
    static Course_Dao c1=new Course_Dao();
    static  Scanner sc=new Scanner(System.in);
    public static void main(String[] args)
    {
        System.out.println("Enter the mode of operation:");
        System.out.println("1:Add course details:");
        System.out.println("2.Remove the course");
        System.out.println("3.Display all course details");
        Scanner sc=new Scanner(System.in);
        int choice=sc.nextInt();
        if (choice==1){
            insertCourse();
        }


    }
    public static void insertCourse()
    {
        int count=0;
        //accept the course details from user
        System.out.println("Enter the course id");
        int cId=sc.nextInt();
        System.out.println("Enter the course name");
        String cName=sc.next();
        System.out.println("Enter the course fees");
        double fees=sc.nextDouble();
        Course_Dto c2=new Course_Dto();
        c2.setCourse_id(cId);
        c2.setCourse_name(cName);
        c2.setCourse_fee(fees);
        count= c1.addCourse(c2);
        System.out.println(count+"Course added sucesfully");

    }

}
