
interface Discountable {
    void applyDiscount(double discountPercent);
    void getDiscountDetails();
}

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public void setPrice(double price) { this.price = price; }

    public abstract double calculateTotalPrice();

    public void getItemDetails() {
        System.out.println("Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity);
    }
}

class VegItem extends FoodItem implements Discountable {
    private double discount = 0;

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        double total = getPrice() * getQuantity();
        total = total - (total * discount / 100);
        return total;
    }

    @Override
    public void applyDiscount(double discountPercent) {
        discount = discountPercent;
    }

    @Override
    public void getDiscountDetails() {
        System.out.println("Veg Item Discount: " + discount + "%");
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private double discount = 0;
    private double additionalCharge = 50; // Fixed extra charge for non-veg items

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        double total = (getPrice() + additionalCharge) * getQuantity();
        total = total - (total * discount / 100);
        return total;
    }

    @Override
    public void applyDiscount(double discountPercent) {
        discount = discountPercent;
    }

    @Override
    public void getDiscountDetails() {
        System.out.println("Non-Veg Item Discount: " + discount + "%");
        System.out.println("Additional Charge per item: " + additionalCharge);
    }
}

public class FoodDelivery {
    public static void main(String[] args) {
        FoodItem[] items = {
            new VegItem("Paneer Butter Masala", 200, 2),
            new NonVegItem("Chicken Curry", 250, 3)
        };

        for (FoodItem item : items) {
            if (item instanceof Discountable) {
                ((Discountable) item).applyDiscount(10);
                ((Discountable) item).getDiscountDetails();
            }
            item.getItemDetails();
            System.out.println("Total Price: " + item.calculateTotalPrice());
            System.out.println();
        }
    }
}
