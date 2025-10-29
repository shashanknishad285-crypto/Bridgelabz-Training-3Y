
class Device {
    protected String deviceId;
    protected String status;
    public Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }
    public void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
    }
}
class Thermostat extends Device {
    private double temperatureSetting;
    public Thermostat(String deviceId, String status, double temperature) {
        super(deviceId, status);
        this.temperatureSetting = temperature;
    }
    @Override
    public void displayStatus() {
        super.displayStatus();
        System.out.println("Temperature Setting: " + temperatureSetting);
    }
}
public class SmartHomeDevice {
    public static void main(String[] args) {
        Thermostat t = new Thermostat("T1001", "Active", 22.5);
        t.displayStatus();
    }
}
