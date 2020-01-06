package Assignment4;

/**
 *
 * @author Khanh Tran
 */
public class Fragment {
    private int key;
    private String value;

    public Fragment(int key, String value) {
        this.key = key;
        this.value = value;
    }
    
    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
