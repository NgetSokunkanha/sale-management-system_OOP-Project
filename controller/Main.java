package controller;
import java.util.Scanner;

import exception.AuthenticationException;
import exception.InvalidDataException;
import other.MenuItem;
import user.Staff; 
public class Main {

    public static void main(String[] args)  {

        MiniMartShop shop = new MiniMartShop();
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {

            System.out.println("====== MiniMart System ======\n");
            System.out.println("1. Login");
            System.out.println("2. Sign Up");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        handleLogin(shop, sc);
                        break;
                    case 2:
                        handleSignup(shop, sc);
                        break;
                    case 3:
                        running = false;
                        System.out.println("Program ended.");
                        break;
                    default:
                        System.out.println("Invalid option.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            } finally {
                System.out.println("Operation finished.");
            }
        }
        sc.close();
    }

    private static void handleLogin(MiniMartShop shop, Scanner sc) {
        try {
            System.out.print("Username: ");
            String username = sc.nextLine();
            System.out.print("Password: ");
            String password = sc.nextLine();
            shop.login(username, password);

            System.out.println(shop.getLastMessage());

            if (shop.isUserLoggedIn()) {
                System.out.println("Login as: \n");
                System.out.println("1. Customer");
                System.out.println("2. Staff");
                System.out.print("Choose: ");

                int role = Integer.parseInt(sc.nextLine());
                if (role == 1) {
                    System.out.println("System is currently upgrading.");
                    System.out.println("Customer functions will be available soon.");

                } else if (role == 2) {
                    staffMenu(shop, sc);
                } else {

                    System.out.println("Invalid role selection.");
                }
            }

        } catch (AuthenticationException e) {
            System.out.println("Login error: " + e.getMessage());

        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid number.");
        }
    }

