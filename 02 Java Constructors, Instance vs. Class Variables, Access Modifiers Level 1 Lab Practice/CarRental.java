
public class CarRental {
    private String customerName;
    private String carModel;
    private int rentalDays;
    private double totalCost;

    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        calculateTotalCost();
    }

    private void calculateTotalCost() {
        double pricePerDay = carModel.equalsIgnoreCase("SUV")
            ? 1200.0 : 900.0;
        this.totalCost = pricePerDay * rentalDays;
    }

    public void displayRental() {
        System.out.println("Customer: " + customerName +
            ", Car: " + carModel +
            ", Days: " + rentalDays +
            ", Total Cost: " + totalCost);
    }

    public static void main(String[] args) {
        CarRental rental = new CarRental("Amit", "SUV", 5);
        rental.displayRental();
    }
}
