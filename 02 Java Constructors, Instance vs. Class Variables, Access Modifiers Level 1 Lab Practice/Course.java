
public class Course {
    private String courseName;
    private int duration;
    private double fee;
    private static String instituteName = "GLA University";

    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName +
            ", Duration: " + duration +
            ", Fee: " + fee +
            ", Institute: " + instituteName);
    }

    public static void updateInstituteName(String name) {
        instituteName = name;
    }

    public static void main(String[] args) {
        Course c1 = new Course("Java", 30, 4900.0);
        c1.displayCourseDetails();
        Course.updateInstituteName("Code Academy");
        c1.displayCourseDetails();
    }
}
