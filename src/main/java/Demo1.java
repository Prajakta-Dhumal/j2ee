public class Demo1
{
    public static void main(String[] args)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded sucesfully");
        } catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }

    }
}
