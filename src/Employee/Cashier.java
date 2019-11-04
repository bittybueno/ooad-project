package Employee;

public class Cashier extends Employee{

    public Cashier(String firstName, String lastName, int employeeID) {
        super(firstName, lastName,17, employeeID);
    }

    void takeOrder() {

    }

    boolean isRewardsCustomer() {
        return true;
    }

    void rewardsMemberSignUp() {

    }

    void askToSignUp() {

    }

    void addNewLoyal() {

    }

    void applyRewards() {

    }

    void orderUp() {

    }

    void finishTransaction() {
        // params: Order: order
        // maybe return a reciept?
    }
}
