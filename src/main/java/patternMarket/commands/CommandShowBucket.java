package patternMarket.commands;

import patternMarket.entity.Bucket;

public class CommandShowBucket  implements Command{

    private Bucket bucket;

    public CommandShowBucket(Bucket bucket) {
        this.bucket = bucket;
    }

    @Override
    public void execute() {
        bucket.show();
    }
}
