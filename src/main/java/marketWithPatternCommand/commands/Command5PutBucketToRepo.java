package marketWithPatternCommand.commands;

import marketWithPatternCommand.SerializationOfBucket;
import marketWithPatternCommand.entity.Buyer;

public class Command5PutBucketToRepo implements Command {

    private Buyer buyer;

    public Command5PutBucketToRepo(Buyer buyer) {
        this.buyer = buyer;
    }

    @Override
    public void execute() {
        SerializationOfBucket.doSerialize(buyer.getBucket(), buyer.getName());
        buyer.getBucket().clear();
    }
}
