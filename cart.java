class Cart {
    Product[] products = new Product[10]; 
    int[] quantities = new int[10];
    int itemCount = 0;         

    void addProduct(Product product, int quantity) {
        products[itemCount] = product;
        quantities[itemCount] = quantity;
        itemCount++;
    }

    double calculateTotal(Discount discount) {
        double total = 0;
        for (int i = 0; i < itemCount; i++) {
            double price = products[i].DiscountProduct();
            if (discount != null && discount.active && discount.product == products[i]) {
                price = price * (1 - discount.percent / 100);
            }
            total += price * quantities[i];
        }
        return total;
    }

    void printCart() {
        System.out.println("Cart items:");
        for (int i = 0; i < itemCount; i++) {
            System.out.println(products[i].name + " x" + quantities[i] + " | $" + products[i].DiscountProduct());
        }
    }
}