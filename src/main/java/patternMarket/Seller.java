package patternMarket;

public class Seller {

    private Store store;

    public Seller(Store store) {
        this.store = store;
        commands = new Commands(this.store);
        showStore = new CommandShowStore(commands);
    }

    private Commands commands;

    private Command showStore;

    void showStore() {
        showStore.execute();
    }
}
