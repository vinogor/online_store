package patternCommand3;

public class Bayer {

    private Command put;
    private Command ret;
    private Command sho;

    public Bayer(Command put, Command ret, Command sho) {
        this.put = put;
        this.ret = ret;
        this.sho = sho;
    }

    public void putItem() {
        put.execute();
    }

    public void retBask() {
        ret.execute();
    }

    public void shoBask() {
        sho.execute();
    }
}
