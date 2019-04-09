package marketWithPatternCommand.commands;

import marketWithPatternCommand.entity.Buyer;
import marketWithPatternCommand.entity.Item;
import marketWithPatternCommand.entity.Store;

public class Command2PutItemsInBucket implements Command {

    private Store store;
    private Buyer buyer;

    public Command2PutItemsInBucket(Store store, Buyer buyer) {
        this.store = store;
        this.buyer = buyer;
    }

    @Override
    public void execute() {
        String name = buyer.getNameOfItemToPutInBucket();
        int quantity = buyer.getQuantityOfItemToPutInBucket();

        store.takeItems(name, quantity);
        buyer.getBucket().putItem(name, new Item(name, store.getPriceByName(name), store.getCurrencyByName(name), quantity));
    }
}
