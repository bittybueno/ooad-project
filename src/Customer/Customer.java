package Customer;

public class Customer {
    private String name;
    private boolean loyal;

    public boolean isLoyal() {
        return loyal;
    }

    public void setLoyal(boolean loyal) {
        this.loyal = loyal;
    }

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    void addPoints(){}
    void applyRewards(){}



}
