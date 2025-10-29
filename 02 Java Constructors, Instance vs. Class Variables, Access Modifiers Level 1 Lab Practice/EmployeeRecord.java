
class EmployeeRecord {
    public int employeeID;
    protected String department;
    private double salary;

    public EmployeeRecord(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    public double getSalary() { return salary; }
}

class Manager extends EmployeeRecord {
    public Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }

    public void showAccess() {
        System.out.println("Employee ID (public): " + employeeID);
        System.out.println("Department (protected): " + department);
    }

    public static void main(String[] args) {
        Manager mgr = new Manager(3001, "IT", 90000.0);
        mgr.showAccess();
        mgr.setSalary(95000.0);
        System.out.println("Salary (private, via getter): " + mgr.getSalary());
    }
}
