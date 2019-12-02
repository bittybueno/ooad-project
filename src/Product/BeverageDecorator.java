package Product;

// DECORATOR DESIGN PATTERN

public abstract class BeverageDecorator extends Beverage {
    private String type = "Add In";
    public abstract String getDescription();
    public abstract double cost();
}
