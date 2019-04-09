package marketWithPatternCommand.entity.strategyForBucket;

public class CalcActualPriceRUB implements Strategy {
    @Override
    public int execute(int price) {
        System.out.println("    Determine the price of goods purchased for RUB...");
        return price;
    }
}
