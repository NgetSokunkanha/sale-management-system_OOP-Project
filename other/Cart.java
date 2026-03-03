package other;
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
    public int getItemCount() {
        return itemCount;
    }

    public Product[] getProducts() {
        return products;
    }

    public int[] getQuantities() {
        return quantities;
    }

    public void setDescription(String description) {
        if (description != null && !description.isEmpty()) {
            this.description = description;
        }
    }

    public void addProduct(Product product, int quantity) {
        if (product == null || quantity <= 0) return;

        for (int i = 0; i < itemCount; i++) {
            if (products[i] != null && products[i].equals(product)) {
                quantities[i] += quantity;
                return;
            }
        }

        if (itemCount < products.length) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cart{");
        sb.append("products=").append(products);
        sb.append(", quantities=").append(quantities);
        sb.append(", itemCount=").append(itemCount);
        sb.append(", description=").append(description);
        sb.append('}');
        return sb.toString();
    }

}
