public class Staff {
    private int id;
    private String name;
    private String gender;
    private String role;

    public Staff(int id, String name, String gender, String role) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getRole() {
        return role;
    }

    public void updateProductPrice(Product product, double newPrice) {
        if (product != null && newPrice > 0) {
            product.setPrice(newPrice);
        }
    }
    public void updateProductName(Product product, String newName) {
        if (product != null && newName != null && !newName.isEmpty()) {
            product.setName(newName);
        }
    }

    public void reduceProductStock(Product product, int amount) {
        if (product != null && amount > 0) {
            product.reduceStock(amount);
        }
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

