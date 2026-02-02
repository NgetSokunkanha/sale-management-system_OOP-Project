import java.util.Random; // To generate order ID

public class customer {
    String customername;
    String email;
    String phone;
    String address;

    public customer(String customername, String phone, String email, String address) {
        this.customername = customername;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }
    
    public String getCustomerUsername() {
        return customername;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public int generateOrderID() {
        Random rand = new Random();
        int orderID = rand.nextInt(1000000); // From 0 to 999999
        return orderID;
    }
}
