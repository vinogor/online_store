package marketWithPatternCommand.entity.strategyForBucket;

public class CalcActualPriceUSD implements Strategy {
    @Override
    public int execute(int price) {
        System.out.println("    Determine the price of goods purchased for USD...");
        return price * 10;
    }
}
