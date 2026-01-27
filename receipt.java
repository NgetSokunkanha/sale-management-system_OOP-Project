import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class receipt {

    private customer customer;
    private cart cart;
    private LocalDateTime dateTime;

    public receipt(customer customer, cart cart) {
        this.customer = customer;
        this.cart = cart;
        this.dateTime = LocalDateTime.now();
    }

    public void displayReceipt() {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        System.out.println("----- RECEIPT -----");
        System.out.println("Customer Username: " + customer.getCustomerUsername());
        System.out.println("Customer Name    : " + customer.getRealName());
        System.out.println("Date & Time      : " + dateTime.format(formatter));
        System.out.println("-------------------");

        cart.displayCart();          
        System.out.println("-------------------");
        System.out.println("Total Amount: " + cart.calculateTotal());
        System.out.println("-------------------");
    }
}

