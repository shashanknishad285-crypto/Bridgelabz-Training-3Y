
class Student {
    public String rollNumber;
    protected String name;
    private double CGPA;

    public Student(String rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }
}

class PostgraduateStudent extends Student {
    public PostgraduateStudent(String rollNumber, String name, double CGPA) {
        super(rollNumber, name, CGPA);
    }

    public void showName() {
        System.out.println("PG Student name (protected): " + name);
    }

    public static void main(String[] args) {
        PostgraduateStudent pg = new PostgraduateStudent("P123", "Raj", 8.5);
        pg.showName();
        System.out.println("Roll Number (public): " + pg.rollNumber);
    }
}
