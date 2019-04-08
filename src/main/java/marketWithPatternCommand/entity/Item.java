package marketWithPatternCommand.entity;

public class Item {
    private String name;
    private int price;
    private int quantity;


    public Item(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
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

    public void setGivenQuantity(int quantity) {
        this.quantity += quantity;
    }



    public void incQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void decQuantity(int quantity) {
        this.quantity -= quantity;
    }

    @Override
    public String toString() {
        return "    Item {" +
                "  name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}