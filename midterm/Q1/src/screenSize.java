public enum screenSize {
    _5_5,
    _5_3,
    _4_5;

    @Override
    public String toString() {
        switch (this){
            case _4_5:return "4.4 inches";
            case _5_3:return "5.3 inches";
            case _5_5:return "5.5 inches";
            default: return null ;
        }
    }
}
