public enum Battery_time {
    _27 , _20 , _16 ;

    @Override
    public String toString() {
        switch (this){
            case _16:return "16h";
            case _20:return "20h";
            case _27:return "27h";
            default:return null;
        }
    }
}
