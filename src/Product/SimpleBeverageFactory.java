package Product;

public class SimpleBeverageFactory {

    // encapsulate the creation of a tool

    public Beverage createBeverage(String type) {
        Beverage beverage = null;
        if (type.equals("Coffee")) {
            beverage = new Coffee();
        }

        return beverage;
    }
}
