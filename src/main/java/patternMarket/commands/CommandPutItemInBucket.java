package patternMarket.commands;

import patternMarket.entity.Bucket;
import patternMarket.entity.Buyer;
import patternMarket.entity.Item;
import patternMarket.entity.Store;

public class CommandPutItemInBucket implements Command {
    private Store store;
    private Bucket bucket;
    private Buyer buyer;


    public CommandPutItemInBucket(Store store, Bucket bucket, Buyer buyer) {
        this.store = store;
        this.bucket = bucket;
        this.buyer = buyer;
    }

    @Override
    public void execute() {
        String name = buyer.getName();
        int quantity = buyer.getQuantity();

        store.takeItems(name, quantity);
        bucket.putItem(name, new Item(name, store.getPriceByName(name), quantity));
    }
}
