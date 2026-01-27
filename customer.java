public class customer {
    String customername;
    String name;

    // Constructor
    public customer(String customername, String name) {
        this.customername = customername;
        this.name = name;
    }

    // Some Functions that can be used
    public String getCustomerUsername() {
        return customername;
    }

    public String getRealName() {
        return name;
    }

}
