public enum phoneCPU {
    _2_8 , _2_2 ;

    @Override
    public String toString() {
        switch (this){
            case _2_2: return "2.2GHz";
            case _2_8: return "2.8GHz";
            default:return null ;
        }
    }
}
