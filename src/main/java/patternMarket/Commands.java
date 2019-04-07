package patternMarket;

public class Commands {

    private Store store;

    public Commands(Store store) {
        this.store = store;
    }

    void showStore() {
        System.out.println("Show store!");
        store.showStorage();
    }
}