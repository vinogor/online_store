package marketWithPatternCommand.entity;

public interface StoreInterface {
    void addItem(String name, int price, String currency, int quantity);
    void addItem(Item item);
    void showStorage();
}
