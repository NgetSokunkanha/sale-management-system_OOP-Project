public class Product {
    private String barcodeProduct;
    private String name;
    private double price;
    private int stock;
    private String expireDate;

    private static int productCount = 0;

    public Product(String barcodeProduct, String name, double price, int stock, String expireDate) {
        this.barcodeProduct = barcodeProduct;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.expireDate = expireDate;
        productCount++;
    }

    public static int getProductCount() {
        return productCount;
    }

    public String getBarcodeProduct() {
        return barcodeProduct;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        }
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public void reduceStock(int amount) {
        if (amount > 0 && amount <= stock) {
            stock -= amount;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Product product = (Product) obj;
        
        return barcodeProduct.equals(product.barcodeProduct);
    }

    @Override
    public String toString() {
        return "Product{" +
                "barcode:'" + barcodeProduct +
                ", name:'" + name +
                ", price:" + price +
                ", stock:" + stock +
                ", expireDate: " + expireDate +
                '}';
    }
}


