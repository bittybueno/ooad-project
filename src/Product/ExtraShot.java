package Product;

public class ExtraShot extends BeverageDecorator{
    Beverage beverage;
    public ExtraShot(Beverage beverage) {
        this.beverage = beverage;
    }
    public String getDescription() {
        return beverage.getDescription() + ", Extra Shot";
    }
    public double cost() { return .50 + beverage.cost(); }
}
