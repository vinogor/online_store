package marketWithPatternCommand.commands;

import marketWithPatternCommand.SerializationOfBucket;
import marketWithPatternCommand.entity.Bucket;
import marketWithPatternCommand.entity.Buyer;

public class Command6TakeBucketFromRepo implements Command {

    private Buyer buyer;

    public Command6TakeBucketFromRepo(Buyer buyer) {
        this.buyer = buyer;
    }

    @Override
    public void execute() {
        Bucket bucket = SerializationOfBucket.doUnSerialize(buyer.getName());
        buyer.setBucket(bucket);
    }
}
