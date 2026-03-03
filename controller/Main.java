package controller;

public class Main {
    public static void main(String[] args) {

        MiniMartShop shop = new MiniMartShop();

        // Admin login & create menu
        shop.login("Kanha", "123");
        System.out.println(shop.getLastMessage());

        shop.createMenuItem("M001", "Apple", "Fruit", 2.5, true);
        shop.createMenuItem("M002", "Banana", "Fruit", 1.5, true);
        shop.createMenuItem("M003", "Coke", "Drink", 1.0, true);

        System.out.println(shop.getLastMessage());

        shop.printMenuItems();
        shop.logout();
        System.out.println(shop.getLastMessage());
        System.out.println();

        // Manager login (should not create menu)
        shop.login("Mana", "456");
        System.out.println(shop.getLastMessage());

        shop.createMenuItem("M004", "Orange", "Fruit", 3.0, true);
        System.out.println(shop.getLastMessage()); // Permission deny

        shop.viewReport();  // Allow
        shop.updateDeliveryStatus(); // Not allow
        shop.logout();
        System.out.println();


        // Delivery login (minimal permissions)
  
        shop.login("Nita", "789");
        System.out.println(shop.getLastMessage());

        shop.createMenuItem("M005", "Pepsi", "Drink", 1.2, true); // Denied
        shop.viewOrder(); // Allow
        shop.updateDeliveryStatus(); // Allow
        shop.logout();
    }
}