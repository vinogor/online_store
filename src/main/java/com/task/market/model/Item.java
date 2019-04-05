package com.task.market.model;

// карточка товара
// это POJO ?

public class Item {

    private static int nextId = 1;

    private  int id; // типо уникально
    private String name;
    private int price;
    private int quantity;

    // для склада (уник id)
    Item(String name, int price, int quantity) {
        this.id = nextId;
        nextId++;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // для корзины покупателя
    public Item(int id, String name, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
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

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void incQuantity() {
        this.quantity++;
    }

    public void decQuantity() {
        this.quantity--;
    }

    @Override
    public String toString() {
        return "Item {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
