
class Order {
    protected String orderId;
    protected String orderDate;
    public Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }
    public String getOrderStatus(){
        return "Order Placed";
    }
}
class ShippedOrder extends Order {
    protected String trackingNumber;
    public ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }
    @Override
    public String getOrderStatus(){
        return "Order Shipped. Tracking Number: " + trackingNumber;
    }
}
class DeliveredOrder extends ShippedOrder {
    private String deliveryDate;
    public DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }
    @Override
    public String getOrderStatus(){
        return "Order Delivered on " + deliveryDate;
    }
}
public class OrderManagement {
    public static void main(String[] args){
        Order o = new Order("OID123","2023-09-10");
        ShippedOrder so = new ShippedOrder("OID124","2023-09-11","TRK12345");
        DeliveredOrder doo = new DeliveredOrder("OID125","2023-09-12","TRK12346","2023-09-17");
        System.out.println(o.getOrderStatus());
        System.out.println(so.getOrderStatus());
        System.out.println(doo.getOrderStatus());
    }
}
