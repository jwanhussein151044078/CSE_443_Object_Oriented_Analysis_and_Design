import java.rmi.Remote;
import java.rmi.RemoteException;

public interface NewITable extends Remote {
    /**
     * Returns the element at the specified position in this table .
     * @param row the row number of the element to return .
     * @param column the column number of the element to return .
     * @return the element at the specified position in this table .
     */
    public Object getElementAt(int row, int column)throws RemoteException;
    /**
     * Replaces the element at the specified position in this table with the specified element.
     * @param row the row number of the element to replace
     * @param column the column number of the element to replace
     * @param o element to be stored at the specified position
     */
    public void setElementAt(int row, int column, Object o)throws RemoteException;
    /**
     * retuens the number of the rows
     * @return the number of the rows
     */
    public int getNumberOfRows()throws RemoteException;
    /**
     * returns the number of the columns
     * @return the number of the columns
     */
    public int getNumberOfColumns()throws RemoteException;
}
