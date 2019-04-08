package marketWithPatternCommand.entity.strategyForBucket;

public class CalcActualPriceRUB implements Strategy {
    @Override
    public int execute(int price) {
        System.out.println("    Определяем цену товара, купленного за RUB");
        return price;
    }
}
