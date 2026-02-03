class Receipt {
    Customer customer;
    Cart cart;
    double totalAmount;
    double vatAmount;
    double finalAmount;
    String dateTime;
    String cashier;

    
    static final double VAT_RATE = 0.10;

    Receipt(Customer customer, Cart cart, String cashier) {
        this.customer = customer;
        this.cart = cart;
        this.cashier = cashier;
        this.totalAmount = cart.calculateTotal(null);
        this.vatAmount = totalAmount * VAT_RATE;
        this.finalAmount = totalAmount + vatAmount;
        this.dateTime = "2026-02-02 12:00";
    }

    void displayReceipt() {
        System.out.println("----- RECEIPT -----");
        System.out.println("Customer Name : " + customer.customerName);
        System.out.println("Phone         : " + customer.phone);
        System.out.println("Email         : " + customer.email);
        System.out.println("Address       : " + customer.address);
        System.out.println("Cashier       : " + cashier);
        System.out.println("Date & Time   : " + dateTime);

        cart.printCart();

        System.out.println("-------------------");
        System.out.println("Subtotal      : $" + totalAmount);
        System.out.println("VAT (10%)     : $" + vatAmount);
        System.out.println("Total Amount  : $" + finalAmount);
        System.out.println("-------------------");
    }
}