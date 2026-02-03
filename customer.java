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

    public boolean enoughBalance {
         if (this.balance <= total) {
             return true;
        } else {
            return false; // Means customer doesn't have enough balance
        }
    }
    public int remainingBalance(int total) {
        if (this.balance <= total) {
            this.balance -= total;
            return this.balance;
        } else {
            return null; // Means customer doesn't have enough balance
        }
}



