package when.ut.unpredictable.multithreading;

/**
 * @author: when
 * @create: 2020-02-11  18:37
 **/
public class Counter {
    private int count;

    public void increment() {
        count++;
    }

    public int value() {
        return count;
    }
}
