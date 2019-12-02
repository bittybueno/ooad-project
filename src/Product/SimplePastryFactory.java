package Product;

public class SimplePastryFactory {
    // encapsulate the creation of a pastry

    public Pastry createPastry(String type) {
        Pastry pastry = null;
        if (type.equals("Muffin")) {
            pastry = new Muffin();
        }
        if (type.equals("Bread")) {
            pastry = new Bread();
        }

        return pastry;
    }
}
