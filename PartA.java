package Assignment4;

/**
 *
 * @author Khanh Tran
 */
import java.util.List;
import java.util.ArrayList;
public class PartA {
    
    public static void main(String[] args) {
        Fragment[] fragments = new Fragment[11];
        fragments[0] = new Fragment(9,"a ");
        fragments[1] = new Fragment(8,"using ");
        fragments[2] = new Fragment(4,"an ");
        fragments[3] = new Fragment(6,"bucket");
        fragments[4] = new Fragment(5,"of ");
        fragments[5] = new Fragment(1,"This ");
        fragments[6] = new Fragment(6,"-sort ");
        fragments[7] = new Fragment(9,"stable ");
        fragments[8] = new Fragment(4,"example ");
        fragments[9] = new Fragment(3,"is ");
        fragments[10] = new Fragment(9,"algorithm");
        
        bucketSort(fragments);
        
        for (Fragment obj: fragments)
            System.out.print(obj.getValue());
        System.out.println();
    }
    
    public static void bucketSort(Fragment[] array) {
        //find out the highest key in given Fragment array
        int size = highestKey(array)+1;
        //create bucket array using lists
        List[] buckets = new List[size];
        
        //move Fragment array into bucket array to sort it
        for (Fragment obj: array) {
            if (buckets[obj.getKey()] == null)
                buckets[obj.getKey()] = new ArrayList();
            buckets[obj.getKey()].add(obj);
        }
        
        //replace the unsorted Fragment array with the new sorted sequence
        int index=0;
        for (int i = 0; i < buckets.length; i++)
            if (buckets[i] == null) {
                //move on if bucket is null
            }
            else
                for (Object obj: buckets[i].toArray())
                    array[index++] = (Fragment) obj;
    }
    
    //private utility to find the highest key in given Fragment array
    private static int highestKey(Fragment[] array) {
        int highest=0;
        for (Fragment obj: array) 
            if (highest < obj.getKey()) 
                highest = obj.getKey();
        return highest;
    }
}
