
class Vehicle {
    protected int maxSpeed;
    protected String fuelType;
    public Vehicle(int maxSpeed, String fuelType){
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }
    public void displayInfo() {
        System.out.println("Max Speed: " + maxSpeed);
        System.out.println("Fuel Type: " + fuelType);
    }
}
class Car extends Vehicle {
    private int seatCapacity;
    public Car(int maxSpeed, String fuelType, int seatCapacity){
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Seat Capacity: " + seatCapacity);
    }
}
class Truck extends Vehicle {
    private double loadCapacity;
    public Truck(int maxSpeed, String fuelType, double loadCapacity){
        super(maxSpeed, fuelType);
        this.loadCapacity = loadCapacity;
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Load Capacity: " + loadCapacity + " tons");
    }
}
class Motorcycle extends Vehicle {
    private boolean hasSideCar;
    public Motorcycle(int maxSpeed, String fuelType, boolean hasSideCar){
        super(maxSpeed, fuelType);
        this.hasSideCar = hasSideCar;
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Has Side Car: " + hasSideCar);
    }
}
public class VehicleHierarchy {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car(200, "Petrol", 5),
            new Truck(150, "Diesel", 15.5),
            new Motorcycle(180, "Petrol", false)
        };
        for (Vehicle v : vehicles) {
            v.displayInfo();
            System.out.println();
        }
    }
}
