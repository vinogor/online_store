package marketWithPatternCommand.commands;

import marketWithPatternCommand.entity.Bucket;
import marketWithPatternCommand.entity.Item;
import marketWithPatternCommand.entity.Store;

import java.util.Map;

public class CommandReturnItemsFromBucket implements Command {

    private Store store;
    private Bucket bucket;

    public CommandReturnItemsFromBucket(Store store, Bucket bucket) {
        this.store = store;
        this.bucket = bucket;
    }

    @Override
    public void execute() {
        String name;
        int quantity;
        for (Map.Entry<String, Item> entry : bucket.getBucketStorage().entrySet()) {
            name = entry.getKey();
            quantity = entry.getValue().getQuantity();
            store.putItems(name, quantity);
        }
        bucket.clear();
    }
}
