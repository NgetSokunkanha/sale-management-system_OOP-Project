package controller;

public class Main {

    public static void main(String[] args) {

        MiniMartShop shop = new MiniMartShop();

        //  Polymorphism Demo 
        shop.demoPermissions(); 

        // Admin login & create menu 
        shop.login("Kanha", "123456");
        System.out.println(shop.getLastMessage());

        shop.createMenuItem("M001", "Apple", "Fruit", 2.5, true);
        shop.createMenuItem("M002", "Banana", "Fruit", 1.5, true);
        shop.createMenuItem("M003", "Coke", "Drink", 1.0, true);

        System.out.println(shop.getLastMessage());
        shop.printMenuItems();

        shop.logout();
        System.out.println(shop.getLastMessage());
        System.out.println();

        //  Manager login
        shop.login("Mana", "123456");
        System.out.println(shop.getLastMessage());

        shop.createMenuItem("M004", "Orange", "Fruit", 3.0, true); // Denied
        shop.viewReport();  // Allowed
        shop.updateDeliveryStatus(); // Denied

        shop.logout();
        System.out.println();

        //  Delivery login 
        shop.login("Nita", "123456");
        System.out.println(shop.getLastMessage());

        shop.createMenuItem("M005", "Pepsi", "Drink", 1.2, true); // Denied
        shop.viewOrder(); // Allowed
        shop.updateDeliveryStatus(); // Allowed

        shop.logout();
    }
}