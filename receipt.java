class Receipt {
    Customer customer;
    Cart cart;
    double totalAmount;
    String dateTime; 

    Receipt(Customer customer, Cart cart) {
        this.customer = customer;
        this.cart = cart;
        this.totalAmount = cart.calculateTotal(null); 
        this.dateTime = "2026-02-02 12:00"; 
    }

    void displayReceipt() {
        System.out.println("----- RECEIPT -----");
        System.out.println("Customer Name : " + customer.customerName);
        System.out.println("Phone         : " + customer.phone);
        System.out.println("Email         : " + customer.email);
        System.out.println("Address       : " + customer.address);
        System.out.println("Date & Time   : " + dateTime);

        cart.printCart(); 

        System.out.println("-------------------");
        System.out.println("Total Amount  : $" + totalAmount);
        System.out.println("-------------------");
    }
}
