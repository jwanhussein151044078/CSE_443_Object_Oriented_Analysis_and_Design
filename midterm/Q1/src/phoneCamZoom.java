public enum phoneCamZoom {
    _2 , _3 , _4 ;

    @Override
    public String toString() {
        switch (this){
            case _2: return "Opt.zoom x2";
            case _3: return "Opt.zoom x3";
            case _4: return "Opt.zoom x4";
            default:return null ;
        }
    }
}
