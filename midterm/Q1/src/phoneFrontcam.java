public enum phoneFrontcam {
    _12 , _8 ;

    @Override
    public String toString() {
        switch (this){
            case _12: return "12Mp front";
            case _8: return "8Mp front";
            default:return null;
        }
    }
}
