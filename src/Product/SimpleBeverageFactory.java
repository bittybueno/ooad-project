package Product;

// FACTORY

public class SimpleBeverageFactory {
    // encapsulate the creation of a beverage

    public Beverage createBeverage(String type) {
        Beverage beverage = null;
        if (type.equals("Coffee")) {
            beverage = new Coffee();
        }
        if (type.equals("Espresso")) {
            beverage = new Espresso();
        }
        if (type.equals("Tea")) {
            beverage = new Tea();
        }

        return beverage;
    }
}
