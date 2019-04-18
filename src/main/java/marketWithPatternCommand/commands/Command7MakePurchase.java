package marketWithPatternCommand.commands;

import marketWithPatternCommand.entity.Buyer;
import marketWithPatternCommand.entity.Orders;

public class Command7MakePurchase implements Command {

    private Buyer buyer;
    private Orders orders;

    public Command7MakePurchase(Buyer buyer, Orders orders) {
        this.buyer = buyer;
        this.orders = orders;
    }

    @Override
    public void execute() {
        orders.addOrder((new Buyer(buyer)).getBucket());
        buyer.getBucket().clear();
    }
}
