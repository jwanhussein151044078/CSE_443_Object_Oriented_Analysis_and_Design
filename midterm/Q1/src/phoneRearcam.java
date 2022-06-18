public enum phoneRearcam {
    _5 , _8 ;

    @Override
    public String toString() {
        switch (this){
            case _5: return "5Mp rear";
            case _8: return "8Mp rear";
            default:return null;
        }
    }
}
