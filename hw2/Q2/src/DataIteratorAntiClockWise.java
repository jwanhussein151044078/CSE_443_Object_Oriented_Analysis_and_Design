import java.util.Iterator;

/**
 * class DataIteratorAntiClockWise.
 * implements Iterator
 */
public class DataIteratorAntiClockWise implements Iterator<Integer> {
    private int[][] Data ;

    /**
     * class constructor.
     * @param Data the object to be iterated .
     */
    public DataIteratorAntiClockWise(int[][] Data){

    }
    /**
     * throws UnsupportedOperationException , the method is not implemented .
     */
    @Override
    public boolean hasNext() {
        throw new UnsupportedOperationException();
    }
    /**
     * throws UnsupportedOperationException , the method is not implemented .
     */
    @Override
    public Integer next() {
        throw new UnsupportedOperationException();
    }
    /**
     * throws UnsupportedOperationException , the method is not implemented .
     */
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
