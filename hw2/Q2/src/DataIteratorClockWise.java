import java.util.Iterator;

/**
 * class DataIteratorClockWise.
 * implement Iterator.
 */
public class DataIteratorClockWise implements Iterator<Integer> {

    private int[][] Data ;
    private int[] Data1D ;
    private int pos ;

    /**
     * class constructor.
     * @param Data the object to be iterated .
     */
    public DataIteratorClockWise(int[][] Data){
        this.Data = Data;
        this.pos = 0 ;
        this.Data1D = fillArray(Data);

    }

    /**
     * Returns true if the iteration has more elements.
     * @return Returns true if the iteration has more elements.
     */
    @Override
    public boolean hasNext() {
        return pos < this.Data1D.length;
    }

    /**
     * Returns the next element in the iteration.
     * @return Returns the next element in the iteration.
     */
    @Override
    public Integer next() {
        return this.Data1D[this.pos++];
    }

    /**
     * throws UnsupportedOperationException , the method is not implemented .
     */
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    private int[] fillArray(int[][] Data){
        int R = Data.length;
        int C = Data[0].length;
        int sx = 0 , sy = 0 ;
        int counter = 0;
        int[] d = new int[R*C];

        while (sx < R && sy < C){
            for(int i = sy ; i < C ; i++){
                d[counter++] = Data[sx][i];
            }
            sx++;
            for(int i = sx ; i < R ; i++){
                d[counter++] = Data[i][C-1];
            }
            C--;
            if(sx < R){
                for(int i = C-1 ; i >= sy ; i--){
                    d[counter++] = Data[R-1][i];
                }
                R--;
            }
            if(sy < C){
                for(int i = R-1 ; i >= sx ; i--){
                    d[counter++] = Data[i][sy];
                }
                sy++;
            }
        }
        return d;
    }
}
