package other;
import user.Customer;

class Receipt {
    private Customer customer;
    private Cart cart;
    private double vatAmount;
    private double finalAmount;
    private String dateTime;
    private String orderID; 

    public static final double VAT_RATE = 0.10;

    public Receipt(String orderID, Customer customer, Cart cart) {
        this.orderID = orderID;
        this.customer = customer;
        this.cart = cart;
        this.vatAmount = cart.calculateTotal() * VAT_RATE;
        this.finalAmount = cart.calculateTotal() + vatAmount;
        this.dateTime = "2026-02-02 14:00";
    }
    public Customer getCustomer() { return customer; }
    public Cart getCart() { return cart; }
    public double getVatAmount() { return vatAmount; }
    public double getFinalAmount() { return finalAmount; }
    public String getDateTime() { return dateTime; }
    public String getOrderID() { return orderID; }

    void displayReceipt() {
        System.out.println("----- RECEIPT -----");
        System.out.println("Order ID      : " + orderID);
        System.out.println("Customer Name : " + customer.getCustomerName());
        System.out.println("Phone         : " + customer.getPhone());
        System.out.println("Email         : " + customer.getEmail());
        System.out.println("Address       : " + customer.getAddress());
        System.out.println("Date & Time   : " + dateTime);

        cart.printCart();

        if (cart.getDescription() != null && !cart.getDescription().isEmpty()) {
            System.out.println("Order Note    : " + cart.getDescription());
        }

        System.out.println("-------------------");
        System.out.println("Subtotal      : $" + cart.calculateTotal());
        System.out.println("VAT (10%)     : $" + vatAmount);
        System.out.println("Total Amount  : $" + finalAmount);
        System.out.println("-------------------");
    }
    @Override
    public String toString() {
        return "Receipt [customer=" + customer + ", cart=" + cart + ", vatAmount=" + vatAmount + ", finalAmount="
                + finalAmount + ", dateTime=" + dateTime + ", orderID=" + orderID + "]";
    }
    
}