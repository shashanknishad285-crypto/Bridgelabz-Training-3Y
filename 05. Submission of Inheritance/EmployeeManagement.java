
class Employee {
    protected String name;
    protected int id;
    protected double salary;
    public Employee(String name, int id, double salary){
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    public void displayDetails(){
        System.out.println("Name: " + name + ", ID: " + id + ", Salary: " + salary);
    }
}
class Manager extends Employee {
    private int teamSize;
    public Manager(String name, int id, double salary, int teamSize){
        super(name, id, salary);
        this.teamSize = teamSize;
    }
    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Team Size: " + teamSize);
    }
}
class Developer extends Employee {
    private String programmingLanguage;
    public Developer(String name, int id, double salary, String programmingLanguage){
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }
    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}
class Intern extends Employee {
    private String college;
    public Intern(String name, int id, double salary, String college){
        super(name, id, salary);
        this.college = college;
    }
    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("College: " + college);
    }
}
public class EmployeeManagement {
    public static void main(String[] args) {
        Employee[] employees = {
            new Manager("Alice", 1, 75000, 10),
            new Developer("Bob", 2, 60000, "Java"),
            new Intern("Charlie", 3, 20000, "XYZ University")
        };
        for (Employee e : employees) {
            e.displayDetails();
            System.out.println();
        }
    }
}
