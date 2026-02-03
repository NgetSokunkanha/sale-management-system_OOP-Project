public class Discount {
    String code;     
    double percent;   
    boolean active;
    Product product;
    
    Discount(String code, double percent, boolean active, Product product) {
        this.code = code;
        this.percent = percent;
        this.active = active;
        this.product = product;
    }

    void showDiscount() {
        System.out.println("Discount Code: " + code);
        System.out.println("Percent Off: " + percent + "%");
        System.out.println("Active: " + active);
        if (product != null) {
            System.out.println("Discount to Product: " + product.name + " (Price: $" + product.price + ")");
        } else {
            System.out.println("Discount to Product: None");
        }
    }


}
