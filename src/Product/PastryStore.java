package Product;

public class PastryStore
{
    SimplePastryFactory factory;

    public PastryStore(SimplePastryFactory factory) {
        this.factory = factory;
    }

    public Pastry createPastry(String type) {
        Pastry pastry;
        pastry = factory.createPastry(type);
        return pastry;
    }
}
