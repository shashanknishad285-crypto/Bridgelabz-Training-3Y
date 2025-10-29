
interface Insurable {
    double calculateInsurance();
    void getInsuranceDetails();
}

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }
    public String getVehicleNumber() { return vehicleNumber; }
    public String getType() { return type; }
    public double getRentalRate() { return rentalRate; }

    public abstract double calculateRentalCost(int days);

    public void displayVehicle() {
        System.out.println("Vehicle Number: "+vehicleNumber + ", Type: "+type+" , Rental Rate: "+rentalRate);
    }
}

class Car extends Vehicle implements Insurable {
    private double insurancePremium;

    public Car(String vehicleNumber, String type, double rentalRate, double insurancePremium){
        super(vehicleNumber, type, rentalRate);
        this.insurancePremium = insurancePremium;
    }
    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }
    @Override
    public double calculateInsurance() {
        return insurancePremium;
    }
    @Override
    public void getInsuranceDetails() {
        System.out.println("Car Insurance Premium: "+insurancePremium);
    }
}
class Bike extends Vehicle implements Insurable {
    private double insurancePremium;

    public Bike(String vehicleNumber, String type, double rentalRate, double insurancePremium){
        super(vehicleNumber, type, rentalRate);
        this.insurancePremium = insurancePremium;
    }
    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }
    @Override
    public double calculateInsurance() {
        return insurancePremium;
    }
    @Override
    public void getInsuranceDetails() {
        System.out.println("Bike Insurance Premium: "+insurancePremium);
    }
}
class Truck extends Vehicle implements Insurable {
    private double insurancePremium;

    public Truck(String vehicleNumber, String type, double rentalRate, double insurancePremium){
        super(vehicleNumber, type, rentalRate);
        this.insurancePremium = insurancePremium;
    }
    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 1.5; // Trucks have higher rental cost
    }
    @Override
    public double calculateInsurance() {
        return insurancePremium;
    }
    @Override
    public void getInsuranceDetails() {
        System.out.println("Truck Insurance Premium: "+insurancePremium);
    }
}
public class VehicleRentalSystem {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car("CAR123","Sedan",1000,500),
            new Bike("BIKE456","Sport",500,200),
            new Truck("TRUCK789","Heavy",2000,1500)
        };

        for(Vehicle v : vehicles) {
            v.displayVehicle();
            System.out.println("Rental cost for 5 days: " + v.calculateRentalCost(5));
            if (v instanceof Insurable) {
                Insurable ins = (Insurable) v;
                ins.getInsuranceDetails();
            }
            System.out.println();
        }
    }
}
