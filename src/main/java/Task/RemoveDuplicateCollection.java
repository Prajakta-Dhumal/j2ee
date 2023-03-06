package Task;

import java.util.*;

public class RemoveDuplicateCollection
{
    public static void main(String[] args)
    {
        ArrayList a1=new ArrayList();
        a1.add(10);
        a1.add(20);
        a1.add(30);
        a1.add(10);
        a1.add(20);
        System.out.println(a1.toString());
        Set s1=new LinkedHashSet(a1);
        System.out.println(s1);

    }

}
