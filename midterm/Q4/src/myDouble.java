public class myDouble implements Numbers {
    private double d ;

    public myDouble(double d){
        this.d = d ;
    }

    @Override
    public String STR() {

        return String.valueOf(Math.round(this.d*10000.0)/10000.0);
    }

    public double getD(){
        return this.d ;
    }
    public void setD(double d){
        this.d = d ;
    }

}
