package Iterator;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        FibonacciSequence fibonacciSequence = new FibonacciSequence();
        Iterator<Integer> iterator = fibonacciSequence.iterator();
        int count = 10;

        // Print the first 10 Fibonacci numbers
        while (iterator.hasNext() && count-- > 0) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}

