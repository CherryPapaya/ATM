import java.util.HashMap;
import java.util.Map;

public class CustomerDB {
    private Map<Integer, Customer> customers;

    public CustomerDB() {
        this.customers = new HashMap<>();
    }

    public void addCustomer(Customer customer) {
        this.customers.put(customer.getCustomerID(), customer);
    }

    public boolean customerExists(int customerID) {
        return this.customers.containsKey(customerID);
    }

    public Customer getCustomer(int customerID) {
        return this.customers.get(customerID);
    }
}
