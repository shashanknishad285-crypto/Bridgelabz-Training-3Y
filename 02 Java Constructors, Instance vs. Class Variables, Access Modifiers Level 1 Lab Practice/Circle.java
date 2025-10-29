
public class Circle {
    private double radius;

    // Default constructor
    public Circle() {
        this(1.0);
    }

    // Parameterized constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    public void displayCircle() {
        System.out.printf("Radius: %.2f, Area: %.4f, Circumference: %.4f\n", radius, Math.PI*radius*radius, 2*Math.PI*radius);
    }

    public static void main(String[] args) {
        Circle c1 = new Circle();
        Circle c2 = new Circle(2.5);
        c1.displayCircle();
        c2.displayCircle();
    }
}
