public class Product {
    String name;
    double price;
    int stock;
    String expireDate;
    double discountPercent;


    Product(String name, double price, int stock, String expireDate, double discountPercent) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.expireDate = expireDate;
        this.discountPercent = discountPercent;
    }

    void print() {
        System.out.println("Name: " + this.name + " | Price: $" + this.price + " | Stock: " + this.stock + " | Expire: " + this.expireDate + " | Discount: " + this.discountPercent + "%");
    }

    double DiscountProduct() {
        return price * (1 - this.discountPercent / 100);
    }

    void reduceStock(int amount) {
        this.stock -= amount;
        if (this.stock < 0) {
            this.stock = 0;
        }
    }

    boolean isExpired(String today) {
        return expireDate.equals(today);
    }
}


