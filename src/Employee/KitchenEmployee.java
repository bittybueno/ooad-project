package Employee;

// TEMPLATE DESIGN PATTERN

import Cafe.Order;

public interface KitchenEmployee {
    void serve(String type);
    void orderUp(Order order);
}
