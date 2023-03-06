package Task;

public class Institute
{
    int id;
    String iname;
    String city;
    int no_of_course;
    int no_of_std;

  public  Institute(int id,String iname,String city,int no_of_course,int no_of_std)
    {
        this.id=id;
        this.iname=iname;
        this.city=city;
        this.no_of_course=no_of_course;
        this.no_of_std=no_of_std;
    }
   public String toString()
   {
      return "Institute id: " +id+"\nInstitute name: "+iname+"\nInsitute city: "+city+"\nno_of_std: "+no_of_std+"\nno_of_course: "+no_of_course;
    }


}
