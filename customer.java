public class customer {
    String customername;
    String Name;

    public customer(String customername, String name) {
        this.customername = customername;
        this.Name = name;
    }
    
    public String getCustomerUsername() {
        return customername;
    }

    public String getRealName() {
        return name;
    }
}