class Customer {
    private String customerName;
    private String email;
    private String phone;
    private String address;
    private String password;
    private Cart cart; 

    public Customer(String customerName, String cartDescription) {
        this.customerName = customerName;
        this.cart = new Cart(cartDescription); // Cart created with description
    }

    public String getCustomerName() {
        return customerName;
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
   
    public Cart getCart() {
        return cart;
    }

    public boolean login(String inputPassword) {
        return password != null && password.equals(inputPassword);
    }

    public void setEmail(String email) {
        if (email != null && !email.isEmpty() && email.contains("@")) {
            this.email = email;
        } else {
            System.out.println("Invalid email.");
        }
    }

    public void setPhone(String phone) {
        if (phone != null && ( phone.length() == 9 || phone.length() == 10 ) && phone.matches("\\d+")) {
            this.phone = phone;
        } else {
            System.out.println("Phone number must be 9 or 10 digits.");
        }
    }

    public void setAddress(String address) {
        if (address != null && !address.isEmpty()) {
            this.address = address;
        }
    }

    public void setPassword(String password) {
        if (password != null && password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$")) {
            this.password = password;
            System.out.println("Your Password set successfully.");
        } else {
            System.out.println("Your Password must be at least 8 chars, include uppercase, lowercase and number.");
        }
    } 
}