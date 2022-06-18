public enum phoneMAXsupport {
    _32 , _64 , _128 ;

    @Override
    public String toString() {
        switch (this){
            case _32:  return "Max 32 GB";
            case _64:  return "Max 64 GB";
            case _128: return "Max 128 GB";
            default:return null ;
        }
    }
}
