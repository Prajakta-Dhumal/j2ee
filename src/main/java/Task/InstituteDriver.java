package Task;

import java.util.Scanner;

public class InstituteDriver
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        boolean exit=true;
        ArrayListDemo a1=new ArrayListDemo();
        while (exit) {
            System.out.println("Select the option \n1.add Institute\n2.Remove institue\n3.display Intitute\n4.exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    a1.addInstitute();
                    break;
                case 2:
                    a1.removeInstitue();
                    break;
                case 3:
                    a1.displayDetails();
                    break;
                case 4: {
                    exit = false;
                    System.out.println("application closed sucessfully");
                }
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
