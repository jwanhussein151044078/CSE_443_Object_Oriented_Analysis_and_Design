public enum phoneSupport {
    _16 , _32 , _64 ;

    @Override
    public String toString() {
        switch (this){
            case _16: return "MicroSD support, 16GB";
            case _32: return "MicroSD support, 32GB";
            case _64: return "MicroSD support, 64GB";
            default:return null ;
        }
    }
}
