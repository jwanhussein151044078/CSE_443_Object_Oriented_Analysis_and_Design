
public class Discrete_Cosine_Transform extends Discrete_transform {
    @Override
    public Numbers[] Transform(double[] in) {
        int N = in.length;
        myDouble[] out = new myDouble[N];
        double w = Math.PI/N ;

        for(int k = 0 ; k < N ; k++){
            out[k] = new myDouble(0);
            for (int n = 0 ; n < N ; n++){
                out[k].setD(out[k].getD()+in[n]*Math.cos(w*k*(n+0.5)));
            }
        }
        return out ;
    }
}
