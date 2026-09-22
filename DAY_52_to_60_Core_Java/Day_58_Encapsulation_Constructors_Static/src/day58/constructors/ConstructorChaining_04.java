package day58.constructors;

public class ConstructorChaining_04 {

    private String orderId;
    private String restaurant;
    private String deliveryType;
    private double deliveryFee;

    public ConstructorChaining_04() {
        this("ORDDEFAULT");
    }

    public ConstructorChaining_04(String orderId) {
        this(orderId, "Unknown Restaurant");
    }

    public ConstructorChaining_04(String orderId, String restaurant) {
        this(orderId, restaurant, "STANDARD", 40);
    }

    public ConstructorChaining_04(
            String orderId,
            String restaurant,
            String deliveryType,
            double deliveryFee) {

        this.orderId = orderId;
        this.restaurant = restaurant;
        this.deliveryType = deliveryType;
        this.deliveryFee = deliveryFee;
    }

    public double calculateFinalDeliveryFee() {
        if (deliveryType.equalsIgnoreCase("EXPRESS")) {
            return deliveryFee + 30;
        }

        return deliveryFee;
    }

    public void displayOrder() {
        System.out.println("\n--- Delivery Order ---");
        System.out.println("Order ID       : " + orderId);
        System.out.println("Restaurant     : " + restaurant);
        System.out.println("Delivery Type  : " + deliveryType);
        System.out.println("Delivery Fee   : " + calculateFinalDeliveryFee());
    }
}