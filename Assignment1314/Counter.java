
public class Counter {
    private volatile long in = 0;
    
    public void increment() {
        long next_free_slot;

        next_free_slot = in;
        next_free_slot = next_free_slot + 1;
        in = next_free_slot;
    }

    public long getIn() {
      return in;
    }
}
