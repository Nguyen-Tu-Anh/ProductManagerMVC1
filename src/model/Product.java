package model;

import java.time.LocalDateTime;

public class Product {
    private Integer id;
    private static Integer idNumber = 1;
    private String name;
    private double price;
    private int quantity;
    private String description;
    private LocalDateTime date;

    public Product(String name, double price, int quantity, String description) {
        this.id = idNumber++;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.date = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                ", localDate=" + date +
                '}' + '\n';
    }
}
