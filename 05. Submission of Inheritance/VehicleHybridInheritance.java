
interface Refuelable {
    void refuel();
}
class Vehicle {
    protected int maxSpeed;
    protected String model;
    public Vehicle(int maxSpeed, String model){
        this.maxSpeed = maxSpeed;
        this.model = model;
    }
    public void display(){
        System.out.println("Model: " + model + ", Max Speed: " + maxSpeed);
    }
}
class ElectricVehicle extends Vehicle {
    private int batteryCapacity;
    public ElectricVehicle(int maxSpeed, String model, int batteryCapacity){
        super(maxSpeed, model);
        this.batteryCapacity = batteryCapacity;
    }
    public void charge(){
        System.out.println("Charging the electric vehicle.");
    }
    @Override
    public void display(){
        super.display();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
    }
}
class PetrolVehicle extends Vehicle implements Refuelable {
    private int fuelTankCapacity;
    public PetrolVehicle(int maxSpeed, String model, int fuelTankCapacity){
        super(maxSpeed, model);
        this.fuelTankCapacity = fuelTankCapacity;
    }
    public void refuel(){
        System.out.println("Refueling the petrol vehicle.");
    }
    @Override
    public void display(){
        super.display();
        System.out.println("Fuel Tank Capacity: " + fuelTankCapacity + " litres");
    }
}
public class VehicleHybridInheritance {
    public static void main(String[] args){
        Vehicle[] vehicles = {
            new ElectricVehicle(150, "Tesla Model 3", 75),
            new PetrolVehicle(180, "Ford Mustang", 50)
        };
        for (Vehicle v : vehicles) {
            v.display();
            if (v instanceof ElectricVehicle) {
                ((ElectricVehicle)v).charge();
            }
            if (v instanceof PetrolVehicle) {
                ((PetrolVehicle)v).refuel();
            }
            System.out.println();
        }
    }
}