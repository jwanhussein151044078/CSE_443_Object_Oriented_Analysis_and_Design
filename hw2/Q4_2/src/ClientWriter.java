import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * class ClientWriter.
 */
public class ClientWriter implements Runnable {
    private int row , col ;
    private Object obj;
    /**
     * class constructor
     * @param row the row number of the element to write
     * @param col the column number of the element to write
     * @param obj the element to write.
     */
    public ClientWriter(int row , int col , Object obj){

        this.obj = obj ;
        this.col = col ;
        this.row = row ;
    }
    /**
     * start the Writer .
     */
    @Override
    public void run() {

        try {
            System.out.println("Client (Writer) [id : "+Thread.currentThread().getId()+"] started\n\t" +
                                "writing to row:"+row+"\tcolumn:"+col+"\t object: "+obj);
            Registry registry = LocateRegistry.getRegistry("127.0.0.1");
            NewITable stub = (NewITable) registry.lookup("Table");
            stub.setElementAt(this.row,this.col,this.obj);
            System.out.println("\"Client (Writer) [id :"+Thread.currentThread().getId()+"] finished");
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
