
interface GPS {
    String getCurrentLocation();
    void updateLocation(String location);
}

abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm){
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }
    public String getVehicleId() { return vehicleId; }
    public String getDriverName() { return driverName; }
    public double getRatePerKm() { return ratePerKm; }

    public void getVehicleDetails(){
        System.out.println("Vehicle ID: "+vehicleId+", Driver: "+driverName+", Rate Per Km: "+ratePerKm);
    }

    public abstract double calculateFare(double km);
}

class Car extends Vehicle implements GPS {
    private String currentLocation;

    public Car(String id, String driver, double rate) {
        super(id, driver, rate);
        currentLocation = "Garage";
    }

    public double calculateFare(double km) {
        return getRatePerKm() * km;
    }

    public String getCurrentLocation(){
        return currentLocation;
    }

    public void updateLocation(String location){
        currentLocation = location;
        System.out.println("Car location updated to " + currentLocation);
    }
}

class Bike extends Vehicle implements GPS {
    private String currentLocation;

    public Bike(String id, String driver, double rate) {
        super(id, driver, rate);
        currentLocation = "Garage";
    }

    public double calculateFare(double km) {
        return getRatePerKm() * km * 0.8; // cheaper fare
    }

    public String getCurrentLocation(){
        return currentLocation;
    }

    public void updateLocation(String location){
        currentLocation = location;
        System.out.println("Bike location updated to " + currentLocation);
    }
}

class Auto extends Vehicle implements GPS {
    private String currentLocation;

    public Auto(String id, String driver, double rate) {
        super(id, driver, rate);
        currentLocation = "Garage";
    }

    public double calculateFare(double km) {
        return getRatePerKm() * km * 0.9;
    }

    public String getCurrentLocation(){
        return currentLocation;
    }

    public void updateLocation(String location){
        currentLocation = location;
        System.out.println("Auto location updated to " + currentLocation);
    }
}

public class RideHailingSystem {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car("C100", "John", 15),
            new Bike("B200", "Doe", 10),
            new Auto("A300", "Smith", 13)
        };

        for(Vehicle v : vehicles) {
            v.getVehicleDetails();
            System.out.println("Fare for 10 km: " + v.calculateFare(10));
            if(v instanceof GPS) {
                GPS gpsVehicle = (GPS) v;
                System.out.println("Current Location: " + gpsVehicle.getCurrentLocation());
                gpsVehicle.updateLocation("Downtown");
            }
            System.out.println();
        }
    }
}
