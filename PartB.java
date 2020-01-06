package Assignment4;

/**
 *
 * @author Khanh Tran
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Iterator;

public class PartB {
    public static void main(String[] args) throws FileNotFoundException {
        //Read file and create hash map of Orders
        File f = new File("C:\\Users\\khanh\\Desktop\\As4.csv");
        Scanner s = new Scanner(f);
        ALChainHashMap map = new ALChainHashMap();
        while (s.hasNextLine()) {
            Object lines[] = s.nextLine().split(",");
            String orderID = (String)lines[0];
            String customerID = (String)lines[1];
            double amount = Double.parseDouble((String)lines[2]);
            map.put(orderID, new Order(orderID, customerID, amount));
        }
        //Display list of orders
        Iterable iter = map.values();
        Iterator iterator = iter.iterator();
        while (iterator.hasNext()) {
            Order o = (Order)iterator.next();
            System.out.println(o.getOrderID() + ", " + o.getCustomerID() + 
                                ", " + o.getAmount());
        }
        //Display the number of orders
        System.out.println("Number of orders: " + map.size());
        //Display the number of collisions
        System.out.println("Number of collisions: " + map.numCollisions());
    }
}