    private static void handleSignup(MiniMartShop shop, Scanner sc) {
        String id = null, username = null, password = null, gender = null;
        int role = 0;

        System.out.println("=== Sign Up ===\n");

        while (id == null) {
            try {
                System.out.print("Staff ID: ");
                String input = sc.nextLine().trim();
                if (input.length() != 6 || !input.chars().allMatch(Character::isDigit))
                    throw new InvalidDataException("Staff ID must be exactly 6 digits.");

                boolean exists = false;
                for (Staff s : shop.getUsers()) {
                    if (s.getId().equals(input)) {
                        exists = true; break;
                    }
                }
                if (exists) throw new InvalidDataException("Staff ID already exists.");

                id = input; 
            } catch (InvalidDataException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        while (username == null) {
            try {
                System.out.print("Username: ");
                String input = sc.nextLine().trim();
                if (input.isEmpty()) throw new InvalidDataException("Username can not be empty.");
                if (!input.chars().allMatch(Character::isLetter))
                    throw new InvalidDataException("Username must contain letters only.");
                boolean exists = false;
                for (Staff s : shop.getUsers()) {
                    if (s.getUsername().equalsIgnoreCase(input)) {
                        exists = true; break;
                    }
                }
                if (exists) throw new InvalidDataException("Username already exists.");

                username = input;
            } catch (InvalidDataException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        while (password == null) {
            try {
                System.out.print("Password: ");
                String input = sc.nextLine().trim();
                if (input.length() < 6 || !input.chars().allMatch(Character::isDigit))
                    throw new InvalidDataException("Password must be at least 6 digits and numbers only.");
                password = input; 
            } catch (InvalidDataException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        while (gender == null) {
            try {
                System.out.print("Gender (Male/Female): ");
                String input = sc.nextLine().trim();
                if (!input.equalsIgnoreCase("Male") && !input.equalsIgnoreCase("Female"))
                    throw new InvalidDataException("Gender must be 'Male' or 'Female'.");
                gender = input;
            } catch (InvalidDataException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        while (role == 0) {
            try {
                System.out.println("Choose Role:");
                System.out.println("1. Admin");
                System.out.println("2. Manager");
                System.out.println("3. Delivery");
                System.out.print("Enter role: ");
                int inputRole = Integer.parseInt(sc.nextLine());
                if (inputRole < 1 || inputRole > 3) throw new InvalidDataException("Invalid role selection.");
                role = inputRole;
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a number for role.");
            } catch (InvalidDataException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        try {
            shop.signUpStaff(id, username, password, gender, role);
            System.out.println(shop.getLastMessage());
        } catch (InvalidDataException e) {
            System.out.println("Unexpected signup error: " + e.getMessage());
        }
    }

    private static void staffMenu(MiniMartShop shop, Scanner sc) {
        boolean logged = true;
        while (logged) {
            System.out.println("===== Staff Menu =====\n");
            System.out.println("1. Create Menu Item");
            System.out.println("2. Update Menu Item");
            System.out.println("3. View Report");
            System.out.println("4. View Order");
            System.out.println("5. Update Delivery Status");
            System.out.println("6. Logout");
            System.out.print("Choose: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1: 
                        String id = null, name = null, category = null;
                        double price = 0;

                        while (id == null) {
                            try {
                                System.out.print("Item ID: ");
                                String input = sc.nextLine().trim();

                                if (input.length() != 6 || !input.chars().allMatch(Character::isDigit))
                                    throw new InvalidDataException("Item ID must be exactly 6 digits.");

                                boolean exists = false;
                                for (MenuItem item : shop.getMenuItems()) {
                                    if (item.getItemId().equals(input)) {
                                        exists = true;
                                        break;
                                    }
                                }
                                if (exists) throw new InvalidDataException("Item ID already exists.");

                                id = input; 
                            } catch (InvalidDataException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                        }

                        while (name == null) {
                            try {
                                System.out.print("Name: ");
                                String input = sc.nextLine().trim();

                                if (input.isEmpty()) throw new InvalidDataException("Name cannot be empty.");
                                for (char c : input.toCharArray()) {
                                    if (!Character.isLetter(c) && c != ' ')
                                        throw new InvalidDataException("Name must contain letters only.");
                                }

                                boolean exists = false;
                                for (MenuItem item : shop.getMenuItems()) {
                                    if (item.getName().equalsIgnoreCase(input)) {
                                        exists = true;
                                        break;
                                    }
                                }
                                if (exists) throw new InvalidDataException("Name already exists.");

                                name = input; 
                            } catch (InvalidDataException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                        }

                        while (category == null) {
                            try {
                                System.out.print("Category: ");
                                String input = sc.nextLine().trim();

                                if (input.isEmpty()) throw new InvalidDataException("Category cannot be empty.");
                                for (char c : input.toCharArray()) {
                                    if (!Character.isLetter(c) && c != ' ')
                                        throw new InvalidDataException("Category must contain letters only.");
                                }

                                category = input; 
                            } catch (InvalidDataException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                        }

                        while (price <= 0) {
                            try {
                                System.out.print("Price: ");
                                String input = sc.nextLine().trim();
                                double temp = Double.parseDouble(input);

                                if (temp <= 0) throw new InvalidDataException("Price must be greater than 0.");
                                price = temp; 
                            } catch (NumberFormatException e) {
                                System.out.println("Error: Price must be a number.");
                            } catch (InvalidDataException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                        }

                        try {
                            shop.createMenuItem(id, name, category, price, true);
                            System.out.println(shop.getLastMessage());
                        } catch (InvalidDataException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 2: 
                        String itemId = null;
                        double newPrice = 0;

                        while (itemId == null) {
                            try {
                                System.out.print("Enter Item ID to update (6 digits): ");
                                String input = sc.nextLine().trim();

                                if (input.length() != 6 || !input.chars().allMatch(Character::isDigit))
                                    throw new InvalidDataException("Item ID must be exactly 6 digits.");

                                boolean exists = false;
                                for (MenuItem item : shop.getMenuItems()) {
                                    if (item.getItemId().equals(input)) {
                                        exists = true;
                                        break;
                                    }
                                }
                                if (!exists) throw new InvalidDataException("Item ID does not exist.");

                                itemId = input; 
                            } catch (InvalidDataException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                        }

                        while (true) {
                            try {
                                System.out.print("Enter new price: ");
                                String input = sc.nextLine().trim();
                                newPrice = Double.parseDouble(input);

                                if (newPrice <= 0)
                                    throw new InvalidDataException("Price must be greater than 0.");

                                // Update the product
                                shop.updateProduct(itemId, newPrice);
                                System.out.println(shop.getLastMessage());
                                break; // exit loop if success

                            } catch (NumberFormatException e) {
                                System.out.println("Error: Price must be a number.");
                            } catch (InvalidDataException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Enter month (1-12): ");
                        int month = Integer.parseInt(sc.nextLine());
                        shop.viewReport(month);
                        break;

                    case 4:
                        System.out.print("Enter order ID: ");
                        int orderId = Integer.parseInt(sc.nextLine());
                        shop.viewOrder(orderId);
                        break;

                    case 5:
                        System.out.print("Enter order ID: ");
                        int deliveryId = Integer.parseInt(sc.nextLine());
                        shop.updateDeliveryStatus(deliveryId);
                        break;

                    case 6:
                        shop.logout();
                        System.out.println(shop.getLastMessage());
                        logged = false;
                        break;

                    default:
                        System.out.println("Invalid option.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            } catch (InvalidDataException e) {
                System.out.println("Validation Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            } finally {
                System.out.println("Action completed.");
            }
        }
    }
        
}

