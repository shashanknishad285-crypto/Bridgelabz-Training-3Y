
interface Taxable {
    double calculateTax();
    void getTaxDetails();
}

abstract class Product {
    private String productId;
    private String name;
    private double price;

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }
    public String getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public abstract double calculateDiscount();

    public void displayPrice(double finalPrice) {
        System.out.println(name + ": Final Price after tax and discount = " + finalPrice);
    }
}

class Electronics extends Product implements Taxable {
    public Electronics(String id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.1; // 10% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.15; // 15% tax
    }

    @Override
    public void getTaxDetails() {
        System.out.println("Electronics Tax rate: 15%");
    }
}

class Clothing extends Product implements Taxable {
    public Clothing(String id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.2; // 20% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05; // 5% tax
    }

    @Override
    public void getTaxDetails() {
        System.out.println("Clothing Tax rate: 5%");
    }
}

class Groceries extends Product {
    public Groceries(String id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return 0; // No discount
    }
}

public class ECommercePlatform {
    public static void main(String[] args) {
        Product[] products = {
            new Electronics("P001", "Laptop", 1000),
            new Clothing("P002", "T-Shirt", 50),
            new Groceries("P003", "Apples", 30)
        };

        for (Product p : products) {
            double discount = p.calculateDiscount();
            double tax = 0;
            if (p instanceof Taxable) {
                tax = ((Taxable) p).calculateTax();
                ((Taxable) p).getTaxDetails();
            }
            double finalPrice = p.getPrice() + tax - discount;
            p.displayPrice(finalPrice);
            System.out.println();
        }
    }
}
