public enum screenBit {
    _32,_24;

    @Override
    public String toString() {
        switch (this){
            case _24:return "24Bit";
            case _32:return "32Bit";
            default:return null;
        }
    }
}
