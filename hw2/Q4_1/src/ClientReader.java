import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * class ClientReader
 */
public class ClientReader implements Runnable{
    private int row , col ;

    /**
     * class constructor
     * @param row the row number of the element to read
     * @param col the column number of the element to read
     */
    public ClientReader(int row , int col){
        this.col = col ;
        this.row = row ;
    }

    /**
     * start the reader .
     */
    @Override
    public void run() {
        try {
            System.out.println("Client (Reader) [id : "+Thread.currentThread().getId()+"] started\n\t" +
                    "reading from row:"+row+"\tcolumn:"+col);
            Registry registry = LocateRegistry.getRegistry("127.0.0.1");
            NewITable stub = (NewITable) registry.lookup("Table");
            Object o = stub.getElementAt(this.row,this.col);
            System.out.println("Server response to [id:"+Thread.currentThread().getId()+
                                "] :: " + o + "\tread from row:"+this.row+"\tcolumn:"+this.col );
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
