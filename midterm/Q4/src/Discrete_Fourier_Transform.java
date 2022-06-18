import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Discrete_Fourier_Transform extends Discrete_transform {
    @Override
    public Numbers[] Transform(double[] in) {
        int N = in.length;
        myComplex[] out = new  myComplex[N];
        double w = 2*Math.PI / N ;
        for(int k = 0 ; k < N ; k++){
            out[k] = new myComplex(0,0);
            for (int n = 0 ; n < N ; n++){
                out[k].setR(out[k].getR()+in[n]*Math.cos(w*k*n));
                out[k].setI(out[k].getI()-in[n]*Math.sin(w*k*n));
            }
        }
        return out ;
    }

    @Override
    public boolean write_execution_time(){
        String answer = getUserInput();
        if (answer.toLowerCase().startsWith("y")) {
            return true;
        } else {
            return false;
        }
    }

    private String getUserInput() {
        String answer = null;
        System.out.print("Would you like the time of execution printed on screen  (y/n)? ");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = in.readLine();
        } catch (IOException ioe) {
            System.err.println("IO error trying to read your answer");
        }
        if (answer == null) {
            return "no";
        }
        return answer;
    }
}
