package Task;

import java.util.*;


public class ArrayListDemo
{
    Institute i1;
    ArrayList<Institute> a1=new ArrayList();
   void addInstitute()
   {
      Scanner sc=new Scanner(System.in);
      System.out.println("Enter the id ");
      int id=sc.nextInt();
      System.out.println("Enter the name of institue");
      String name=sc.next();
      System.out.println("Enter the city");
      String city=sc.next();
      System.out.println("Enter the no of course");
      int no_of_course=sc.nextInt();
      System.out.println("Enter the no of std");
      int no_of_std=sc.nextInt();
       i1=new Institute(id,name,city,no_of_course,no_of_std);
      a1.add(i1);
      System.out.println("Insitute added sucesfully");
   }
   void displayDetails(){
     Scanner sc=new Scanner(System.in);
      System.out.println("Enter the id for display details");
      int id=sc.nextInt();
      for (Institute i1:a1)
      {
       if (i1.id==id)
       {
           System.out.println(i1);
       }
       else {
           System.out.println("Invalid id");
       }

       return;
      }
   }
   void removeInstitue()
   {
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter the insitute id");
       int id=sc.nextInt();
       boolean found=false;
       for (Institute i1:a1)
       {
           if (id==i1.id)
           {
              a1.remove(i1);
              found=true;
               System.out.println("Institute removed sucesfully");
           }
           else {
               System.out.println("Insitute does not exits");
           }
           return;
       }
       if (!found){
           System.out.println("Institute does not exit");
       }
   }
}
