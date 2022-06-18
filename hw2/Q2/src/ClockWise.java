import java.util.Iterator;

/**
 * class ClockWise
 */
public class ClockWise implements DataPrinter{
    private int[][] Data;

    /**
     * class constructor.
     */
    public ClockWise(){}
    /**
     * returns an iterator over the 2D array spirally clockwise.
     * @return returns an iterator over the 2D array spirally clockwise.
     */
    @Override
    public Iterator createIterator(){
        return new DataIteratorClockWise(Data);
    }
    /**
     * setter .
     * @param data new data .
     */
    public void setData(int[][] data) {
        this.Data = data;
    }
}
