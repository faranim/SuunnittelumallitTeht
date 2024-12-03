package Iterator;

import java.util.Iterator;

public class FibonacciIterator implements Iterator<Integer> {
    private int current;
    private int previous;

    public FibonacciIterator() {
        this.current = 0;
        this.previous = 1;
    }
    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        int nextValue = previous + current;
        previous = current;
        current = nextValue;
        return previous;
    }



}
