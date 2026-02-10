class Main {
    public static void main(String[] args) {
            
        Product p1 = new Product("B001", "apple", 2, 5, "2027-12-31");
        Product p2 = new Product("B002", "Banana", 1.5, 50, "2028-12-31");
        Product p3 = new Product("B003", "Coke", 1, 30, "2028-12-31");

 
        double originalPrice = p1.getPrice();
        double copyPrice = originalPrice; 
        copyPrice = 999; 
        System.out.println("Primitive copy:");
        System.out.println("Original price: " + originalPrice);
        System.out.println("Copied price changed: " + copyPrice);
        System.out.println();

    
        Product refProduct = p1; // reference copy
        refProduct.setPrice(1000); 
        System.out.println("Reference copy:");
        System.out.println("Original product price after reference change: " + p1.getPrice()); 
        System.out.println();

        Cart cart1 = new Cart("The first cart");
        cart1.addProduct(p1, 1);
        cart1.addProduct(p2, 2);
        cart1.addProduct(p3, 1);

        System.out.println("Array stores references:");
        cart1.printCart();
        System.out.println();

        Customer customer1 = new Customer("kanha", "Shopping for university");
        customer1.setEmail("kanha@example.com");
        customer1.setPhone("012345678");
        customer1.setAddress("123 Street, Phnom Penh");

        customer1.getCart().addProduct(p1, 1);
        customer1.getCart().setDescription("University purchase");

        Receipt receipt1 = new Receipt(customer1, customer1.getCart());
        System.out.println("Display receipt:");
        receipt1.displayReceipt();
        System.out.println();
        
    }

}
