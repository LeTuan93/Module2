class Student {
    public String name;
    public String classes;
    public void Student() {}
    public void setName(String name){
        this.name = name;
    }
    public void setClasses(String classes){
        this.classes = classes;
    }
}

public class TestStudent {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setName("John");
        s1.setClasses("Java");
        System.out.println(s1.name);
        System.out.println(s1.classes);
    }
}