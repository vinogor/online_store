package patternMarket.commands;

import patternMarket.entity.Store;

public class CommandShowStore implements Command {

    private Store store;

    public CommandShowStore(Store store) {
        this.store = store;
    }

    @Override
    public void execute() {
        store.showStorage();
    }
}