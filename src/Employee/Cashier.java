package Employee;

import Cafe.*;
import Customer.Customer;
import Product.*;
import java.util.ArrayList;

public class Cashier extends Employee{
    SimpleBeverageFactory beverageFactory = new SimpleBeverageFactory();
    BeverageStore beverageStore = new BeverageStore(beverageFactory);

    SimplePastryFactory pastryFactory = new SimplePastryFactory();
    PastryStore pastryStore = new PastryStore(pastryFactory);


    public Cashier(String firstName, String lastName, int employeeID, Cafe cafe) {
        super(firstName, lastName,17, employeeID, cafe);
    }

    public void takeOrder(Order order) {
//        double price = 0.0;
        double price = order.execute();
        Barista barista = order.getBarista();
        Chef chef = order.getChef();

        // BARISTA
        barista.orderUp(order);



//
//        ArrayList<Product> finishedOrder = new ArrayList<Product>();
//        if (order.getBeverageOrder().size() > 0) {
//            for (int i = 0; i < order.getBeverageOrder().size(); i++) {
//                // BEVERAGE
//                Beverage beverage = beverageStore.createBeverage(order.getBeverageOrder().get(i));
//                beverage = addToppings(order.getToppings(), beverage);
//
//                barista.prepareOrder(order.getBeverageOrder().get(i));
//
//                getCafe().getInventoryRecord().update(order.getBeverageOrder().get(i), order.getBeverageOrder().size());
//
//                finishedOrder.add(beverage);
//                price = price + beverage.cost();
//            }
//        }
//
//        for (int i = 0; i < order.getKitchenOrder().size(); i++) {
//            // FOOD
//            String kitchenOrder = order.getKitchenOrder().get(i);
//            Pastry pastry = pastryStore.createPastry(kitchenOrder);
//
//            chef.prepareOrder(kitchenOrder);
//            getCafe().getInventoryRecord().update(order.getKitchenOrder().get(i), order.getKitchenOrder().size());
//
//            finishedOrder.add(pastry);
//            price = price + pastry.cost();
//        }

        double priceBeforeRewards = price;
        if (isRewardsCustomer(order)) {
            price = applyRewards(price);
        } else
        {
            if (askToSignUp()) {
                addNewLoyal(order.getCustomer());
                price = applyRewards(price);
            }
        }

        // add transaction to sales record
        Reciept reciept = new Reciept(order.getCustomer(), order, price, priceBeforeRewards - price);
        reciept.prettyPrint();
        getCafe().getSalesRecord().add(reciept);




        // update sales record
        this.getCafe().getSalesRecord().add(reciept);
        orderUp();
    }

    public Beverage addToppings(ArrayList<String> toppings, Beverage beverage) {
        Beverage modifiedBeverage = null;
        for (int i = 0; i < toppings.size(); i++) {
            if (toppings.get(i) == "Whip Cream") {
                modifiedBeverage = new WhipCream(beverage);
            }
        }
        return modifiedBeverage;
    }

    boolean isRewardsCustomer(Order order) {
        return order.getCustomer().isLoyal();
    }


    public boolean askToSignUp() {
        if(new java.util.Random().nextInt(8)==0){
            return true;
        }
        else
        {
            return false;
        }
    }

    void addNewLoyal(Customer customer) {
        customer.setLoyal(true);
    }

    double applyRewards(double price) {
        return price - 1.50;
    }

    void orderUp() {
        System.out.println("Order Up!");
    }

    void finishTransaction() {
        // params: Order: order
        // maybe return a reciept?
    }
}
