package marketWithPatternCommand.commands;

import marketWithPatternCommand.entity.Buyer;
import marketWithPatternCommand.entity.Item;
import marketWithPatternCommand.entity.Store;

import java.util.Map;

public class Command4ReturnItemsFromBucket implements Command {

    private Store store;
    private Buyer buyer;

    public Command4ReturnItemsFromBucket(Store store, Buyer buyer) {
        this.store = store;
        this.buyer = buyer;
    }

    @Override
    public void execute() {
        String name;
        int quantity;
        for (Map.Entry<String, Item> entry : buyer.getBucket().getBucketStorage().entrySet()) {
            name = entry.getKey();
            quantity = entry.getValue().getQuantity();
            store.putItems(name, quantity);
        }
        buyer.getBucket().clear();
    }
}
