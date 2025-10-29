
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    protected String diagnosis;

    public Patient(String patientId, String name, int age, String diagnosis) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
    }

    public String getPatientId() { return patientId; }
    public String getName() { return name; }
    public int getAge() { return age; }

    public abstract double calculateBill();

    public void getPatientDetails() {
        System.out.println("Patient ID: "+patientId+", Name: "+name+", Age: "+age+", Diagnosis: "+diagnosis);
    }
}

class InPatient extends Patient implements MedicalRecord {
    private double dailyRate;
    private int daysAdmitted;
    private ArrayList<String> records = new ArrayList<>();

    public InPatient(String id, String name, int age, String diagnosis, double dailyRate, int daysAdmitted) {
        super(id, name, age, diagnosis);
        this.dailyRate = dailyRate;
        this.daysAdmitted = daysAdmitted;
    }

    @Override
    public double calculateBill() {
        return dailyRate * daysAdmitted + 500; // room + service charges
    }

    public void addRecord(String record) {
        records.add(record);
    }

    public void viewRecords() {
        System.out.println("Medical Records for InPatient "+getName()+":");
        for(String rec : records) {
            System.out.println("- " + rec);
        }
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private ArrayList<String> records = new ArrayList<>();

    public OutPatient(String id, String name, int age, String diagnosis, double fee) {
        super(id, name, age, diagnosis);
        this.consultationFee = fee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    public void addRecord(String record) {
        records.add(record);
    }

    public void viewRecords() {
        System.out.println("Medical Records for OutPatient "+getName()+":");
        for(String rec : records) {
            System.out.println("- " + rec);
        }
    }
}

import java.util.ArrayList;

public class HospitalManagement {
    public static void main(String[] args) {
        InPatient ip = new InPatient("P001", "John Doe", 45, "Pneumonia", 5000, 5);
        ip.addRecord("X-Ray: Clear");
        ip.addRecord("Blood Test: Normal");

        OutPatient op = new OutPatient("P002", "Jane Roe", 30, "Flu", 500);
        op.addRecord("Flu Test: Positive");

        ip.getPatientDetails();
        System.out.println("Bill: "+ip.calculateBill());
        ip.viewRecords();

        System.out.println();

        op.getPatientDetails();
        System.out.println("Bill: "+op.calculateBill());
        op.viewRecords();
    }
}
