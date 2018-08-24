public class Student {

    private String name;
    private int Id;

    public Student(String name, int Id){
        if (name == null || Id < 0){
            throw new IllegalArgumentException("Name or Id cannot be null");
        }
        this.name = name;
        this.Id = Id;
    }

    public String getName(){
        return this.name;
    }

    public int getId(){
        return this.Id;
    }
}

