package controller;

import java.util.ArrayList;
import other.MenuItem;
import user.Admin;
import user.Delivery;
import user.IStaff;
import user.Manager;

public class MiniMartShop {

    public static final String CREATE_PRODUCT = "CREATE_PRODUCT";
    public static final String UPDATE_PRODUCT = "UPDATE_PRODUCT";
    public static final String VIEW_REPORT = "VIEW_REPORT";
    public static final String VIEW_ORDER = "VIEW_ORDER";
    public static final String UPDATE_DELIVERY_STATUS = "UPDATE_DELIVERY_STATUS";

    private ArrayList<IStaff> users;
    private ArrayList<MenuItem> menuItems;
    private IStaff loggedInUser;
    private String lastMessage;

    public MiniMartShop() {
        users = new ArrayList<>();
        menuItems = new ArrayList<>();
        loggedInUser = null;
        lastMessage = "";
        seedDefaultUsers();
    }

    private void seedDefaultUsers() {
        users.add(new Admin("1", "Kanha", "123456", "Female", "Office"));
        users.add(new Manager("2", "Mana", "123456", "Female", 500));
        users.add(new Delivery("3", "Nita", "123456", "Female", "Motorbike"));
    }

    public void login(String username, String password) {
        if (username == null || password == null) {
            setLastMessage("Login failed: missing username/password.");
            return;
        }

        for (IStaff user : users) {
            if (user.getUsername().equals(username)) {
                if (!user.checkPassword(password)) {
                    setLastMessage("Login failed: wrong password.");
                    return;
                }

                loggedInUser = user;
                setLastMessage("Login success. Welcome " + user.getUsername());
                return;
            }
        }
        setLastMessage("Login failed: user not found.");
    }

    public void logout() {
        loggedInUser = null;
        setLastMessage("Logged out successfully.");
    }

    public void createMenuItem(String itemId, String name, String category,
                               double price, boolean available) {

        if (!requirePermission(CREATE_PRODUCT)) return;

        if (itemId == null || itemId.trim().isEmpty()) {
            setLastMessage("Cannot create menu item: itemId is empty.");
            return;
        }

        for (MenuItem item : menuItems) {
            if (item.getItemId().equalsIgnoreCase(itemId.trim())) {
                setLastMessage("Cannot create menu item: itemId already exists.");
                return;
            }
        }

        menuItems.add(new MenuItem(itemId, name, category, price, available, loggedInUser));
        setLastMessage("Menu item created successfully: " + itemId);
    }

    public void printMenuItems() {
        System.out.println("\n Menu Items (" + menuItems.size() + ") ");
        if (menuItems.isEmpty()) System.out.println("No menu items.");
        for (MenuItem item : menuItems) {
            System.out.println(item);
        }
    }

    public void createProduct() {
        if (!requirePermission(CREATE_PRODUCT)) return;
        System.out.println("Product created.");
    }

    public void updateProduct() {
        if (!requirePermission(UPDATE_PRODUCT)) return;
        System.out.println("Product updated.");
    }

    public void viewReport() {
        if (!requirePermission(VIEW_REPORT)) return;
        System.out.println("Viewing report.");
    }

    public void viewOrder() {
        if (!requirePermission(VIEW_ORDER)) return;
        System.out.println("Viewing orders.");
    }

    public void updateDeliveryStatus() {
        if (!requirePermission(UPDATE_DELIVERY_STATUS)) return;
        System.out.println("Delivery status updated.");
    }

    private boolean requirePermission(String action) {
        if (loggedInUser == null) {
            System.out.println("You need to login first.");
            return false;
        }

        if (!loggedInUser.can(action)) {
            System.out.println("Access denied for action: " + action);
            return false;
        }

        return true;
    }

    public void demoPermissions() {
        System.out.println("\n Polymorphism Permission Test ");

        String[] actions = { CREATE_PRODUCT, VIEW_REPORT, VIEW_ORDER };

        for (IStaff s : users) {    
            System.out.println("\nUser: " + s.getUsername());
            for (String action : actions) {
                System.out.println("Can perform " + action + " ? " + s.can(action));
            }
        }
    }
    public ArrayList<IStaff> getUsers() {
        return users;
    }

    private void setLastMessage(String msg) {
        lastMessage = msg;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public boolean isUserLoggedIn() {
        return loggedInUser != null;
    }

    public IStaff getLoggedInUser() {
        return loggedInUser;
    }
    
}