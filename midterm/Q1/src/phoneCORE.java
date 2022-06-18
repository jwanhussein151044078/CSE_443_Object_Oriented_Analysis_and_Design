public enum phoneCORE {
    _2 , _4 , _8 ;

    @Override
    public String toString() {
        switch (this){
            case _2:return "2 cores";
            case _4:return "4 cores";
            case _8:return "8 cores";
            default:return null ;
        }
    }
}
