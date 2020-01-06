package Assignment4;

/**
 *
 * @author Khanh Tran
 */
public class Order {
    private String orderID;
    private String customerID;
    private double amount;

    public Order(String orderID, String customerID, double amount) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.amount = amount;
    }

    public String getOrderID() {
        return orderID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public double getAmount() {
        return amount;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
