package marketWithPatternCommand.commands;

import marketWithPatternCommand.entity.Bucket;

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
