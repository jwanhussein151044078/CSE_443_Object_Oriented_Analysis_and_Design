import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 * class Server
 */
public class Server extends UnicastRemoteObject implements NewITable {
    private ITable table ;
    private Object[] sync;

    /**
     * class constructor.
     * @throws RemoteException
     */
    protected Server() throws RemoteException {
        super();

        Object[][] o = {{new String("one"),new String("two"),new String("three")},
                        {new String("four"),new String("five"),new String("six")},
                        {new String("seven"),new String("eight"),new String("nine") }};
        this.table = new Table(o);

        this.sync = new Object[o.length];
        for(int i = 0 ; i < o.length ; i++){
            this.sync[i] = new Object();
        }
    }

    public static void main(String args[]) {

        try {

            NewITable obj = new Server();
            //ITable stub = (ITable) UnicastRemoteObject.exportObject(obj, 0);
            // Bind the remote object's stub in the registry
            LocateRegistry.createRegistry(1099).bind("Table",obj);
            /*
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Table", obj);
            */
            System.out.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }

    /**
     * Returns the element at the specified position in this table .
     * @param row the row number of the element to return .
     * @param column the column number of the element to return .
     * @return the element at the specified position in this table .
     * @throws RemoteException
     */
    @Override
    public Object getElementAt(int row, int column) throws RemoteException {
        if(row < this.table.getNumberOfRows() && row >= 0 &&
           column < this.table.getNumberOfColumns() && column >=0 ){
            System.out.println("reader waiting :: ["+Thread.currentThread().getId()+"] \n\twill read from row:"+row+"\tcolumn:"+column);
            synchronized (this.sync[row]){
                System.out.println("reader in :: ["+Thread.currentThread().getId()+"]");
                Object ret = this.table.getElementAt(row,column);
                System.out.println("reader out :: ["+Thread.currentThread().getId()+"]");
                return ret ;
            }
        }
        return null ;
    }

    /**
     * Replaces the element at the specified position in this table with the specified element.
     * @param row the row number of the element to replace
     * @param column the column number of the element to replace
     * @param o element to be stored at the specified position
     * @throws RemoteException
     */
    @Override
    public void setElementAt(int row, int column, Object o) throws RemoteException {
        if(row < this.table.getNumberOfRows() && row >= 0 &&
                column < this.table.getNumberOfColumns() && column >=0 ){
            System.out.println("writer waiting :: ["+Thread.currentThread().getId()+"] \n\t will write to row:"+row+"\tcolumn:"+column+"\tobject:"+o);
            synchronized (this.sync[row]){
                System.out.println("writer in :: ["+Thread.currentThread().getId()+"]");
                this.table.setElementAt(row,column,o);
                System.out.println("writer out :: ["+Thread.currentThread().getId()+"]");
            }
        }
    }

    /**
     * retuens the number of the rows
     * @return the number of the rows
     * @throws RemoteException
     */
    @Override
    public int getNumberOfRows() throws RemoteException {
        return this.table.getNumberOfRows();
    }

    /**
     * returns the number of the columns
     * @return the number of the columns
     * @throws RemoteException
     */
    @Override
    public int getNumberOfColumns() throws RemoteException {

        return this.table.getNumberOfColumns();
    }

    /**
     * terminate the sever .
     * @param status
     */
    public static void terminate(int status){
        System.exit(status);
    }
}
