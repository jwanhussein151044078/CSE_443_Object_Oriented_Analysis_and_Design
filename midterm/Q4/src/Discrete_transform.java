import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * abstract class Discrete_transform.
 */
public abstract class Discrete_transform {
    private final int SIZE = 50 ;
    private final double round = 10000.0 ;

    /**
     * the calculate method reads N real number from a file and transform the numbers into (DFS or DCT) then write the output to the output file .
     * the execution time is printed on the screen if the user wanted to just in case of (DFS).
     * @param inputfile input file name .
     * @param outputfile output file name .
     */
    final void caculate(String inputfile , String outputfile){
        long startTime = 0;
        boolean flag = false;
        if(write_execution_time()){
            startTime = System.currentTimeMillis();
            flag = true ;
        }
        double[] inputarray  = read(inputfile);
        Numbers[] outputarray = Transform(inputarray);
        write(outputfile , outputarray);
        if(flag){
            long endTime = System.currentTimeMillis() - startTime;
            System.out.println("execution time  =  "+endTime+"ms");
        }
    }

    /**
     * Read N tab separated numbers from a file .
     * @param filename the input file name .
     * @return returns the read numbers as array of double .
     */
    public double[] read(String filename){
        double[] out = new double[SIZE];
        int capacity = SIZE;
        int count = 0 ;
        Scanner scan;
        File file = new File(filename);
        try {
            scan = new Scanner(file);
            while(scan.hasNextDouble())
            {
                if(count >= capacity){
                    capacity *= 2 ;
                    out = resizearray(out , capacity);
                }
                out[count] = scan.nextDouble();
                count++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        out = resizearray(out,count);
        return out ;
    }

    /**
     * writes the array to the file .
     * @param filename output file name .
     * @param array the array to be written .
     */
    public void write(String filename , Numbers[] array){
        int L = array.length;
        try {
            FileWriter myWriter = new FileWriter(filename);

            for(int i = 0 ; i < L ; i++){
                myWriter.write(array[i].STR()+"\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * transform the double[] in into (DFT or DCT) .
     * @param in the array to be converted .
     * @return return the (DFT or DCT) of the input array .
     */
    public abstract Numbers[] Transform(double[] in);

    /**
     * returns false by default means that the user don’t want to print the execution time on the screen .
     * @return returns false by default means that the user don’t want to print the execution time on the screen .
     */
    public boolean write_execution_time(){
        return false ;
    }

    private double[] resizearray(double[] array , int size){
        int old = array.length;
        double[] out = new double[size];
        int to = old;
        if(size < old){
            to = size;
        }
        for(int i = 0 ; i < to ; i++){
            out[i] = array[i];
        }
        return out ;
    }



}
