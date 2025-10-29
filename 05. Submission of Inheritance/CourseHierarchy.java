
class Course {
    protected String courseName;
    protected int duration;
    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }
    public void displayCourse(){
        System.out.println("Course: "+courseName+", Duration: "+duration+" hours");
    }
}
class OnlineCourse extends Course {
    protected String platform;
    protected boolean isRecorded;
    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded){
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }
    @Override
    public void displayCourse(){
        super.displayCourse();
        System.out.println("Platform: " + platform + ", Recorded: " + isRecorded);
    }
}
class PaidCourse extends OnlineCourse {
    private double fee;
    private double discount;
    public PaidCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount){
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }
    @Override
    public void displayCourse(){
        super.displayCourse();
        System.out.println("Fee: " + fee + ", Discount: " + discount);
    }
}
public class CourseHierarchy {
    public static void main(String[] args){
        PaidCourse pc = new PaidCourse("Java Programming", 40, "Udemy", true, 200, 10);
        pc.displayCourse();
    }
}
