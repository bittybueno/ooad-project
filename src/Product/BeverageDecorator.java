package Product;

// DECORATOR DESIGN PATTERN

public abstract class BeverageDecorator extends Beverage {
    public abstract String getDescription();
    public abstract double cost();
}
