class Main {
    public static void main(String[] args) {
            
        Product p1 = new Product("Coke", 1.5, 50, "2026-03-15", 10);

        int stockCopy = p1.stock; 
        stockCopy = 100;           
        System.out.println("F1 - Primitive Copy (Stock): p1.stock=" + p1.stock + ", stockCopy=" + stockCopy);
        
        Product p2 = new Product("Pepsi", 1.4, 30, "2026-04-01", 5);

        p1.print();
        p2.print();

        Product p3 = p1; 
        p3.price = 2.0;
        System.out.println("F2 - Reference Copy: p1 price=" + p1.price + ", p3 price=" + p3.price); // both 2.0

        Customer c1 = new Customer("Alice", "012345678", "alice@gmail.com", "Phnom Penh");
        c1.printCustomer();

        c1.cart.addProduct(p1, 2);
        c1.cart.addProduct(p2, 3);

        System.out.println("F3 - Array References:");
        System.out.println("Before price change: " + c1.cart.products[0].price); 
        p1.price = 3.0;
        System.out.println("After price change: " + c1.cart.products[0].price);  

        Discount d1 = new Discount("SAVE10", 10, true, p2);
        d1.showDiscount();

        double total = c1.cart.calculateTotal(d1);
        System.out.println("Total with discount: $" + total);

        Receipt r1 = new Receipt(c1, c1.cart);
        r1.displayReceipt();

        p1.price = 1000;
        System.out.println("After changing product price, receipt total: $" + r1.totalAmount); 
    }
}
