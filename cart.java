public class Cart {
    private Product[] products = new Product[10]; // array of products
    private int[] quantities = new int[10];       // quantities for each product
    private int itemCount = 0;                    // number of all items that have buy
    private String description;              

    public Cart(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description != null && !description.isEmpty()) {
            this.description = description;
        }
    }

    public void addProduct(Product product, int quantity) {
        if (product != null && quantity > 0 && itemCount < products.length) {
            products[itemCount] = product;
            quantities[itemCount] = quantity;
            itemCount++;
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (int i = 0; i < itemCount; i++) {
            if (products[i] != null) { 
                total += products[i].getPrice() * quantities[i];
            }
        }
        return total;
    }

    public void printCart() {
        System.out.println("Cart items:");
        for (int i = 0; i < itemCount; i++) {
            if (products[i] != null) { 
                System.out.println(
                    products[i].getName() + " x" + quantities[i] + " | $" + products[i].getPrice()
                );
            }
        }
    }
}
