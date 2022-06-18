import java.util.Iterator;

/**
 * DataAnalyzer class
 */
public class DataAnalyzer {
    private DataPrinter clockWise;
    private DataPrinter antiClockWise;

    /**
     * class constructor .
     */
    public DataAnalyzer(ClockWise clockWise , AntiClockWise antiClockWise){
        this.antiClockWise = antiClockWise ;
        this.clockWise = clockWise ;
    }

    /**
     * print a 2D array spirally clockwise.
     */
    public void printClockWise(){
        Iterator it = clockWise.createIterator();
        System.out.println("print data clockwise :: ");
        while (it.hasNext()){
            System.out.print(it.next()+" ");
        }
        System.out.println();
    }

    /**
     * unsupported operation .
     */
    public void printAntiClockWise(){
        throw new UnsupportedOperationException();
    }
}
