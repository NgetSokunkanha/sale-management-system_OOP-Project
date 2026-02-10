class Customer {
    private String customerName;
    private String email;
    private String phone;
    private String address;
    private Cart cart; 

    public Customer(String name, String description) {
        this.customerName = name;
        this.cart = new Cart(description);  
    }  

    public void enterEmail(String email) {
        this.email = email;
    }

    public void enterPhone(String phone) {
        if (phone.length() != 9) {
            System.out.println("Phone Number excceds/not enough length.");
        } else {
            this.phone = phone;
        }  
    }

    public void enterAddress(String address) {
        this.address = address;
    }

    public String getcustomerName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}












