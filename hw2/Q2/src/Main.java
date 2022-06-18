
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        ClockWise clockWise  = new ClockWise();
        AntiClockWise antiClockWise = new AntiClockWise();
        DataAnalyzer analyzer = new DataAnalyzer(clockWise,antiClockWise);
        int[][] data = generateData();
        System.out.println("generated data ::");
        print2d(data);
        clockWise.setData(data);
        analyzer.printClockWise();

    }


    /**
     * generate 2d array of integer . with random number of rows and columns , the array is filled randomly .
     * @return 2d integer array.
     */
    public static int[][] generateData(){
        Random rand = new Random();
        int r = rand.nextInt(10)+1;
        int c = rand.nextInt(10)+1;
        int[][] data = new int [r][c];
        for(int i = 0 ; i < r ; i++){
            for(int j=0 ; j < c ; j++){
                data[i][j] = rand.nextInt(256);
            }
        }
        return data ;
    }

    /**
     * print 2D integer array.
     * @param data the array to be printed.
     */
    public static void print2d(int[][] data){
        int r = data.length;
        int c = data[0].length;
        for(int i = 0 ; i < r ; i++){
            for(int j=0 ; j < c ; j++){
                System.out.print(data[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
