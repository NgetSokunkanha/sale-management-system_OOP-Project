import java.time.LocalDateTime;

public class receipt {

    Customer customer;
    Cart cart;
    double totalAmount;
    LocalDateTime dateTime;
    

    public receipt(Customer customer, Cart cart) {
        this.customer = customer;
        this.cart = cart;
        this.totalAmount = cart.calculateTotal();
        this.dateTime = LocalDateTime.now();
    }

    public void displayReceipt() {

        System.out.println("----- RECEIPT -----");
        System.out.println("Customer Username: " + customer.getCustomerUsername());
        System.out.println("Customer Name    : " + customer.getRealName());
        System.out.println("Date & Time      : " + this.dateTime);
        System.out.println("-------------------");

        cart.displayCart();

        System.out.println("-------------------");
        System.out.println("Total Amount: " + this.totalAmount);
        System.out.println("-------------------");
    }
}