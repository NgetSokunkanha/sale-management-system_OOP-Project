
public class Customer {
    String customerName;
    String email;
    String phone;
    String address;
    Cart cart;

    public Customer(String customername, String phone, String email, String address) {
        this.customerName = customername;
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


