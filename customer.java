class Customer {
    String customerName;
    String email;
    String phone;
    String address;
    Cart cart; 

    Customer(String customerName, String phone, String email, String address) {
        this.customerName = customerName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.cart = new Cart();    
    }

    void printCustomer() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Address: " + address);
    }

}