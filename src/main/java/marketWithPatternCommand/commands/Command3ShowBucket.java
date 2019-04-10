package marketWithPatternCommand.commands;

import marketWithPatternCommand.entity.Buyer;

public class Command3ShowBucket implements Command{

       private Buyer buyer;

    public Command3ShowBucket(Buyer buyer) {
        this.buyer = buyer;
    }

    @Override
    public void execute() {
        buyer.getBucket().show();
    }
}
