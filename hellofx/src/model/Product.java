package model;

public class Product {
    private int id;
    private String category;
    private String name;
    private int quantity;
    private String description;
    private double price;

    public Product(int id, String category, String name,
                   int quantity, String description, double price) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.quantity = quantity;
        this.description = description;
        this.price = price;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    /** Trả về thông tin ở định dạng “id - category - name - quantity - price” */
    public String get_info() {
        return String.format("%d - %s - %s - %d - %.2f",
                id, category, name, quantity, price);
    }
}