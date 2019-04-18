package marketWithPatternCommand.entity;

import java.io.Serializable;

public class Item implements Serializable {
    static final long serialVersionUID = 1L;

    private String name;
    private int price;
    private String currency; // RUB / USD
    private int quantity;

    public Item() {
    }

    public Item(String name, int price, String currency, int quantity) {
        this.name = name;
        this.price = price;
        this.currency = currency;
        this.quantity = quantity;
    }

    public Item(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getCurrency() {
        return currency;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setGivenQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void incQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void decQuantity(int quantity) {
        this.quantity -= quantity;
    }

    public void show() {
        System.out.print("" +
                " name - " + name +
                ", price - " + price +
                ", currency - " + currency +
                ", quantity - " + quantity
        );
    }
}
