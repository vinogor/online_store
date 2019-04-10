package marketWithPatternCommand.commands;

import marketWithPatternCommand.entity.Store;

public class Command1ShowStore implements Command {

    private Store store;

    public Command1ShowStore(Store store) {
        this.store = store;
    }

    @Override
    public void execute() {
        store.showStorage();
    }
}