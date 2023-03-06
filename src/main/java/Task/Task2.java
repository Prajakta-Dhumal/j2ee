package Task;

public class Task2
{
    public static void main(String[] args) {
        int max=0;
        int secondMax=0;
        int arr[]= {1,7,3,4,5,6};
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>max)
            {
                secondMax=max;
                max=arr[i];
            }
            if(arr[i]>secondMax && max>arr[i])
            {
                secondMax=arr[i];
            }
        }
        System.out.print("Second Max NUmber Is : "+secondMax);
    }
}
