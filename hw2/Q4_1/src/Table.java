/**
 * class Table.
 */
public class Table implements ITable{
    private Object[][] table ;

    /**
     * class constructor.
     * @param obj the table .
     */
    public Table(Object[][] obj){
        this.table = obj ;
    }

    /**
     * Returns the element at the specified position in this table .
     * @param row the row number of the element to return .
     * @param column the column number of the element to return .
     * @return the element at the specified position in this table .
     */
    @Override
    public Object getElementAt(int row, int column) {
        if(row < this.table.length && column < this.table[0].length && row >=0 && column >= 0){
            return this.table[row][column];
        }
        return null ;
    }

    /**
     * Replaces the element at the specified position in this table with the specified element.
     * @param row the row number of the element to replace
     * @param column the column number of the element to replace
     * @param o element to be stored at the specified position
     */
    @Override
    public void setElementAt(int row, int column, Object o) {
        if(row < this.table.length && column < this.table[0].length && row >=0 && column >= 0){
            this.table[row][column] = o;
        }
    }

    /**
     * retuens the number of the rows
     * @return the number of the rows
     */
    @Override
    public int getNumberOfRows() {
        return this.table.length;
    }

    /**
     * returns the number of the columns
     * @return the number of the columns
     */
    @Override
    public int getNumberOfColumns() {
        return this.table[0].length;
    }
}
