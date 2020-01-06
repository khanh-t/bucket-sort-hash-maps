package Assignment4;

/**
 *
 * @author Khanh Tran
 */
import java.util.ArrayList;

public class ALChainHashMap<K,V> extends AbstractHashMap<K,V> {
    //a fixed capacity array of ArrayList that serve as buckets
    private ArrayList<MapEntry<K, V>>[] table;
    public ALChainHashMap() { super(); }
    public ALChainHashMap(int cap) { super(cap); }
    public ALChainHashMap(int cap, int p) { super(cap, p); }
    /** Creates an empty table having length equal to current capacity. */
    protected void createTable() {
        table = (ArrayList<MapEntry<K, V>>[]) new ArrayList[capacity];
    }
    /** Returns value associated with key k in bucket with hash value h, or else null */
    protected V bucketGet(int h, K k) {
        ArrayList<MapEntry<K,V>> bucket = table[h];
        if (bucket == null) return null;
        int j = findIndex(k, bucket);
        if (j == -1) return null;
        return bucket.get(j).getValue();
    }
    /**Associates key k with value v in bucket with hash value h; returns old value */
    protected V bucketPut(int h, K k, V v) {
        ArrayList<MapEntry<K,V>> bucket = table[h];
        if (bucket == null)
            bucket = table[h] = new ArrayList<>();
        int oldSize = bucket.size();
        int j = findIndex(k, bucket);
        if (j == -1) {
            bucket.add(new MapEntry<>(k,v));
            n += (bucket.size() - oldSize);
            return null;
        }
        else
            return bucket.get(j).setValue(v);
    }
    /**Removes entry having key k from bucket with hash value h (if any) */
    protected V bucketRemove(int h, K k) {
       ArrayList<MapEntry<K,V>> bucket = table[h];
       if (bucket == null) return null;
       int oldSize = bucket.size();
       int j = findIndex(k, bucket);
       if (j == -1) {
           return null;
       }
       V answer = bucket.get(j).getValue();
       if (j != oldSize - 1) {
           bucket.set(j, bucket.get(oldSize - 1));
       }
       bucket.remove(oldSize - 1);
       n -= (oldSize - bucket.size());
       return answer;
    }
    /** Returns the number of collisions that occurred in hash map */
    public int numCollisions() {
        int collisions = 0;
        for (ArrayList<MapEntry<K, V>> a : table) {
            if (a != null) {
                //if size is greater than 1, that means there was a collision
                collisions += a.size()-1;
            }
        }
        return collisions;
    }
    /** Finds the index a given key within bucket */
    private int findIndex(K k, ArrayList<MapEntry<K,V>> b) {
        int n = b.size();
        for (int j = 0; j < n; j++) {
            if (b.get(j).getKey().equals(k)) {
                return j;
            }
        }
        return -1;
    }
    /** Returns an iterable collection of all key-value entries of the map */
    public Iterable<Entry<K,V>> entrySet() {
        ArrayList<Entry<K,V>> buffer = new ArrayList<>();
        for (int h =0; h < capacity; h++)
            if (table[h] != null)
                for (Entry<K,V> entry : table[h].toArray(new Entry[table[h].size()]))
                    buffer.add(entry);
        return buffer;
    }
}
