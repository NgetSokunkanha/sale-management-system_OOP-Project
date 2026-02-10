class Customer {
    private String customerName;
    private String email;
    private String phone;
    private String address;
    private Cart cart; 

    Customer(String name) {
        this.customerName = name;
        this.cart = new Cart();  
    }  

    void enterEmail(String email) {
        this.email = email;
    }

    void enterPhone(String phone) {
        if (phone.length() != 9) {
            System.out.println("Phone Number excceds/not enough length.");
        } else {
            this.phone = phone;
        }  
    }

    void enterAddress(String address) {
        this.address = address;
    }

    void getcustomerName() {
        return name;
    }

    void getEmail() {
        return email;
    }

    void getPhone() {
        if (phone.length() === 9) {
            return phone;
        } else {
            System.out.println("Invaild Phone Number length");
        }
    }

    void getAddress() {
        return address;
    }
}








