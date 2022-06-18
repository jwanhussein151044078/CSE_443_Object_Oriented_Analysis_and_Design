
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Server.main(args);
        int numwriter = 3 ;
        int numreader = 25;
        int counter = 0;
        Random r = new Random();
        int row = getnumrow();
        int col = getnumcol();
        ClientWriter[] clientWriter = new ClientWriter[numwriter];
        ClientReader[] clientReaders = new ClientReader[numreader];
        Thread[] threads = new Thread[numwriter+numreader];
        for(int i = 0 ; i < numreader ; i++){
            clientReaders[i] = new ClientReader(r.nextInt(row),r.nextInt(col));
            threads[counter++] = new Thread(clientReaders[i]);
        }
        for(int i = 0 ; i < numwriter ; i++){
            int leftLimit = 97; // letter 'a'
            int rightLimit = 122; // letter 'z'
            int targetStringLength = 10;
            Random random = new Random();

            String generatedString = random.ints(leftLimit, rightLimit + 1)
                    .limit(targetStringLength)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
            clientWriter[i] = new ClientWriter(r.nextInt(row),r.nextInt(col),(Object)generatedString);
            threads[counter++] = new Thread(clientWriter[i]);
        }
        for(int i = 0 ; i < numreader+numwriter ; i++){
            threads[i].start();
        }



        try {
            for(int i = 0 ; i < numreader+numwriter ; i++){
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Server.terminate(0);
    }

    public static int getnumrow(){
        int r = -1 ;
        try {

            Registry registry = LocateRegistry.getRegistry("127.0.0.1");
            NewITable stub = (NewITable) registry.lookup("Table");
            r = stub.getNumberOfRows();
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
        return r ;
    }
    public static int getnumcol(){
        int c = -1 ;
        try {

            Registry registry = LocateRegistry.getRegistry("127.0.0.1");
            NewITable stub = (NewITable) registry.lookup("Table");
            c = stub.getNumberOfColumns();
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
        return c ;
    }
}
