package Product;

public  class BeverageStore {

    SimpleBeverageFactory factory;

    public BeverageStore(SimpleBeverageFactory factory) {
        this.factory = factory;
    }
    public Beverage createBeverage(String type) {
        Beverage beverage;
        beverage = factory.createBeverag(type);
        return beverage;
    }

}
