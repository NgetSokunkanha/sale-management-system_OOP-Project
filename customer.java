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
}

