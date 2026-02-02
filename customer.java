public class Customer {
    //define class customer

    String customername;
    String name;

    public Customer(String customername, String name) {
        this.customername = customername;
        this.name = name;
    }
    
    public String getCustomerUsername() {
        return customername;
    }

    public String getRealName() {
        return name;
    }
}
