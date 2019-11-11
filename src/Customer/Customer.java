package Customer;

public class Customer {
    private String name;
    private boolean loyal;

    public Customer(String name, Boolean bool) {
        this.name = name;
        this.loyal = bool;
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

    void addPoints(){}
    void applyRewards(){}
}
