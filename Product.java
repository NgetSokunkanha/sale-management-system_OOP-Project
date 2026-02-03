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
        System.out.println("Name: " + name + " | Price: $" + price + " | Stock: " + stock + " | Expire: " + expireDate + " | Discount: " + discountPercent + "%");
    }

     double DiscountProduct() {
        return price * (1 - discountPercent / 100);
    }

    void reduceStock(int amount) {
        stock -= amount;
        if (stock < 0) {
            stock = 0;
        }
    }

    boolean isExpired(String today) {
        return expireDate.equals(today);
    }
}


