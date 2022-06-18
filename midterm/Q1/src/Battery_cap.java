public enum Battery_cap {
    _3600 , _2800 , _2000 ;

    @Override
    public String toString() {
        switch (this){
            case _2000:return "2000mAh";
            case _2800:return "2800mAh";
            case _3600:return "3600mAh";
            default:return null;
        }
    }
}
