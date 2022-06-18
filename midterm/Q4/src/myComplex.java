public class myComplex implements Numbers {
    private double i , r ;

    public myComplex(double r , double i){
        this.i = i ;
        this.r = r ;
    }

    public double getI() {
        return i;
    }

    public double getR() {
        return r;
    }

    public void setI(double i) {
        this.i = i;
    }

    public void setR(double r) {
        this.r = r;
    }


    @Override
    public String STR() {
        String s = "";
        s += String.valueOf(Math.round(this.r*10000.0)/10000.0)+" ";
        if(Math.round(this.i*10000.0)/10000.0 >= 0){
            s += "+";
        }
        s += String.valueOf(Math.round(this.i*10000.0)/10000.0)+"i";

        return s ;
    }
}
