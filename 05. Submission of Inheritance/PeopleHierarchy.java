
class Person {
    protected String name;
    protected int age;
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
}
class Teacher extends Person {
    private String subject;
    public Teacher(String name, int age, String subject){
        super(name, age);
        this.subject = subject;
    }
    public void displayRole(){
        System.out.println("Teacher: " + name + ", Age: " + age + ", Subject: " + subject);
    }
}
class Student extends Person {
    private String grade;
    public Student(String name, int age, String grade){
        super(name, age);
        this.grade = grade;
    }
    public void displayRole(){
        System.out.println("Student: " + name + ", Age: " + age + ", Grade: " + grade);
    }
}
class Staff extends Person {
    private String duty;
    public Staff(String name, int age, String duty){
        super(name, age);
        this.duty = duty;
    }
    public void displayRole(){
        System.out.println("Staff: " + name + ", Age: " + age + ", Duty: " + duty);
    }
}
public class PeopleHierarchy {
    public static void main(String[] args){
        Person[] people = {
            new Teacher("Alice", 40, "Math"),
            new Student("Bob", 16, "10th"),
            new Staff("Charlie", 35, "Security")
        };
        for (Person p : people) {
            if (p instanceof Teacher)
                ((Teacher)p).displayRole();
            else if (p instanceof Student)
                ((Student)p).displayRole();
            else if (p instanceof Staff)
                ((Staff)p).displayRole();
            System.out.println();
        }
    }
}
