package konrad.junit.model;

import lombok.Data;
import lombok.ToString;

public class Item {
    private int id;
    private int price;
    private int quantity;
    private String name;

    public Item(int id, String name, int price, int quantity) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
