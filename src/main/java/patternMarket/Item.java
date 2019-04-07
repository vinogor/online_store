package patternMarket;

public class Item {
    private String name;
    private int price;
    private int quantity;


    Item(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        System.out.println("    на склад завезли новый товар " + name + " в кол-ве " + quantity + " шт., цена: " + price);
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
        System.out.println("    увеличиваем код-во товара на складе " + name + " на " + quantity + ". Итого стало: " + this.quantity);
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
                "  name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
