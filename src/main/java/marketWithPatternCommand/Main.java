package marketWithPatternCommand;

import marketWithPatternCommand.entity.Buyer;
import marketWithPatternCommand.entity.Store;
import static marketWithPatternCommand.Constants.*;

public class Main {

    public static void main(String[] args) {

        Store store = new Store();
        store.addItem("Car", 100, USD,10);
        store.addItem("Pistol", 50, RUB, 100);
        store.addItem("Pencil", 10, RUB, 1);

        Buyer buyer = new Buyer("Sasha", 5000);

        Market market = new Market(store, buyer);
        market.start();
    }
}