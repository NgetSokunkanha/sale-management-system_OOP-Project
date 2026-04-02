package other;

import exception.InvalidDataException;
import user.IStaff; 

public class MenuItem {

    private String itemId;
    private String name;
    private String category; 
    private double price;
    private boolean available;

    private IStaff createdBy;

    public MenuItem(String itemId, String name, String category,
                    double price, boolean available, IStaff createdBy)
                    throws InvalidDataException {

        setCreatedBy(createdBy);  
        setItemId(itemId);
        setName(name);
        setCategory(category);
        setPrice(price);
        setAvailable(available);
    }

    public String getItemId() { return itemId; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public boolean isAvailable() { return available; }
    public IStaff getCreatedBy() { return createdBy; }

    public void setCreatedBy(IStaff createdBy) throws InvalidDataException {
        if (createdBy == null) {
            throw new InvalidDataException("Can not create menu item. Staff is required.");
        } else {
            this.createdBy = createdBy;
        }
    }

    public void setItemId(String itemId) throws InvalidDataException {
        if (isBlank(itemId)) {
            throw new InvalidDataException("Item ID can not be empty.");
        } else {
            this.itemId = itemId.trim();
        }
    }

    public void setName(String name) throws InvalidDataException {
        if (isBlank(name)) {
            throw new InvalidDataException("Item name can not be empty.");
        } else {
            this.name = name.trim();
        }
    }

    public void setCategory(String category) throws InvalidDataException {
        if (isBlank(category)) {
            throw new InvalidDataException("Item category can not be empty.");
        } else {
            this.category = category.trim();
        }
    }

    public void setPrice(double price) throws InvalidDataException {
        if (price < 0) {
            throw new InvalidDataException("Item price can not be negative.");
        }
        this.price = price;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    private boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }

    @Override
    public String toString() {
        return "MenuItem [itemId=" + itemId + ", name=" + name + ", category=" + category + ", price=" + price + ", available=" + available + ", createdBy=" + createdBy + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MenuItem other = (MenuItem) obj;
        return itemId.equalsIgnoreCase(other.itemId);
    }

}