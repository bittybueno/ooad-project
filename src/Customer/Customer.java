package Customer;

public class Customer {
    private String name;
    private boolean loyal;
    private int loyaltyPoints;

    public Customer(String name, Boolean bool) {
        this.name = name;
        this.loyal = bool;
        this.loyaltyPoints = 0;
    }

    public boolean isLoyal() {
        return loyal;
    }

    public void setLoyal(boolean loyal) {
        this.loyal = loyal;
    }

    public String getName() {
        return name;
    }

    public int getLoyaltyPoints() { return this.loyaltyPoints;}

    public void setLoyaltyPoints(double newPoints ) {this.loyaltyPoints += newPoints;}
}
