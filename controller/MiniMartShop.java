package controller;
import exception.AuthenticationException;
import exception.InvalidDataException; 

import java.util.ArrayList;
import java.util.Scanner;

import other.MenuItem;
import user.Admin;
import user.Delivery;
import user.Manager;
import user.Staff;
import user.StaffFilter;

public class MiniMartShop {
    public static final String CREATE_MENUITEM = "CREATE_MENUITEM";
    public static final String UPDATE_PRODUCT = "UPDATE_PRODUCT";
    public static final String VIEW_REPORT = "VIEW_REPORT";
    public static final String VIEW_ORDER = "VIEW_ORDER";
    public static final String UPDATE_DELIVERY_STATUS = "UPDATE_DELIVERY_STATUS";

    private ArrayList<Staff> users;
    private ArrayList<MenuItem> menuItems;

    private Staff loggedInUser;
    private String lastMessage;

    public MiniMartShop() {
        users = new ArrayList<>();
        menuItems = new ArrayList<>();
        loggedInUser = null;
        lastMessage = "";

        seedDefaultUsers();
    }

    private void seedDefaultUsers() {
        try {

            users.add(new Admin("111111", "Kanha", "111111", "Female", "Office"));
            users.add(new Manager("222222", "Mana", "222222", "Female", 500));
            users.add(new Manager("444444", "Dara", "333333", "Male", 600));
            users.add(new Delivery("333333", "Nita", "333333", "Female", "Motorbike"));
            users.add(new Delivery("555555", "Rith", "444444", "Male", "Car"));

            users.get(3).deactivate();

        } catch (InvalidDataException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void showStaff(StaffFilter filter) {
        for (Staff s : users) {
            if (filter.test(s)) {
                System.out.println(s);
            }
        }
    }

    public void login(String username, String password) throws AuthenticationException {
        for (Staff user : users) {

            if (user.getUsername().equals(username)) {

                if (!user.checkPassword(password)) {
                    throw new AuthenticationException("Wrong password.");
                }

                loggedInUser = user;
                lastMessage = "Login success. Welcome " + user.getUsername();
                return;
            }
        }
        throw new AuthenticationException("User not found.");
    }
    public void signUpStaff(String id, String username, String password, String gender, int role)
            throws InvalidDataException {

        for (Staff user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                throw new InvalidDataException("Username already exists.");
            }
            if (user.getId().equalsIgnoreCase(id)) {
                throw new InvalidDataException("Staff ID already exists.");
            }
        }

        Staff newStaff;
        switch (role) {
            case 1:
                newStaff = new Admin(id, username, password, gender, "General");
                break;

            case 2:
                newStaff = new Manager(id, username, password, gender, 0);
                break;

            case 3:
                newStaff = new Delivery(id, username, password, gender, "Motorbike");
                break;

            default:
                throw new InvalidDataException("Invalid role selected.");
        }
        users.add(newStaff);
        lastMessage = "Signup successful as " + newStaff.getClass().getSimpleName();
    }

    public void logout() {
        loggedInUser = null;
        setLastMessage("Logged out successfully.");
    }

    public void createMenuItem(String itemId, String name, String category, double price, boolean available)
            throws InvalidDataException {
        if (!requirePermission(CREATE_MENUITEM)) return;

        // Check ID
        if (itemId == null || itemId.trim().isEmpty())
            throw new InvalidDataException("Item ID cannot be empty.");
        if (itemId.length() != 6 || !itemId.chars().allMatch(Character::isDigit))
            throw new InvalidDataException("Item ID must be exactly 6 digits.");
        for (MenuItem item : menuItems) {
            if (item.getItemId().equals(itemId))
                throw new InvalidDataException("Item ID already exists.");
        }

        // Check Name
        if (name == null || name.trim().isEmpty())
            throw new InvalidDataException("Name cannot be empty.");
        for (char c : name.toCharArray()) {
            if (!Character.isLetter(c) && c != ' ')
                throw new InvalidDataException("Name must contain letters only.");
        }
        for (MenuItem item : menuItems) {
            if (item.getName().equalsIgnoreCase(name))
                throw new InvalidDataException("Name already exists.");
        }

        // Check Category
        if (category == null || category.trim().isEmpty())
            throw new InvalidDataException("Category cannot be empty.");
        for (char c : category.toCharArray()) {
            if (!Character.isLetter(c) && c != ' ')
                throw new InvalidDataException("Category must contain letters only.");
        }

        // Check Price
        if (price <= 0)
            throw new InvalidDataException("Price must be greater than 0.");

        // Add MenuItem
        menuItems.add(new MenuItem(itemId, name, category, price, available, loggedInUser));
        lastMessage = "Menu item created successfully!";
    }

 

    public void updateProduct(String itemId, double newPrice) throws InvalidDataException {
        if (!requirePermission(UPDATE_PRODUCT)) return;
        if (newPrice <= 0) throw new InvalidDataException("Price must be greater than 0.");

        for (MenuItem item : menuItems) {
            if (item.getItemId().equals(itemId)) {
                item.setPrice(newPrice);
                lastMessage = "Menu item " + itemId + " updated to $" + newPrice;
                System.out.println(lastMessage);
                return;
            }
        }
        throw new InvalidDataException("Menu item not found.");
    }

    public void viewReport(int month) throws InvalidDataException{
        if (!requirePermission(VIEW_REPORT)) return;
        if (month < 1 || month > 12) {
            throw new InvalidDataException("Month must be between 1 and 12.");
        }
        System.out.println("=== Report for Month " + month + " ===");

        if (menuItems.isEmpty()) {
            System.out.println("No products available.");
        } else {
            for (MenuItem item : menuItems) {
                System.out.println(item);
            }
        }
    }

    public void viewOrder(int orderId) throws InvalidDataException {
        if (!requirePermission(VIEW_ORDER)) return;

        if (orderId <= 0) {
            throw new InvalidDataException("Invalid order ID.");
        }

        System.out.println("=== View Order ===");
        System.out.println("Order feature is not available yet.");
        System.out.println("No orders have been created in the system.");
    }

    public void updateDeliveryStatus(int orderId) throws InvalidDataException {
        if (!requirePermission(UPDATE_DELIVERY_STATUS)) return;

        if (orderId <= 0) {
            throw new InvalidDataException("Invalid order ID.");
        }
        System.out.println("Order #" + orderId + " status updated to: DELIVERED");

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

    public ArrayList<Staff> getUsers() {
        return users;
    }
    public void demoPermissions() {
        System.out.println("Polymorphism Permission Test ");

        String[] actions = { CREATE_MENUITEM , UPDATE_PRODUCT,VIEW_REPORT , VIEW_ORDER, UPDATE_DELIVERY_STATUS };

        for (Staff s : users) {    
            
            System.out.println("\nUser: " + s.getUsername());
            for (String action : actions) {
                System.out.println("Can perform " + action + " ? " + s.can(action));
            }
        }
    }
    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void showInactiveStaff() {
        System.out.println("Inactive Staff:");

        showStaff(new StaffFilter() {
            @Override
            public boolean test(Staff s) {
                return !s.isActive();
            }
        });
    }

    public void showActiveStaff() {
        System.out.println("Active Staff:");
        showStaff(s -> s.isActive());
    }

    public void showDeliveryStaff() {
        System.out.println("Delivery Staff:");
        showStaff(s -> s instanceof Delivery);
    }

    public void showActiveDelivery() {
        System.out.println("Active Delivery Staff:");
        showStaff(s -> s instanceof Delivery && s.isActive());
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

    public Staff getLoggedInUser() {
        return loggedInUser;
    }
    
}