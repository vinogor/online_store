package marketWithPatternCommand.entity.strategyForBucket;

public class CalcActualPriceUSD implements Strategy {
    @Override
    public int execute(int price) {
        System.out.println("    Определяем цену товара, купленного за USD");
        return price * 10;
    }
}
