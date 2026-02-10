class Receipt {
    private Customer customer;
    private Cart cart;
    private double totalAmount;
    private double vatAmount;
    private double finalAmount;
    private String dateTime;
    private String orderID; 

    public static double VAT_RATE = 0.10;

    public Receipt(Customer customer, Cart cart) {
        this.customer = customer;
        this.cart = cart;
        this.totalAmount = cart.calculateTotal();
        this.vatAmount = totalAmount * VAT_RATE;
        this.finalAmount = totalAmount + vatAmount;
        this.dateTime = "2026-02-02 14:00";
    }

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
        System.out.println("Subtotal      : $" + totalAmount);
        System.out.println("VAT (10%)     : $" + vatAmount);
        System.out.println("Total Amount  : $" + finalAmount);
        System.out.println("-------------------");
    }
}