package marketWithPatternCommand.commands;

import marketWithPatternCommand.entity.Bucket;
import marketWithPatternCommand.entity.Buyer;
import marketWithPatternCommand.entity.Item;
import marketWithPatternCommand.entity.Store;

public class CommandPutItemsInBucket implements Command {
    private Store store;
    private Bucket bucket;
    private Buyer buyer;


    public CommandPutItemsInBucket(Store store, Bucket bucket, Buyer buyer) {
        this.store = store;
        this.bucket = bucket;
        this.buyer = buyer;
    }

    @Override
    public void execute() {
        String name = buyer.getName();
        int quantity = buyer.getQuantity();

        store.takeItems(name, quantity);
        bucket.putItem(name, new Item(name, store.getPriceByName(name), store.getCurrencyByName(name), quantity));
    }
}
