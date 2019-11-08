package Product;

public class WhipCream extends BeverageDecorator{
    Beverage beverage;
    public WhipCream(Beverage beverage) {
        this.beverage = beverage;
    }
    public String getDescription() {
        return beverage.getDescription() + ", Whip Cream";
    }
    public double cost() {
        return .20 + beverage.cost();
    }
}
