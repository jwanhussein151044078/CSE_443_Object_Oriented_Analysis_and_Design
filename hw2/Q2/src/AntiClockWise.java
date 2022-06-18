import java.util.Iterator;

/**
 * class AntiClockWise
 */
public class AntiClockWise implements DataPrinter {
    private int[][] Data ;
    /**
     * class constructor.
     */
    public AntiClockWise(){}

    /**
     * returns an iterator over the 2D array spirally anti-clockwise.
     * @return returns an iterator over the 2D array spirally anti-clockwise.
     */
    @Override
    public Iterator createIterator(){
        return new DataIteratorAntiClockWise(this.Data);
    }

    /**
     * setter .
     * @param data new data .
     */
    public void setData(int[][] data) {
        this.Data = data;
    }
}
