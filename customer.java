<<<<<<< HEAD
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
=======
public class customer {
    String customername;
    String email;
    String phone;
    String address;
    int balance;

    public customer(String customername, String phone, String email, String address, int balance) {
        this.customername = customername;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.balance = balance;
    }

    void printCustomer() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Address: " + address);
    }

<<<<<<< HEAD
}
=======

    public boolean enoughBalance() {
         if (this.balance <= total) {
             return true;
        } else {
            return false;
        }
    }
    public int remainingBalance(int total) {
            this.balance -= total;
            return this.balance;
        }
}





>>>>>>> cf210298247515b0f42c993f2321f3a1651287c3

