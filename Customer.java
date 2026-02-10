class Customer {
    private String customerName;
    private String email;
    private String phone;
    private String address;
    private String description;
    private Cart cart; 

    public Customer(String name, String description) {
        this.customerName = name;
        this.description = description;
        this.cart = new Cart();  
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

    public void getcustomerName() {
        return name;
    }

    public void getEmail() {
        return email;
    }

    public void getPhone() {
        if (phone.length() === 9) {
            return phone;
        } else {
            System.out.println("Invaild Phone Number length");
        }
    }

    public void getAddress() {
        return address;
    }
}










