public enum phoneRAM {
    _8 , _6 , _4 ;

    @Override
    public String toString() {
        switch (this){
            case _4:return "4GB";
            case _6:return "6GB";
            case _8:return "8GB";
            default:return null;
        }
    }
}
