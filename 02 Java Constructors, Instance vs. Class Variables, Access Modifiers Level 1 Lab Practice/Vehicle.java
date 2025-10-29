
public class Vehicle {
    private String ownerName;
    private String vehicleType;
    private static double registrationFee = 1250.0;

    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public void displayVehicleDetails() {
        System.out.println("Owner: " + ownerName +
            ", Type: " + vehicleType +
            ", Registration Fee: " + registrationFee);
    }

    public static void updateRegistrationFee(double fee) {
        registrationFee = fee;
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Komal", "Bike");
        v1.displayVehicleDetails();
        Vehicle.updateRegistrationFee(1400.0);
        v1.displayVehicleDetails();
    }
}
